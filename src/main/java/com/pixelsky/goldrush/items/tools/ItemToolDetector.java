package com.pixelsky.goldrush.items.tools;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.init.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemToolDetector extends Item {
    private final String name="robot_destroyer";
    public ItemToolDetector(){
        super();
        setRegistryName(new ResourceLocation(Reference.MODID,name))
                .setTranslationKey(name)
                .setCreativeTab(CreativeTabs.GOLD_RUSH);
    }
}
