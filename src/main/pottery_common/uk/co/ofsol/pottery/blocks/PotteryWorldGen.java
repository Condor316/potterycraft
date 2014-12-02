package uk.co.ofsol.pottery.blocks;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class PotteryWorldGen implements IWorldGenerator {

	public PotteryWorldGen() {
		
	}

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case -1 : generateNether(world, rand, chunkX*16, chunkZ*16);
		case 0 : generateSurface(world, rand, chunkX*16, chunkZ*16);
		}
		
	}

	public void generateSurface(World world, Random rand, int x, int z) {
		for(int i = 0; i<13; i++)
		{
			int Xcoords = x+rand.nextInt(16);
			int Ycoords = rand.nextInt(256);
			int Zcoords = z+rand.nextInt(16);
			new WorldGenMinable(null, 50).generate(world, rand, Xcoords, Ycoords, Zcoords);
		}
		
	}

	public void generateNether(World world, Random rand, int x, int z) {
		for(int i = 0; i<13; i++)
		{
			int Xcoords = x+rand.nextInt(16);
			int Ycoords = rand.nextInt(256);
			int Zcoords = z+rand.nextInt(16);
			new WorldGenMinable(null, 50).generate(world, rand, Xcoords, Ycoords, Zcoords);
		}
		
	}
	
	

}
