package com.pixelsky.goldrush.init;

import com.pixelsky.goldrush.items.materials.*;
import com.pixelsky.goldrush.items.robots.ItemRobotDestroyer;
import com.pixelsky.goldrush.items.robots.ItemRobotTerminator;
import net.minecraft.item.Item;

public class ModItems implements IRegistery
{
		
	public static final ItemRobotDestroyer ITEM_BLOCK_DESTROYER = new ItemRobotDestroyer();
	
	public static final Item ITEM_CHIP = new ItemChip();
	
	public static final Item ITEM_CHIP_ADVANCED = new ItemAdvancedChip();
	
	public static final Item ITEM_GEAR = new ItemGear();
	
	public static final Item ITEM_MACHINE_FRAME_WORK = new ItemMachineFrameWork();
	
	public static final Item ITEM_ROBOT_TERMINATOR = new ItemRobotTerminator();
	
	public static final Item ItemTYRE = new ItemTyre();

	
	public ModItems() {
		register();
	}
	public void register() {
		regIm(ITEM_BLOCK_DESTROYER);
		regIm(ITEM_CHIP);
		regIm(ITEM_CHIP_ADVANCED);
		regIm(ITEM_GEAR);
		regIm(ITEM_MACHINE_FRAME_WORK);
		regIm(ITEM_ROBOT_TERMINATOR);
		regIm(ItemTYRE);
	}
	
	private void regIm(Item item){
		RegistrationHandler.Items.add(item);
	}
}
