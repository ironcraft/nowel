package fr.ironcraft.nowel.worldgen;


import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;


public class WorldGenFir extends WorldGenerator
{

	private int logMeta = 1;
	private int leaveMeta = 1;

	@Override
	public boolean generate(World world, Random random, BlockPos pos)
	{

		//Return false if the block below isn't grass
		if (world.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())) != Blocks.grass.getDefaultState())
			return false;

		int randMid = random.nextInt(5) - 1; //Random the number of middle parts
		int trunk = random.nextInt(5) + 3; //Random the height of trunk
		int actualPosY = trunk + pos.getY();

		actualPosY = createPart(world, random, new BlockPos(pos.getX(), actualPosY, pos.getZ()), 5, 4);

		for (int i = 0; i < randMid; i++)
		{
			actualPosY = createPart(world, random, new BlockPos(pos.getX(), actualPosY, pos.getZ()), 4, 3);
		}

		actualPosY = createPart(world, random, new BlockPos(pos.getX(), actualPosY, pos.getZ()), 2, 4);
		createTrunk(world, pos, pos.getY(), actualPosY - 1);
		return true;
	}

	private void createTrunk(World world, BlockPos pos, int start, int end)
	{
		if (end <= start)
			return;

		for (int i = start; i < end; i++)
		{
			world.setBlockState(new BlockPos(pos.getX(), i, pos.getZ()), Blocks.log.getStateFromMeta(logMeta));
		}
	}

	private int createPart(World world, Random random, BlockPos pos, int startSize, int height)
	{
		if (height < 1)
			return pos.getY();

		for (int i = 0; i < height; i++)
		{
			new WorldGenSphere(Blocks.leaves.getStateFromMeta(leaveMeta), startSize - i, 0).generate(world, random, new BlockPos(pos.getX(), pos.getY() + i, pos.getZ()));
		}

		world.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), Blocks.log.getStateFromMeta(logMeta + 4));
		world.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), Blocks.log.getStateFromMeta(logMeta + 4));
		world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), Blocks.log.getStateFromMeta(logMeta + 8));
		world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), Blocks.log.getStateFromMeta(logMeta + 8));

		return pos.getY() + height;
	}

}
