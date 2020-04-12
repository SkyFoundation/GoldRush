package com.pixelsky.goldrush.init;


import com.pixelsky.goldrush.items.robots.ItemRobotDestroyer;
import net.minecraft.item.Item;

public class ModItems implements IRegistery {
public static final ItemRobotDestroyer ITEM_BLOCK_DESTROYER=new ItemRobotDestroyer();
	
	public ModItems() {
		register();
	}
	public void register() {
	regIm(ITEM_BLOCK_DESTROYER);
	}
	private void regIm(Item item){
		RegistrationHandler.Items.add(item);
	}
}
