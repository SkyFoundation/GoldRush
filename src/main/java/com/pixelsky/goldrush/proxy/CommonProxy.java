package com.pixelsky.goldrush.proxy;

import com.pixelsky.goldrush.GoldRush;
import com.pixelsky.goldrush.handler.GuiHandler;
import com.pixelsky.goldrush.init.CreativeTabs;
import com.pixelsky.goldrush.init.ModFluid;
import com.pixelsky.goldrush.init.RegistrationHandler;
import com.pixelsky.goldrush.world.WorldGenOres;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy implements IProxy{
	private void registerCommonEventHandler() {
	//	MinecraftForge.EVENT_BUS.register(new CheeseCommonHandler());
	//	MinecraftForge.EVENT_BUS.register(new CheeseCapabilityHandler());
	}
	private void registerHandler(GoldRush inst) {
		NetworkRegistry.INSTANCE.registerGuiHandler(inst, new GuiHandler());
	}
	private void registerWorldGen() {
		GameRegistry.registerWorldGenerator(new WorldGenOres(), 0);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {

	    new ModFluid();
		RegistrationHandler.init();

		new CreativeTabs();
		//new CheesePacketHandler();
		//new CheeseDimensions();
	}

	@Override
	public void init(FMLInitializationEvent event) {
	//	new CheeseRecipes();
	registerHandler(GoldRush.Instance);
	registerCommonEventHandler();
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		registerWorldGen();
	}

	@Override
	public void serverStart(FMLServerStartingEvent event) {
	//new CheeseCommands(event);
	}
}
