package com.pixelsky.cheese.tabs;

import com.pixelsky.cheese.init.CheeseItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CheeseTabItems extends CreativeTabs {

	public CheeseTabItems(String label) {
		super(label);
		this.setBackgroundImageName("cheese_background.png");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(CheeseItems.CHEESE);
	}

	@Override
	public boolean hasSearchBar() {
		return false;
	}


}
