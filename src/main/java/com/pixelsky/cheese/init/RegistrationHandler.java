package com.pixelsky.cheese.init;

import com.pixelsky.cheese.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.LinkedList;
import java.util.List;

public class RegistrationHandler
{
    @Mod.EventBusSubscriber(modid = Reference.MODID)
    public static class Blocks
    {
        private static final List<Block> BLOCKS = new LinkedList<>();

        static void add(Block block)
        {
            BLOCKS.add(block);
        }

        @SubscribeEvent
        public static void register(final RegistryEvent.Register<Block> event)
        {
            BLOCKS.forEach(block -> event.getRegistry().register(block));
        }
    }
    @Mod.EventBusSubscriber(modid = Reference.MODID)
    public static class Biomes
    {
    private static final List<Biome> BIOMES = new LinkedList<>();

    static void add(Biome item)
    {
        BIOMES.add(item);
    }

    public static List<Biome> getBiomes()
    {
        return BIOMES;
    }

    @SubscribeEvent
    public static void register(final RegistryEvent.Register<Biome> event)
    {

        BIOMES.forEach(biome -> event.getRegistry().register(biome));
    }
    }


    @Mod.EventBusSubscriber(modid = Reference.MODID)
    public static class Items
    {
        private static final List<Item> ITEMS = new LinkedList<>();

        static void add(Item item)
        {
            ITEMS.add(item);
        }

        public static List<Item> getItems()
        {
            return ITEMS;
        }

        @SubscribeEvent
        public static void register(final RegistryEvent.Register<Item> event)
        {
            ITEMS.forEach(item -> event.getRegistry().register(item));
        }
    }


    @Mod.EventBusSubscriber(modid = Reference.MODID, value = Side.CLIENT)
    public static class Models
    {
        @SubscribeEvent
        public static void register(ModelRegistryEvent event)
        {
            Items.ITEMS.forEach(Models::registerRender);
        }

        private static void registerRender(Item item)
        {
                ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }


    @Mod.EventBusSubscriber(modid = Reference.MODID)
    public static class Sounds
    {
        public static final List<SoundEvent> SOUNDS = new LinkedList<>();

        static void add(SoundEvent sound)
        {
            SOUNDS.add(sound);
        }

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<SoundEvent> event)
        {
            SOUNDS.forEach(sound -> event.getRegistry().register(sound));
        }
    }


    public static void init()
    {
        new CheeseItems();
        new CheeseBlocks();
        new CheeseBiomes();
        new CheeseEntities();
        new CheeseRecipes();
        new CheeseCapabilitys();
    }
}