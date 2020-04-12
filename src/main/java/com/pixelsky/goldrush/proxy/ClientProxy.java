package com.pixelsky.goldrush.proxy;

import com.pixelsky.goldrush.entity.entityblockmarket.EntityBlockMarker;
import com.pixelsky.goldrush.entity.entityblockmarket.RenderHandlerMarker;
import com.pixelsky.goldrush.entity.robotblockdestroyer.RenderHandlerDestoryer;
import com.pixelsky.goldrush.entity.robotblockdestroyer.RobotDestroyer;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class ClientProxy extends CommonProxy {


	private void registerRender(){
		//Rendering
		RenderingRegistry.registerEntityRenderingHandler(RobotDestroyer.class, new RenderHandlerDestoryer());
		RenderingRegistry.registerEntityRenderingHandler(EntityBlockMarker.class, new RenderHandlerMarker());

	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		registerRender();
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}

	@Override
	public void serverStart(FMLServerStartingEvent event) {
		super.serverStart(event);
	}
	/*
	public void registerModels() {
		int meta = 0;
		
		//Food
		registerItemModel(CheeseItems.CHEESE, meta);
		registerItemModel(CheeseItems.CHEESE_COOKED, meta);
		registerItemModel(CheeseItems.BREAD_CHEESE, meta);
		registerItemModel(CheeseItems.CHEESE_APPLE, meta);
		registerItemModel(CheeseItems.CHEESE_BUCKET, meta);
		registerItemModel(CheeseItems.CHEESE_SEEDS, meta);

		//Other
		registerItemModel(CheeseItems.CHEESE_INGOT, meta);
		registerItemModel(CheeseItems.CHEESE_ARROW, meta);
		registerItemModel(CheeseItems.CHEESE_MONEY, meta);

		//Tools
		registerItemModel(CheeseItems.CHEESE_SWORD, meta);
		registerItemModel(CheeseItems.CHEESE_PICKAXE, meta);
		registerItemModel(CheeseItems.CHEESE_AXE, meta);
		registerItemModel(CheeseItems.CHEESE_SHOVEL, meta);
		registerItemModel(CheeseItems.CHEESE_HOE, meta);
		registerItemModel(CheeseItems.CHEESE_FLY_STICK, meta);
		registerItemModel(CheeseItems.CHEESE_BOW, meta);
		registerItemModel(CheeseItems.CHEESE_MULTITOOL, meta);
		registerItemModel(CheeseItems.FLINT_AND_CHEESE, meta);
		registerItemModel(CheeseItems.CHEESE_SLOW_WAND, meta);
		registerItemModel(CheeseItems.CHEESE_POISON_WAND, meta);
		registerItemModel(CheeseItems.CHEESE_DAMAGE_WAND, meta);
		registerItemModel(CheeseItems.CHEESE_FIRE_WAND, meta);
		registerItemModel(CheeseItems.CHEESE_WAND, meta);

		//Armor
		registerItemModel(CheeseItems.CHEESE_HELMET, meta);
		registerItemModel(CheeseItems.CHEESE_CHESTPLATE, meta);
		registerItemModel(CheeseItems.CHEESE_LEGGINGS, meta);
		registerItemModel(CheeseItems.CHEESE_BOOTS, meta);

		//Tool heads
		registerItemModel(CheeseItems.CHEESE_PICKAXE_HEAD, meta);
		registerItemModel(CheeseItems.CHEESE_AXE_HEAD, meta);
		registerItemModel(CheeseItems.CHEESE_SHOVEL_HEAD, meta);

		registerBlockModel(CheeseBlocks.CHEESE_ORE, meta);
		registerBlockModel(CheeseBlocks.CHEESE_ORE_NETHER, meta);
		registerBlockModel(CheeseBlocks.CHEESE_ORE_END, meta);
		registerBlockModel(CheeseBlocks.CHEESE_BLOCK, meta);
		registerBlockModel(CheeseBlocks.QUICK_CHEESE, meta);
		registerBlockModel(CheeseBlocks.COMPLIMENT_MACHINE, meta);
		registerBlockModel(CheeseBlocks.BELGIUM_FLAG, meta);
		registerBlockModel(CheeseBlocks.CHEESE_PLANT, meta);
		registerBlockModel(CheeseBlocks.CHEESE_FURNACE, meta);
		registerBlockModel(CheeseBlocks.LIT_CHEESE_FURNACE, meta);
		registerBlockModel(CheeseBlocks.CHEESE_CRAFTING_TABLE, meta);
		registerBlockModel(CheeseBlocks.CHEESE_COOKIE_BLOCK, meta);
		registerBlockModel(CheeseBlocks.CHEESE_BOARD, meta);
		registerBlockModel(CheeseBlocks.CHEESE_GRASS, meta);
		registerBlockModel(CheeseBlocks.CHEESE_DIRT, meta);
		registerBlockModel(CheeseBlocks.CHEESE_GRASS_PATH, meta);
		registerBlockModel(CheeseBlocks.CHEESE_FARM_LAND, meta);
		registerBlockModel(CheeseBlocks.CHEESE_STAIRS, meta);
		registerBlockModel(CheeseBlocks.CHEESE_PORTAL, meta);
		registerBlockModel(CheeseBlocks.CHEESE_STONE, meta);
		registerBlockModel(CheeseBlocks.CHEESE_FIRE, meta);
		registerBlockModel(CheeseBlocks.CHEESE_MIRROR, meta);
		registerBlockModel(CheeseBlocks.CHEESE_LOG, meta);
		registerBlockModel(CheeseBlocks.CHEESE_PLANKS, meta);
		registerBlockModel(CheeseBlocks.CHEESE_CHAIR, meta);
		registerBlockModel(CheeseBlocks.CHEESE_BANK, meta);
		registerBlockModel(CheeseBlocks.CHEESE_STORE, meta);
	}

	public void registerClientEventHandler() {
		MinecraftForge.EVENT_BUS.register(new CheeseClientHandler());
		MinecraftForge.EVENT_BUS.register(new RenderCheeseMirror());
	}

	public void bindTileEntities() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCheeseBoard.class, new RenderCheeseBoard());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCheeseMirror.class, new RenderCheeseMirror());
	}

	public void setTitle(String title) {
		Display.setTitle(title);
	}

	public void renderEntities() {
		RenderingRegistry.registerEntityRenderingHandler(EntityCheeseCow.class, new RenderingHandlerCheeseCow());
		RenderingRegistry.registerEntityRenderingHandler(EntityCheeseArrow.class, new RenderingHandlerCheeseArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityCheeseBoss.class, new RenderingHandlerCheeseBoss());
		RenderingRegistry.registerEntityRenderingHandler(EntityCheeseBall.class, new RenderingHandlerCheeseBall());
	}

	private void registerItemModel(Item item, int meta) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	private void registerBlockModel(Block block, int meta) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
				new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
	*/
}
