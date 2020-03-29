package com.pixelsky.cheese.init;

import com.pixelsky.cheese.Reference;
import com.pixelsky.cheese.world.biome.BiomeCheese;
import com.pixelsky.cheese.world.biome.BiomeCheeseDimension;
import net.minecraft.block.Block;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


@Mod.EventBusSubscriber(modid = "dgm")
public class CheeseBiomes {
	
	public static Biome CHEESE_BIOME;
	public static Biome CHEESE_DIMENSION_BIOME;
	
	public CheeseBiomes() {
		init();
	}
	
	public static void init() {
		CHEESE_BIOME = new BiomeCheese(new BiomeProperties(TextFormatting.YELLOW + "Cheese" + TextFormatting.RESET).setWaterColor(0xD6FF42).setRainDisabled()).setRegistryName(Reference.MODID, "cheese_biome");
		CHEESE_DIMENSION_BIOME = new BiomeCheeseDimension(new BiomeProperties(TextFormatting.YELLOW + "Cheese Dimension" + TextFormatting.RESET).setWaterColor(0xD6FF42).setRainDisabled()).setRegistryName(Reference.MODID, "cheese_dimension_biome");
	}

	@SubscribeEvent
	public static void register(RegistryEvent.Register<Biome> event)  {
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(CHEESE_BIOME, 3));
		event.getRegistry().register(CHEESE_BIOME);
		event.getRegistry().register(CHEESE_DIMENSION_BIOME);
	}
	
}
