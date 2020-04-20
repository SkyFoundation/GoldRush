package com.pixelsky.goldrush.blocks.ore.sandore;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.init.CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.util.Random;

//
public class SandRedstoneOre extends BlockFalling
{
	private final String name="sand_redstone_ore";
	public SandRedstoneOre()
	{
		super(Material.SAND);
		this.setHardness(blockHardness+0.4f);
		setRegistryName(new ResourceLocation(Reference.MODID,name))
		.setTranslationKey(name)
		.setCreativeTab(CreativeTabs.GOLD_RUSH);
	}
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Blocks.REDSTONE_ORE.getItemDropped(state,rand,fortune);
	}
}
