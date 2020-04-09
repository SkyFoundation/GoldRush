package com.pixelsky.cheese.init;

import com.pixelsky.cheese.blocks.*;
import com.pixelsky.cheese.blocks.tree.CheeseLeaves;
import com.pixelsky.cheese.blocks.tree.CheeseLog;
import com.pixelsky.cheese.blocks.tree.CheesePlanks;
import com.pixelsky.cheese.blocks.tree.CheeseSapling;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fluids.BlockFluidBase;

public class CheeseBlocks implements IRegistery{
	public static Block CHEESE_SAPLING;
	public static Block CHEESE_LEAVES;
	public static Block CHEESE_BLOCK;
	public static Block CHEESE_ORE;
	public static Block CHEESE_ORE_NETHER;
	public static Block CHEESE_ORE_END;
	public static Block QUICK_CHEESE;
	public static Block COMPLIMENT_MACHINE;
	public static Block BELGIUM_FLAG;
	public static Block CHEESE_PLANT;
	public static Block CHEESE_FURNACE;
	public static Block LIT_CHEESE_FURNACE;
	public static Block CHEESE_CRAFTING_TABLE;
	public static Block CHEESE_COOKIE_BLOCK;
	public static Block CHEESE_BOARD;
	public static Block CHEESE_GRASS;
	public static Block CHEESE_DIRT;
	public static Block CHEESE_GRASS_PATH;
	public static Block CHEESE_FARM_LAND;
	public static Block CHEESE_STAIRS;
	public static CheesePortal CHEESE_PORTAL;
	public static Block CHEESE_STONE;
	public static CheeseFire CHEESE_FIRE;
	public static Block CHEESE_MIRROR;
	public static Block CHEESE_LOG;
	public static Block CHEESE_PLANKS;
	public static Block CHEESE_CHAIR;
//	public static BlockFluidBase CHEESE_LIQUID ;
	public CheeseBlocks() {
		init();
		register();
	}

	public  void init() {
		CHEESE_ORE = new CheeseOre().setCreativeTab(CheeseTabs.CHEESE_BLOCKS).setHardness(2F);
		CHEESE_ORE_NETHER = new CheeseOreNether().setCreativeTab(CheeseTabs.CHEESE_BLOCKS).setHardness(2F);
		CHEESE_ORE_END = new CheeseOreEnd().setCreativeTab(CheeseTabs.CHEESE_BLOCKS).setHardness(2F);
		CHEESE_BLOCK = new Block(Material.ROCK).setCreativeTab(CheeseTabs.CHEESE_BLOCKS).setHardness(3F);
		QUICK_CHEESE = new QuickCheese().setCreativeTab(CheeseTabs.CHEESE_BLOCKS).setHardness(3.3F);
		COMPLIMENT_MACHINE = new ComplimentMachine().setCreativeTab(CheeseTabs.CHEESE_BLOCKS).setHardness(3F);
		BELGIUM_FLAG = new BelgiumFlag().setCreativeTab(CheeseTabs.CHEESE_BLOCKS).setHardness(2F);
		CHEESE_PLANT = new CheesePlant();
		CHEESE_FURNACE = new CheeseFurnace(false).setCreativeTab(CheeseTabs.CHEESE_BLOCKS).setHardness(2F);
		LIT_CHEESE_FURNACE = new CheeseFurnace(true).setHardness(2F);
		CHEESE_CRAFTING_TABLE = new CheeseWorkbench().setCreativeTab(CheeseTabs.CHEESE_BLOCKS).setHardness(2F);
		CHEESE_COOKIE_BLOCK = new CheeseCookieBlock().setCreativeTab(CheeseTabs.CHEESE_BLOCKS).setHardness(2F);
		CHEESE_BOARD = new CheeseBoard().setCreativeTab(CheeseTabs.CHEESE_BLOCKS).setHardness(2F);
		CHEESE_GRASS = new CheeseGrass().setCreativeTab(CheeseTabs.CHEESE_BLOCKS).setHardness(0.5F).setResistance(0.5F);
		CHEESE_DIRT = new CheeseDirt().setCreativeTab(CheeseTabs.CHEESE_BLOCKS).setHardness(0.75F).setResistance(0.5F);
		CHEESE_GRASS_PATH = new CheeseGrassPath().setHardness(0.625F).setResistance(0.5F);
		CHEESE_FARM_LAND = new CheeseFarmLand().setHardness(0.625F).setResistance(0.5F);
		CHEESE_STAIRS = new CheeseStairs().setCreativeTab(CheeseTabs.CHEESE_BLOCKS).setHardness(2.5F);
		CHEESE_PORTAL = (CheesePortal) new CheesePortal().setBlockUnbreakable();
		CHEESE_STONE = new CheeseStone().setCreativeTab(CheeseTabs.CHEESE_BLOCKS).setHardness(1.0F);
		CHEESE_FIRE = (CheeseFire) new CheeseFire().setHardness(0.0F).setLightLevel(15.0F);
		CHEESE_MIRROR = new CheeseMirror().setCreativeTab(CheeseTabs.CHEESE_BLOCKS).setHardness(1.5F);
		CHEESE_LOG = new CheeseLog().setCreativeTab(CheeseTabs.CHEESE_BLOCKS).setHardness(2.0F);
		CHEESE_PLANKS = new CheesePlanks().setCreativeTab(CheeseTabs.CHEESE_BLOCKS).setHardness(1.25F);
		CHEESE_CHAIR = new CheeseChair().setCreativeTab(CheeseTabs.CHEESE_BLOCKS).setHardness(1.25F);

	//	CHEESE_LIQUID=new CheeseLiquid(CheeseFluid.CHEESE_FLUID,Material.WEB);

		CHEESE_SAPLING=new CheeseSapling().setCreativeTab(CheeseTabs.CHEESE_ITEMS);
		CHEESE_LEAVES=new CheeseLeaves().setCreativeTab(CheeseTabs.CHEESE_BLOCKS);
	//	CHEESE_BANK = new CheeseBank().setCreativeTab(CheeseTabs.CHEESE_BLOCKS).setHardness(3F);
	//	CHEESE_STORE = new CheeseStore().setCreativeTab(CheeseTabs.CHEESE_BLOCKS).setHardness(3F);
		
		CheeseUtils.setNames(CHEESE_ORE, "cheese_ore");
		CheeseUtils.setNames(CHEESE_ORE_NETHER, "cheese_ore_nether");
		CheeseUtils.setNames(CHEESE_ORE_END, "cheese_ore_end");
		CheeseUtils.setNames(CHEESE_BLOCK, "cheese_block");
		CheeseUtils.setNames(QUICK_CHEESE, "quick_cheese");
		CheeseUtils.setNames(COMPLIMENT_MACHINE, "compliment_machine");
		CheeseUtils.setNames(BELGIUM_FLAG, "belgium_flag");
		CheeseUtils.setNames(CHEESE_PLANT, "cheese_plant");
		CheeseUtils.setNames(CHEESE_FURNACE, "cheese_furnace");
		CheeseUtils.setNames(LIT_CHEESE_FURNACE, "lit_cheese_furnace");
		CheeseUtils.setNames(CHEESE_CRAFTING_TABLE, "cheese_crafting_table");
		CheeseUtils.setNames(CHEESE_COOKIE_BLOCK, "cheese_cookie_block");
		CheeseUtils.setNames(CHEESE_BOARD, "cheese_board");
		CheeseUtils.setNames(CHEESE_GRASS, "cheese_grass");
		CheeseUtils.setNames(CHEESE_DIRT, "cheese_dirt");
		CheeseUtils.setNames(CHEESE_GRASS_PATH, "cheese_grass_path");
		CheeseUtils.setNames(CHEESE_FARM_LAND, "cheese_farm_land");
		CheeseUtils.setNames(CHEESE_STAIRS, "cheese_stairs");
		CheeseUtils.setNames(CHEESE_PORTAL, "cheese_portal");
		CheeseUtils.setNames(CHEESE_STONE, "cheese_stone");
		CheeseUtils.setNames(CHEESE_FIRE, "cheese_fire");
		CheeseUtils.setNames(CHEESE_MIRROR, "cheese_mirror");
		CheeseUtils.setNames(CHEESE_LOG, "cheese_log");
		CheeseUtils.setNames(CHEESE_PLANKS, "cheese_planks");
		CheeseUtils.setNames(CHEESE_CHAIR, "cheese_chair");
	//	CheeseUtils.setNames(CHEESE_LIQUID,"cheese_liquid");
		CheeseUtils.setNames(CHEESE_SAPLING,"cheese_sapling");
		CheeseUtils.setNames(CHEESE_LEAVES,"cheese_leaves");
//		CheeseUtils.setNames(CHEESE_BANK, "cheese_bank");
//		CheeseUtils.setNames(CHEESE_STORE, "cheese_store");
	}
	private void regib(Block block){
		RegistrationHandler.Items.add(new ItemBlock(block).setRegistryName(block.getRegistryName()).setTranslationKey(block.getTranslationKey()));
		RegistrationHandler.Blocks.add(block);
	}
	public  void register() {

		regib(CHEESE_SAPLING);
		regib(CHEESE_LEAVES);
		//regib(CHEESE_LIQUID);
		regib(CHEESE_ORE);
		regib(CHEESE_ORE_NETHER);
		regib(CHEESE_ORE_END);
		regib(CHEESE_BLOCK);
		regib(QUICK_CHEESE);
		regib(COMPLIMENT_MACHINE);
		//regib(BELGIUM_FLAG);
		RegistrationHandler.Blocks.add(CHEESE_PLANT);
		regib(CHEESE_FURNACE);
		regib(LIT_CHEESE_FURNACE);
		regib(CHEESE_CRAFTING_TABLE);
		regib(CHEESE_COOKIE_BLOCK);
		regib(CHEESE_BOARD);
		regib(CHEESE_GRASS);
		regib(CHEESE_DIRT);
		regib(CHEESE_GRASS_PATH);
		regib(CHEESE_FARM_LAND);
		regib(CHEESE_STAIRS);
		regib(CHEESE_PORTAL);
		regib(CHEESE_STONE);
		regib(CHEESE_FIRE);
		regib(CHEESE_MIRROR);
		regib(CHEESE_LOG);
		regib(CHEESE_PLANKS);
		regib(CHEESE_CHAIR);
//		regib(CHEESE_BANK);
//		regib(CHEESE_STORE);
	}

}
