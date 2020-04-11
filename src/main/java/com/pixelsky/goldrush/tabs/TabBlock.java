package com.pixelsky.goldrush.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TabBlock extends CreativeTabs {

	public TabBlock(String label) {
		super(label); 
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE));
	}

	@Override
	public boolean hasSearchBar() {
		return false;
	}



}
