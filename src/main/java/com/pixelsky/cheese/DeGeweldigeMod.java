package com.pixelsky.cheese;

import com.pixelsky.cheese.entities.CheeseSpawnPlacementRegistry;
import com.pixelsky.cheese.handler.CheesePacketHandler;
import com.pixelsky.cheese.init.*;
import com.pixelsky.cheese.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = "[1.12.2]")
public class DeGeweldigeMod {
	
	@SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
	public static CommonProxy proxy;
	
	@Instance(Reference.MODID)
	public static DeGeweldigeMod DGMInstance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		new CheeseBlocks();
		new CheeseItems();
		new CheeseEntities();
		new CheeseSpawnPlacementRegistry();
		new CheeseBiomes();
		new CheeseTabs();
		new CheesePacketHandler();
		new CheeseDimensions();
		proxy.registerModels();
		proxy.renderEntities();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		new CheeseCraftingAndSmelting();
		//new CheeseCapabilitys();
		proxy.bindTileEntities();
		proxy.registerClientEventHandler();
		proxy.registerCommonEventHandler();
		proxy.registerHandler(DGMInstance);
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		proxy.registerStructure();
	}
	
	@EventHandler
	public static void serverStart(FMLServerStartingEvent event) {
		new CheeseCommands(event);
	}
}
