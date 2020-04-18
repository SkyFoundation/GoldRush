package com.pixelsky.goldrush.items.materials;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.init.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

//齿轮
public class ItemGear extends Item
{
private final String name="gear";
	
	public ItemGear()
	{
		super();
		setRegistryName(new ResourceLocation(Reference.MODID, name))
		.setTranslationKey(name)
		.setCreativeTab(CreativeTabs.GOLD_RUSH);
    }
}


