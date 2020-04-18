package com.pixelsky.goldrush.blocks.ore.sandore;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.init.CreativeTabs;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

//
public class SandCoalOre  extends BlockFalling
{
	private final String name="sand_coal_ore";
	public SandCoalOre()
	{
		super(Material.SAND);
		this.setHardness(blockHardness+1);
		setRegistryName(new ResourceLocation(Reference.MODID,name))
		.setTranslationKey(name)
		.setCreativeTab(CreativeTabs.GOLD_RUSH);
	}
}
