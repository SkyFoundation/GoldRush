package com.pixelsky.cheese.blocks;

import com.pixelsky.cheese.init.CheeseItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		//super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
		//this.checkAndDropBlock(worldIn, pos, state);
	}

}