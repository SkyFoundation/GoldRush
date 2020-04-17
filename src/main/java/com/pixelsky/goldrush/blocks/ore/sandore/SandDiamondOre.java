package com.pixelsky.goldrush.blocks.ore.sandore;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.init.CreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

//
public class SandDiamondOre extends Block
{
	private final String name="sand_diamond_ore";
	public SandDiamondOre()
	{
		super(Material.ROCK);
		setRegistryName(new ResourceLocation(Reference.MODID,name))
		.setTranslationKey(name)
		.setCreativeTab(CreativeTabs.GOLD_RUSH);
	}
}
