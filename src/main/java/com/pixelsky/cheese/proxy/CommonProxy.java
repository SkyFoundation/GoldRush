package com.pixelsky.cheese.proxy;

import com.pixelsky.cheese.DeGeweldigeMod;
import com.pixelsky.cheese.entities.CheeseSpawnPlacementRegistry;
import com.pixelsky.cheese.handler.CheeseCapabilityHandler;
import com.pixelsky.cheese.handler.CheeseCommonHandler;
import com.pixelsky.cheese.handler.CheeseGuiHandler;
import com.pixelsky.cheese.handler.CheesePacketHandler;
import com.pixelsky.cheese.init.*;
import com.pixelsky.cheese.world.gen.CheeseGeneration;
import com.pixelsky.cheese.world.gen.MapGenCheeseVillage;
import com.pixelsky.cheese.world.gen.StructureCheeseVillagePieces;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy implements IProxy{
	private void registerCommonEventHandler() {
		MinecraftForge.EVENT_BUS.register(new CheeseCommonHandler());
		MinecraftForge.EVENT_BUS.register(new CheeseCapabilityHandler());
	}
	private void registerHandler(DeGeweldigeMod inst) {
		NetworkRegistry.INSTANCE.registerGuiHandler(inst, new CheeseGuiHandler());
	}
	private void registerWorldGen() {
		GameRegistry.registerWorldGenerator(new CheeseGeneration(), 0);
	}

	private void registerStructure() {
		MapGenStructureIO.registerStructure(MapGenCheeseVillage.Start.class, "CheeseVillage");
		StructureCheeseVillagePieces.registerVillagePieces();
	}
	@Override
	public void preInit(FMLPreInitializationEvent event) {

	  // new CheeseFluid();
		RegistrationHandler.init();

		new CheeseSpawnPlacementRegistry();
		new CheeseTabs();
		new CheesePacketHandler();
		new CheeseDimensions();
	}

	@Override
	public void init(FMLInitializationEvent event) {
		new CheeseRecipes();
	registerHandler(DeGeweldigeMod.DGMInstance);
	registerCommonEventHandler();
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		registerStructure();
		registerWorldGen();
	}

	@Override
	public void serverStart(FMLServerStartingEvent event) {
	new CheeseCommands(event);
	}
}
