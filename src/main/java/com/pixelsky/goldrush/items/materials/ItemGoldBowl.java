package com.pixelsky.goldrush.items.materials;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.init.CreativeTabs;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;


//淘金碗
public class ItemGoldBowl extends Item
{
	private final String name="gold_bowl";
	
	public ItemGoldBowl()
	{
		super();
		setRegistryName(new ResourceLocation(Reference.MODID, name))
		.setTranslationKey(name)
		.setCreativeTab(CreativeTabs.GOLD_RUSH);
    }

}
