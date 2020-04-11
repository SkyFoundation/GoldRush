package com.pixelsky.goldrush.proxy;

import com.pixelsky.goldrush.GoldRush;
import com.pixelsky.goldrush.entities.CheeseSpawnPlacementRegistry;
import com.pixelsky.goldrush.handler.CheeseCapabilityHandler;
import com.pixelsky.goldrush.handler.CheeseCommonHandler;
import com.pixelsky.goldrush.handler.CheeseGuiHandler;
import com.pixelsky.goldrush.handler.CheesePacketHandler;
import com.pixelsky.goldrush.init.*;
import com.pixelsky.goldrush.world.gen.CheeseGeneration;
import com.pixelsky.goldrush.world.gen.MapGenCheeseVillage;
import com.pixelsky.goldrush.world.gen.StructureCheeseVillagePieces;
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
	private void registerHandler(GoldRush inst) {
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

	    new ModFluid();
		RegistrationHandler.init();

		new CheeseSpawnPlacementRegistry();
		new CreativeTabs();
		new CheesePacketHandler();
		new CheeseDimensions();
	}

	@Override
	public void init(FMLInitializationEvent event) {
		new CheeseRecipes();
	registerHandler(GoldRush.Instance);
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
