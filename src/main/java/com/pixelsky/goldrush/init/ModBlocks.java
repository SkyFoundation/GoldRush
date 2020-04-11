package com.pixelsky.goldrush.init;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ModBlocks implements IRegistery{

	public ModBlocks() {
		init();
		register();
	}

	public  void init() {

	}
	private void regib(Block block){
		RegistrationHandler.Items.add(new ItemBlock(block).setRegistryName(block.getRegistryName()).setTranslationKey(block.getTranslationKey()));
		RegistrationHandler.Blocks.add(block);
	}
	public  void register() {

	}

}
