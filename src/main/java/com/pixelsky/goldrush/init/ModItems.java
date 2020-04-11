package com.pixelsky.goldrush.init;


import net.minecraft.item.Item;

public class ModItems implements IRegistery {

	
	public ModItems() {
		init();
		register();
	}
	
	public void init() {

	}
	public void register() {

	}
	private void regIm(Item item){
		RegistrationHandler.Items.add(item);
	}
}
