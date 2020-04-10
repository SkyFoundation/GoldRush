package com.pixelsky.cheese.world.biome;

import com.pixelsky.cheese.entities.cheesechicken.EntityCheeseChicken;
import com.pixelsky.cheese.entities.cheesecow.EntityCheeseCow;
import com.pixelsky.cheese.entities.cheesemouse.EntityCheeseMouse;
import com.pixelsky.cheese.init.CheeseBlocks;
import com.pixelsky.cheese.world.gen.WorldGenCheeseBossHouse;
import com.pixelsky.cheese.world.gen.WorldGenCheeseHouse;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.Random;

public class BiomeCheeseDimension extends Biome {

	public BiomeCheeseDimension(Biome.BiomeProperties properties) {
		super(properties);
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
		addEntities();
		this.decorator.treesPerChunk = 0;
		this.decorator.extraTreeChance = 0;
		this.decorator.flowersPerChunk = 0;
		this.decorator.grassPerChunk = 0;
		this.topBlock = CheeseBlocks.CHEESE_GRASS.getDefaultState();
		this.fillerBlock = CheeseBlocks.CHEESE_STONE.getDefaultState();
	}

	private void addEntities(){
		this.spawnableCreatureList.add(new SpawnListEntry(EntityCheeseCow.class,1,1,2));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityCheeseChicken.class,1,1,2));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityCheeseMouse.class,1,1,2));
	}
	@Override
	public int getGrassColorAtPos(BlockPos pos) {
		return 0xD6FF42;
	}
	
	@Override
	public int getFoliageColorAtPos(BlockPos pos) {
		return 0xD6FF42;
	}
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		double d0 = GRASS_COLOR_NOISE.getValue((double) (pos.getX() + 8) / 200.0D, (double) (pos.getZ() + 8) / 200.0D);
		final WorldGenCheeseHouse CHEESE_HOUSE_GENERATOR = new WorldGenCheeseHouse();
		final WorldGenCheeseBossHouse CHEESE_BOSS_HOUSE_GENERATOR = new WorldGenCheeseBossHouse();

		if (rand.nextInt(100) == 0) {
			int i = rand.nextInt(16) + 8;
			int j = rand.nextInt(16) + 8;
			BlockPos blockpos = worldIn.getHeight(pos.add(i, 0, j)).up();
			CHEESE_HOUSE_GENERATOR.generate(worldIn, rand, blockpos);
		} else if (rand.nextInt(999) == 0) {
			int i = rand.nextInt(16) + 8;
			int j = rand.nextInt(16) + 8;
			BlockPos blockpos = worldIn.getHeight(pos.add(i, 0, j)).up();
			CHEESE_BOSS_HOUSE_GENERATOR.generate(worldIn, rand, blockpos);
		}
		this.decorator.flowersPerChunk = 4;
		this.decorator.grassPerChunk = 10;
		DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.GRASS);

		for (int i = 0; i < 7; ++i) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
			DOUBLE_PLANT_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
		}
		super.decorate(worldIn, rand, pos);
	}


/*
	@Override
	public void addDefaultFlowers() {
	}

	public WorldGenAbstractTree genBigTreeChance(Random rand) {
		return TREE_FEATURE;
	}
	*/
}