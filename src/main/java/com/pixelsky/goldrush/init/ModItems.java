package com.pixelsky.goldrush.init;


import com.pixelsky.goldrush.items.materials.ItemChip;
import com.pixelsky.goldrush.items.materials.ItemGear;
import com.pixelsky.goldrush.items.robots.ItemRobotDestroyer;
import net.minecraft.item.Item;

public class ModItems implements IRegistery {
	
public static final ItemRobotDestroyer ITEM_BLOCK_DESTROYER=new ItemRobotDestroyer();

public static final Item ITEM_chip = new ItemChip();

public static final Item ITEM_Gear = new ItemGear();

	
	public ModItems() {
		register();
	}
	public void register() {
		regIm(ITEM_BLOCK_DESTROYER);
		regIm(ITEM_chip);
		regIm(ITEM_Gear);
	}
	
	private void regIm(Item item){
		RegistrationHandler.Items.add(item);
	}
}
