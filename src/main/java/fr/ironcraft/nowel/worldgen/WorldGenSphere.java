package fr.ironcraft.nowel.worldgen;


import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;


public class WorldGenSphere extends WorldGenerator
{

	private IBlockState block;
	private int radiusX;
	private int radiusY;
	private boolean fill;

	WorldGenSphere()
	{
		setValues(Blocks.cobblestone.getDefaultState(), 1, 1, true);
	}

	WorldGenSphere(IBlockState block)
	{
		setValues(block, 1, 1, true);
	}

	WorldGenSphere(IBlockState block, int radius)
	{
		setValues(block, radius, radius, true);
	}

	WorldGenSphere(IBlockState block, int radiusX, int radiusY)
	{
		setValues(block, radiusX, radiusY, true);
	}

	WorldGenSphere(IBlockState block, int radiusX, int radiusY, boolean fill)
	{
		setValues(block, radiusX, radiusY, fill);
	}

	WorldGenSphere(IBlockState block, int radius, boolean fill)
	{
		setValues(block, radius, radius, fill);
	}

	public void setValues(IBlockState block, int radiusX, int radiusY, boolean fill)
	{
		this.block = block;
		this.radiusX = radiusX;
		this.radiusY = radiusY;
		this.fill = fill;
	}

	@Override
	public boolean generate(World world, Random random, BlockPos pos)
	{
		int radiusSq = this.radiusX * this.radiusX;
		int radiusSq2 = (this.radiusX - 1) * (this.radiusX - 1);

		for (int x = -this.radiusX; x <= this.radiusX; x++)
		{
			for (int z = -this.radiusX; z <= this.radiusX; z++)
			{
				for (int y = -this.radiusY; y <= this.radiusY; y++)
				{
					int distance = x * x + y * y + z * z;
					if (distance <= radiusSq && (this.fill || distance >= radiusSq2))
					{
						world.setBlockState(new BlockPos(x + pos.getX(), y + pos.getY(), z + pos.getZ()), this.block);
					}
				}
			}
		}
		return true;
	}

}
