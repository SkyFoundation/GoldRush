package com.pixelsky.goldrush.init;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.items.materials.*;
import com.pixelsky.goldrush.items.robots.ItemRobotDestroyer;
import com.pixelsky.goldrush.items.robots.ItemRobotTerminator;
import com.pixelsky.goldrush.items.tools.ItemGoldBowl;
import com.pixelsky.goldrush.items.tools.ItemMultifunctionalTools;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

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
	public static final Item TOOLS_CORE = new ItemToolsCore();
	
	
	
	
	
	/*------------------------------------------------------------------------------------------------------------------*/
	public static final Item WOOD_MULTIFUNCTIONAL_TOOLS = new ItemMultifunctionalTools(Item.ToolMaterial.WOOD,256)
			.setRegistryName(new ResourceLocation(Reference.MODID, "wood_multifunctional_tools"))
			.setTranslationKey("wood_multifunctional_tools")
			.setCreativeTab(CreativeTabs.GOLD_RUSH);
	
	
	public static final Item STONE_MULTIFUNCTIONAL_TOOLS = new ItemMultifunctionalTools(Item.ToolMaterial.STONE,512)
			.setRegistryName(new ResourceLocation(Reference.MODID, "stone_multifunctional_tools"))
			.setTranslationKey("stone_multifunctional_tools")
			.setCreativeTab(CreativeTabs.GOLD_RUSH);
	
	
	public static final Item IRON_MULTIFUNCTIONAL_TOOLS = new ItemMultifunctionalTools(Item.ToolMaterial.GOLD,128)
			.setRegistryName(new ResourceLocation(Reference.MODID, "iron_multifunctional_tools"))
			.setTranslationKey("iron_multifunctional_tools")
			.setCreativeTab(CreativeTabs.GOLD_RUSH);
	
	
	public static final Item GOLD_MULTIFUNCTIONAL_TOOLS = new ItemMultifunctionalTools(Item.ToolMaterial.IRON,1024)
			.setRegistryName(new ResourceLocation(Reference.MODID, "gold_multifunctional_tools"))
			.setTranslationKey("gold_multifunctional_tools")
			.setCreativeTab(CreativeTabs.GOLD_RUSH);
	
	
	public static final Item DIAMOND_MULTIFUNCTIONAL_TOOLS = new ItemMultifunctionalTools(Item.ToolMaterial.DIAMOND,2048)
			.setRegistryName(new ResourceLocation(Reference.MODID, "diamond_multifunctional_tools"))
			.setTranslationKey("diamond_multifunctional_tools")
			.setCreativeTab(CreativeTabs.GOLD_RUSH);
	
	
	/*------------------------------------------------------------------------------------------------------------------*/
	
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
		regIm(TOOLS_CORE);
		
		
		regIm(WOOD_MULTIFUNCTIONAL_TOOLS);
		regIm(STONE_MULTIFUNCTIONAL_TOOLS);
		regIm(IRON_MULTIFUNCTIONAL_TOOLS);
		regIm(GOLD_MULTIFUNCTIONAL_TOOLS);
		regIm(DIAMOND_MULTIFUNCTIONAL_TOOLS);


	}
	
	
	private void regIm(Item item)
	{
		RegistrationHandler.Items.add(item);
	}
}
