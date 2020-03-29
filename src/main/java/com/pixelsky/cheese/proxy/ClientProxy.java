package com.pixelsky.cheese.proxy;

import com.pixelsky.cheese.entities.cheesearrow.EntityCheeseArrow;
import com.pixelsky.cheese.entities.cheesearrow.RenderingHandlerCheeseArrow;
import com.pixelsky.cheese.entities.cheeseball.EntityCheeseBall;
import com.pixelsky.cheese.entities.cheeseball.RenderingHandlerCheeseBall;
import com.pixelsky.cheese.entities.cheeseboss.EntityCheeseBoss;
import com.pixelsky.cheese.entities.cheeseboss.RenderingHandlerCheeseBoss;
import com.pixelsky.cheese.entities.cheesecow.EntityCheeseCow;
import com.pixelsky.cheese.entities.cheesecow.RenderingHandlerCheeseCow;
import com.pixelsky.cheese.entities.tileentities.blocks.TileEntityCheeseBoard;
import com.pixelsky.cheese.entities.tileentities.blocks.TileEntityCheeseMirror;
import com.pixelsky.cheese.entities.tileentities.render.RenderCheeseBoard;
import com.pixelsky.cheese.entities.tileentities.render.RenderCheeseMirror;
import com.pixelsky.cheese.handler.CheeseClientHandler;
import com.pixelsky.cheese.init.CheeseBlocks;
import com.pixelsky.cheese.init.CheeseItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import org.lwjgl.opengl.Display;

public class ClientProxy extends CommonProxy {

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
}
