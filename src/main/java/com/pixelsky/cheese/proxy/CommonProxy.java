package com.pixelsky.cheese.proxy;

import com.pixelsky.cheese.DeGeweldigeMod;
import com.pixelsky.cheese.handler.CheeseCapabilityHandler;
import com.pixelsky.cheese.handler.CheeseCommonHandler;
import com.pixelsky.cheese.handler.CheeseGuiHandler;
import com.pixelsky.cheese.world.gen.CheeseGeneration;
import com.pixelsky.cheese.world.gen.MapGenCheeseVillage;
import com.pixelsky.cheese.world.gen.StructureCheeseVillagePieces;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public void registerStructure() {
		MapGenStructureIO.registerStructure(MapGenCheeseVillage.Start.class, "CheeseVillage");
		StructureCheeseVillagePieces.registerVillagePieces();
	}
	
	public void registerModels() {
		
	}
	
	public void renderEntities() {
		
	}
	
	public void bindTileEntities() {
		
	}
	
	public void setTitle(String title) {
		
	}
	
	public void registerCommonEventHandler() {
		MinecraftForge.EVENT_BUS.register(new CheeseCommonHandler());
		MinecraftForge.EVENT_BUS.register(new CheeseCapabilityHandler());
	}
	
	public void registerClientEventHandler() {
		
	}
	
	public void registerWorldGen() {
		GameRegistry.registerWorldGenerator(new CheeseGeneration(), 0);
	}

	public void registerHandler(DeGeweldigeMod inst) {
		NetworkRegistry.INSTANCE.registerGuiHandler(inst, new CheeseGuiHandler());
	}
}
