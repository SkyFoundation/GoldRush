package com.pixelsky.goldrush.init;

import net.minecraft.command.CommandBase;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class CheeseCommands {

	public static CommandBase FILL_CHEESE;
	

	public CheeseCommands(FMLServerStartingEvent event) {
		init();
		register(event);
	}
	
	public void init() {
		//FILL_CHEESE = new FillCheese();
	}
	
	public void register(FMLServerStartingEvent event) {
		event.registerServerCommand(FILL_CHEESE);
	}
}
