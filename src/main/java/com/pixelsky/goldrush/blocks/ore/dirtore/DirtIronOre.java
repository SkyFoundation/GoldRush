package com.pixelsky.goldrush.blocks.ore.dirtore;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.init.CreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

//
public class DirtIronOre extends Block
{
	private final String name="dirt_iron_ore";
	public DirtIronOre()
	{
		super(Material.ROCK);
		setRegistryName(new ResourceLocation(Reference.MODID,name))
		.setTranslationKey(name)
		.setCreativeTab(CreativeTabs.GOLD_RUSH);
	}
}
