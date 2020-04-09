package com.pixelsky.cheese.init;

import com.pixelsky.cheese.Reference;
import com.pixelsky.cheese.world.biome.BiomeCheese;
import com.pixelsky.cheese.world.biome.BiomeCheeseDimension;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;



public class CheeseBiomes implements IRegistery{
	
	public static Biome CHEESE_BIOME;
	public static Biome CHEESE_DIMENSION_BIOME;
	
	public CheeseBiomes() {
		init();
		register();
	}
	
	public  void init() {
		CHEESE_BIOME = new BiomeCheese(new BiomeProperties(TextFormatting.YELLOW + "Cheese" + TextFormatting.RESET).setWaterColor(0xD6FF42).setRainDisabled()).setRegistryName(Reference.MODID, "cheese_biome");
		CHEESE_DIMENSION_BIOME = new BiomeCheeseDimension(new BiomeProperties(TextFormatting.YELLOW + "Cheese Dimension" + TextFormatting.RESET).setWaterColor(0xD6FF42).setRainDisabled()).setRegistryName(Reference.MODID, "cheese_dimension_biome");
	}

	public  void register(  ) {
		RegistrationHandler.Biomes.add(CHEESE_BIOME);
		RegistrationHandler.Biomes.add(CHEESE_DIMENSION_BIOME);
	}
	
}
