package com.pixelsky.goldrush.items.materials;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.init.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;


//单轴双轮
public class ItemUniaxialTwoWheel extends Item
{
	private final String name="uniaxial_two_wheel";
	
	public ItemUniaxialTwoWheel()
	{
		super();
		setRegistryName(new ResourceLocation(Reference.MODID, name))
		.setTranslationKey(name)
		.setCreativeTab(CreativeTabs.GOLD_RUSH);
    }

}
