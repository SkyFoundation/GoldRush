package com.pixelsky.cheese.tabs;

import com.pixelsky.cheese.init.CheeseBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CheeseTabBlocks extends CreativeTabs {

	public CheeseTabBlocks(String label) {
		super(label);
		this.setBackgroundImageName("cheese_background.png");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(Item.getItemFromBlock(CheeseBlocks.CHEESE_BLOCK));
	}

	@Override
	public boolean hasSearchBar() {
		return false;
	}



}
