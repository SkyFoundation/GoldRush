package com.pixelsky.goldrush.init;

import com.pixelsky.goldrush.blocks.FluidOilBlock;
import com.pixelsky.goldrush.blocks.machine.*;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ModBlocks implements IRegistery
{
	public static final MachineMiner MACHINE_MINER = new MachineMiner();
	public static final MachineDetector MACHINE_BLOCK_DETECTOR = new MachineDetector();
	public static final FluidOilBlock FLUID_OIL_BLOCK = new FluidOilBlock();
	
	
	
	
	public static final Block MACHINERY_CASING = new MachineryCasing();
	
	public ModBlocks()
	{
		register();
	}
	private void regib(Block block)
	{
		RegistrationHandler.Items.add(new ItemBlock(block).setRegistryName(block.getRegistryName()).setTranslationKey(block.getTranslationKey()));
		RegistrationHandler.Blocks.add(block);
	}



	public  void register()
	{
		regib(MACHINE_BLOCK_DETECTOR);
		regib(MACHINE_MINER);
		
		
		regib(MACHINERY_CASING);
		
		RegistrationHandler.Blocks.add(FLUID_OIL_BLOCK);
	}

}
