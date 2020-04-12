package com.pixelsky.goldrush.init;

import com.pixelsky.goldrush.items.materials.*;
import com.pixelsky.goldrush.items.robots.ItemRobotDestroyer;
import net.minecraft.item.Item;

public class ModItems implements IRegistery {
	
public static final ItemRobotDestroyer ITEM_BLOCK_DESTROYER=new ItemRobotDestroyer();

public static final Item ITEM_CHIP = new ItemChip();

public static final Item ITEM_CHIP_ADVANCED = new ItemAdvancedChip();

public static final Item ITEM_GEAR = new ItemGear();

	
	public ModItems() {
		register();
	}
	public void register() {
		regIm(ITEM_BLOCK_DESTROYER);
		regIm(ITEM_CHIP);
		regIm(ITEM_CHIP_ADVANCED);
		regIm(ITEM_GEAR);
	}
	
	private void regIm(Item item){
		RegistrationHandler.Items.add(item);
	}
}
