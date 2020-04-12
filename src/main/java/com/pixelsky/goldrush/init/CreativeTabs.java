package com.pixelsky.goldrush.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabs {
	public static net.minecraft.creativetab.CreativeTabs GOLD_RUSH=new net.minecraft.creativetab.CreativeTabs("gold_rush") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(Item.getItemFromBlock(ModBlocks.MACHINE_MINER));
		}
	};
}