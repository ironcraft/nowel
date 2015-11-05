package fr.ironcraft.nowel.worldgen;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class CustomWorldGenerator implements IWorldGenerator { 

	WorldGenFir FirGen;
	
	public CustomWorldGenerator() {
		FirGen = new WorldGenFir();
	}

	@Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimensionId())
		{
			case -1 : generateNether(world, random, chunkX * 16, chunkZ * 16);
			case 0 : generateNormal(world, random, chunkX * 16, chunkZ * 16);
			case 1 : generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
    }
	
	public void generateNormal(World world, Random random, int chunkX, int chunkZ)
	{
		BiomeGenBase b = world.getBiomeGenForCoords(new BlockPos(chunkX, 0, chunkZ));
        if(b.biomeID == 12) //Tundra
        {
        	for (int i = 0; i < 7; i++) // Attempt to place 7 fir per chunk
        		FirGen.generate(world, random, new BlockPos(chunkX + random.nextInt(16), 50 + random.nextInt(78), chunkZ + random.nextInt(16)));
        }
	}
	
	public void generateNether(World world, Random random, int chunkX, int chunkZ) {
		
	}
	
	public void generateEnd(World world, Random random, int chunkX, int chunkZ) {
		
	}
}
