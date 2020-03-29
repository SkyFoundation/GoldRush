package com.pixelsky.cheese.world.biome;

import com.pixelsky.cheese.init.CheeseBlocks;
import com.pixelsky.cheese.world.gen.WorldGenCheeseHouse2;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeCheeseDimension extends Biome {
	public BiomeCheeseDimension(Biome.BiomeProperties properties) {
		super(properties);
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
		this.theBiomeDecorator.treesPerChunk = 0;
		this.theBiomeDecorator.extraTreeChance = 0;
		this.theBiomeDecorator.flowersPerChunk = 0;
		this.theBiomeDecorator.grassPerChunk = 0;
		this.topBlock = CheeseBlocks.CHEESE_STONE.getDefaultState();
		this.fillerBlock = CheeseBlocks.CHEESE_STONE.getDefaultState();
	}
	
	@Override
	public int getGrassColorAtPos(BlockPos pos) {
		return 0xD6FF42;
	}
	
	@Override
	public int getFoliageColorAtPos(BlockPos pos) {
		return 0xD6FF42;
	}

	public void decorate(World worldIn, Random rand, BlockPos pos) {
		final WorldGenCheeseHouse2 CHEESE_HOUSE_GENERATOR = new WorldGenCheeseHouse2();
		
		if (rand.nextInt(100) == 0) {
			int i = rand.nextInt(16) + 8;
            int j = rand.nextInt(16) + 8;
            BlockPos blockpos = worldIn.getHeight(pos.add(i, 0, j)).up();
            CHEESE_HOUSE_GENERATOR.generate(worldIn, rand, blockpos);
		}
		super.decorate(worldIn, rand, pos);
	}

	@Override
	public void addDefaultFlowers() {
	}

	public WorldGenAbstractTree genBigTreeChance(Random rand) {
		return TREE_FEATURE;
	}
}