package com.pixelsky.cheese.world.biome;

import com.pixelsky.cheese.entities.cheesechicken.EntityCheeseChicken;
import com.pixelsky.cheese.entities.cheesecow.EntityCheeseCow;
import com.pixelsky.cheese.entities.cheesemouse.EntityCheeseMouse;
import com.pixelsky.cheese.init.CheeseBlocks;
import com.pixelsky.cheese.world.gen.WorldGenCheeseHouse2;
import net.minecraft.block.BlockFlower;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeCheese extends Biome {
	public BiomeCheese(Biome.BiomeProperties properties) {
		super(properties);
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCheeseCow.class, 8, 4, 4));
		this.decorator.treesPerChunk = 1;
		this.decorator.extraTreeChance = 0.05F;
		this.decorator.flowersPerChunk = 5;
		this.decorator.grassPerChunk = 7;
		this.spawnableCreatureList.add(new SpawnListEntry(EntityCheeseCow.class,1,1,2));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityCheeseChicken.class,1,1,2));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityCheeseMouse.class,1,1,2));
		this.topBlock = CheeseBlocks.CHEESE_GRASS.getDefaultState();
		this.fillerBlock = CheeseBlocks.CHEESE_DIRT.getDefaultState();
	}
	
	@Override
	public int getGrassColorAtPos(BlockPos pos) {
		return 0xD6FF42;
	}
	
	@Override
	public int getFoliageColorAtPos(BlockPos pos) {
		return 0xD6FF42;
	}

	public BlockFlower.EnumFlowerType pickRandomFlower(Random rand, BlockPos pos) {
		double d0 = GRASS_COLOR_NOISE.getValue((double) pos.getX() / 200.0D, (double) pos.getZ() / 200.0D);

		if (d0 < -0.8D) {
			int j = rand.nextInt(4);

			switch (j) {
			case 0:
				return BlockFlower.EnumFlowerType.ORANGE_TULIP;
			case 1:
				return BlockFlower.EnumFlowerType.RED_TULIP;
			case 2:
				return BlockFlower.EnumFlowerType.PINK_TULIP;
			case 3:
			default:
				return BlockFlower.EnumFlowerType.WHITE_TULIP;
			}
		} else if (rand.nextInt(3) > 0) {
			int i = rand.nextInt(3);
			return i == 0 ? BlockFlower.EnumFlowerType.POPPY
					: (i == 1 ? BlockFlower.EnumFlowerType.HOUSTONIA : BlockFlower.EnumFlowerType.OXEYE_DAISY);
		} else {
			return BlockFlower.EnumFlowerType.DANDELION;
		}
	}
	@Override
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
		BlockFlower red = net.minecraft.init.Blocks.RED_FLOWER;
		BlockFlower yel = net.minecraft.init.Blocks.YELLOW_FLOWER;
		addFlower(red.getDefaultState().withProperty(red.getTypeProperty(), BlockFlower.EnumFlowerType.ORANGE_TULIP),
				3);
		addFlower(red.getDefaultState().withProperty(red.getTypeProperty(), BlockFlower.EnumFlowerType.RED_TULIP), 3);
		addFlower(red.getDefaultState().withProperty(red.getTypeProperty(), BlockFlower.EnumFlowerType.PINK_TULIP), 3);
		addFlower(red.getDefaultState().withProperty(red.getTypeProperty(), BlockFlower.EnumFlowerType.WHITE_TULIP), 3);
		addFlower(red.getDefaultState().withProperty(red.getTypeProperty(), BlockFlower.EnumFlowerType.POPPY), 20);
		addFlower(red.getDefaultState().withProperty(red.getTypeProperty(), BlockFlower.EnumFlowerType.HOUSTONIA), 20);
		addFlower(red.getDefaultState().withProperty(red.getTypeProperty(), BlockFlower.EnumFlowerType.OXEYE_DAISY),
				20);
		addFlower(yel.getDefaultState().withProperty(yel.getTypeProperty(), BlockFlower.EnumFlowerType.DANDELION), 30);
	}

	public WorldGenAbstractTree genBigTreeChance(Random rand) {
		return (WorldGenAbstractTree) (rand.nextInt(3) == 0 ? BIG_TREE_FEATURE : TREE_FEATURE);
	}
}