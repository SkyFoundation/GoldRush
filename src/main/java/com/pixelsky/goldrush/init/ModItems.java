package com.pixelsky.goldrush.init;

import com.pixelsky.goldrush.items.materials.*;
import com.pixelsky.goldrush.items.robots.ItemRobotDestroyer;
import com.pixelsky.goldrush.items.robots.ItemRobotTerminator;
import com.pixelsky.goldrush.items.tools.ItemGoldBowl;
import com.pixelsky.goldrush.items.tools.ItemMultifunctionalTools;
import net.minecraft.item.Item;

public class ModItems implements IRegistery
{
	
	public static final Item BLOCK_DESTROYER = new ItemRobotDestroyer();
	public static final Item CHIP = new ItemChip();
	public static final Item CHIP_ADVANCED = new ItemAdvancedChip();
	public static final Item GEAR = new ItemGear();
	public static final Item MACHINE_FRAME_WORK = new ItemMachineFrameWork();
	public static final Item ROBOT_TERMINATOR = new ItemRobotTerminator();
	public static final Item WHEEL = new ItemWheel();
	public static final Item IRON_BAR = new ItemIronBar();
	public static final Item UNIAXIAL_TWO_WHEEL = new ItemUniaxialTwoWheel();
	public static final Item GOLD_BOWL = new ItemGoldBowl();
	public static final Item MULTIFUNCTIONAL_TOOLS_WOOD = new ItemMultifunctionalTools(Item.ToolMaterial.WOOD,256);

	public static final Item MULTIFUNCTIONAL_TOOLS_STONE = new ItemMultifunctionalTools(Item.ToolMaterial.STONE,512);

	public static final Item MULTIFUNCTIONAL_TOOLS_GOLD = new ItemMultifunctionalTools(Item.ToolMaterial.GOLD,128);

	public static final Item MULTIFUNCTIONAL_TOOLS_IRON = new ItemMultifunctionalTools(Item.ToolMaterial.IRON,1024);

	public static final Item MULTIFUNCTIONAL_TOOLS_DIAMOND = new ItemMultifunctionalTools(Item.ToolMaterial.DIAMOND,2048);
	
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
		regIm(WHEEL);
		regIm(IRON_BAR);
		regIm(UNIAXIAL_TWO_WHEEL);
		regIm(GOLD_BOWL);
		regIm(MULTIFUNCTIONAL_TOOLS_WOOD);

		regIm(MULTIFUNCTIONAL_TOOLS_IRON);

		regIm(MULTIFUNCTIONAL_TOOLS_GOLD);

		regIm(MULTIFUNCTIONAL_TOOLS_DIAMOND);

		regIm(MULTIFUNCTIONAL_TOOLS_STONE);
	}
	
	
	private void regIm(Item item)
	{
		RegistrationHandler.Items.add(item);
	}
}
