package com.pixelsky.goldrush.blocks.ore.dirtore;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.init.CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

//
public class DirtCoalOre extends Block
{
	private final String name="dirt_coal_ore";
	public DirtCoalOre()
	{
		super(Material.GROUND);
		this.setHardness(blockHardness+0.5f);
		setRegistryName(new ResourceLocation(Reference.MODID,name))
		.setTranslationKey(name)
		.setCreativeTab(CreativeTabs.GOLD_RUSH);
	}
}
