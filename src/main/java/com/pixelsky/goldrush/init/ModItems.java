package com.pixelsky.goldrush.init;

import com.pixelsky.goldrush.items.materials.*;
import com.pixelsky.goldrush.items.robots.ItemRobotDestroyer;
import com.pixelsky.goldrush.items.robots.ItemRobotTerminator;
import net.minecraft.item.Item;

public class ModItems implements IRegistery
{
	
	public static final Item BLOCK_DESTROYER = new ItemRobotDestroyer();
	public static final Item CHIP = new ItemChip();
	public static final Item CHIP_ADVANCED = new ItemAdvancedChip();
	public static final Item GEAR = new ItemGear();
	public static final Item MACHINE_FRAME_WORK = new ItemMachineFrameWork();
	public static final Item ROBOT_TERMINATOR = new ItemRobotTerminator();
	public static final Item TYRE = new ItemTyre();
	public static final Item IRON_BAR = new ItemIronBar();
	
	
	public ModItems()
	{
		register();
	}
	
	public void register()
	{
		regIm(BLOCK_DESTROYER);
		regIm(CHIP);
		regIm(CHIP_ADVANCED);
		regIm(GEAR);
		regIm(MACHINE_FRAME_WORK);
		regIm(ROBOT_TERMINATOR);
		regIm(TYRE);
		regIm(IRON_BAR);
	}
	
	private void regIm(Item item)
	{
		RegistrationHandler.Items.add(item);
	}
}
