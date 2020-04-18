package com.pixelsky.goldrush.items.materials;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.init.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

//铁棍棒
public class ItemIronBar  extends Item
{
	private final String name="iron_bar";
	
	public ItemIronBar()
	{
		super();
		setRegistryName(new ResourceLocation(Reference.MODID, name))
		.setTranslationKey(name)
		.setCreativeTab(CreativeTabs.GOLD_RUSH);
    }
}
