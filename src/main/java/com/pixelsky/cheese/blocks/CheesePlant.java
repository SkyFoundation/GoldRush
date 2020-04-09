package com.pixelsky.cheese.blocks;

import com.pixelsky.cheese.init.CheeseItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class CheesePlant extends BlockCrops {
	public CheesePlant(){
	}
	@Override
	protected Item getSeed() {
		return CheeseItems.CHEESE_SEEDS;
	}

	@Override
	protected Item getCrop() {
		return CheeseItems.CHEESE;
	}


}