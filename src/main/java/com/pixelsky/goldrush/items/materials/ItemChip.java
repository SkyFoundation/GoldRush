package com.pixelsky.goldrush.items.materials;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.init.CreativeTabs;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

//芯片
public class ItemChip extends Item
{
	private final String name="chip";
	
	public ItemChip()
	{
		super();
		setRegistryName(new ResourceLocation(Reference.MODID, name))
		.setTranslationKey(name)
		.setCreativeTab(CreativeTabs.GOLD_RUSH);
    }
    
	
	
}
