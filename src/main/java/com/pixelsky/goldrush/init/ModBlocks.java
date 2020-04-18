package com.pixelsky.goldrush.init;

import com.pixelsky.goldrush.blocks.FluidOilBlock;
import com.pixelsky.goldrush.blocks.machine.MachineDetector;
import com.pixelsky.goldrush.blocks.machine.MachineMiner;
import com.pixelsky.goldrush.blocks.machine.MachineryCasing;
import com.pixelsky.goldrush.blocks.ore.dirtore.*;
import com.pixelsky.goldrush.blocks.ore.sandore.*;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ModBlocks implements IRegistery
{
	/*--------------------------------------------------------------------------------------------*/
	
	public static final Block DIRT_COAL_ORE = new DirtCoalOre();
	public static final Block DIRT_DIAMOND_ORE = new DirtDiamondOre();
	public static final Block DIRT_EMERALD_ORE = new DirtEmeraldOre();
	public static final Block DIRT_GOLD_ORE = new DirtGoldOre();
	public static final Block DIRT_IRON_ORE = new DirtIronOre();
	public static final Block DIRT_LAPIS_ORE = new DirtLapisOre();
	public static final Block DIRT_REDSTONE_ORE = new DirtRedstoneOre();
	
	/*--------------------------------------------------------------------------------------------*/
	
	
	/*--------------------------------------------------------------------------------------------*/
	
	public static final Block SAND_COAL_ORE = new SandCoalOre();
	public static final Block SAND_DIAMOND_ORE = new SandDiamondOre();
	public static final Block SAND_EMERALD_ORE = new SandEmeraldOre();
	public static final Block SAND_GOLD_ORE = new SandGoldOre();
	public static final Block SAND_IRON_ORE = new SandIronOre();
	public static final Block SAND_LAPIS_ORE = new SandLapisOre();
	public static final Block SAND_REDSTONE_ORE = new SandRedstoneOre();
	
	/*--------------------------------------------------------------------------------------------*/
	
	
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
		
		
		/*------------------------*/
		
		regib(DIRT_COAL_ORE);
		regib(DIRT_DIAMOND_ORE);
		regib(DIRT_EMERALD_ORE);
		regib(DIRT_GOLD_ORE);
		regib(DIRT_IRON_ORE);
		regib(DIRT_LAPIS_ORE);
		regib(DIRT_REDSTONE_ORE);
		
		/*------------------------*/
		
		/*------------------------*/
		
		regib(SAND_COAL_ORE);
		regib(SAND_DIAMOND_ORE);
		regib(SAND_EMERALD_ORE);
		regib(SAND_GOLD_ORE);
		regib(SAND_IRON_ORE);
		regib(SAND_LAPIS_ORE);
		regib(SAND_REDSTONE_ORE);
		
		/*------------------------*/
		
		
		
		
		
		
		
		
		
		
		
		
		RegistrationHandler.Blocks.add(FLUID_OIL_BLOCK);
		regib(MACHINE_BLOCK_DETECTOR);
		regib(MACHINE_MINER);
		regib(MACHINERY_CASING);
	}

}
