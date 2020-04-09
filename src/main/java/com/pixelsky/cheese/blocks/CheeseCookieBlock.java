package com.pixelsky.cheese.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class CheeseCookieBlock extends Block {
	public CheeseCookieBlock() {
		super(Material.ROCK);
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		drops.add(new ItemStack(Item.getItemFromBlock(this),1));
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.COOKIE;
	}
}
