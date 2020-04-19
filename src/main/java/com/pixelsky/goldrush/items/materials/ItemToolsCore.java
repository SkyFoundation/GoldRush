package com.pixelsky.goldrush.items.materials;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.init.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;


//工具核心
public class ItemToolsCore extends Item
{
	private final String name="tools_core";
	
	public ItemToolsCore()
	{
		super();
		setRegistryName(new ResourceLocation(Reference.MODID, name))
		.setTranslationKey(name)
		.setCreativeTab(CreativeTabs.GOLD_RUSH);
    }
}
