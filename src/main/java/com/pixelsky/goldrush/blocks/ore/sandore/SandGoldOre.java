package com.pixelsky.goldrush.blocks.ore.sandore;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.init.CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

//
public class SandGoldOre extends BlockFalling
{
	private final String name="sand_gold_ore";
	public SandGoldOre()
	{
		super(Material.SAND);
		this.setHardness(blockHardness+1.3f);
		setRegistryName(new ResourceLocation(Reference.MODID,name))
		.setTranslationKey(name)
		.setCreativeTab(CreativeTabs.GOLD_RUSH);
	}
}
