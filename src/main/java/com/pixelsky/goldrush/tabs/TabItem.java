package com.pixelsky.goldrush.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TabItem extends CreativeTabs {

	public TabItem(String label) {
		super(label); 
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(Items.DIAMOND_PICKAXE);
	}

	@Override
	public boolean hasSearchBar() {
		return false;
	}


}
