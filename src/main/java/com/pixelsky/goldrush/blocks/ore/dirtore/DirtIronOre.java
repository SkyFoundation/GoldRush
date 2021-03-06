package com.pixelsky.goldrush.blocks.ore.dirtore;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.init.CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.util.Random;

//
public class DirtIronOre extends Block
{
	private final String name="dirt_iron_ore";
	public DirtIronOre()
	{
		super(Material.CLAY);
		this.setDefaultState(super.getDefaultState());
		this.setHardness(blockHardness+1f);
		setRegistryName(new ResourceLocation(Reference.MODID,name))
		.setTranslationKey(name)
		.setCreativeTab(CreativeTabs.GOLD_RUSH);
	}
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Items.IRON_INGOT;
	}
}
