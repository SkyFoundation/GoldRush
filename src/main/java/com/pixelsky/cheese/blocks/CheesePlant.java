package com.pixelsky.cheese.blocks;

import com.pixelsky.cheese.init.CheeseItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;

public class CheesePlant extends BlockCrops {
	@Override
	protected Item getSeed() {
		return CheeseItems.CHEESE_SEEDS;
	}

	@Override
	protected Item getCrop() {
		return CheeseItems.CHEESE;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Crop;
	}
}