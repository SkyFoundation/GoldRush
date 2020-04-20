package com.pixelsky.goldrush.blocks.ore.dirtore;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.init.CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.util.Random;

//
public class DirtCoalOre extends Block
{
	private final String name="dirt_coal_ore";
	public DirtCoalOre()
	{
		super(Material.CLAY);
		this.setDefaultState(this.blockState.getBaseState());
		this.setHardness(blockHardness+0.5f);
		setRegistryName(new ResourceLocation(Reference.MODID,name))
		.setTranslationKey(name)
		.setCreativeTab(CreativeTabs.GOLD_RUSH);
	}
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Blocks.COAL_ORE.getItemDropped(state,rand,fortune);
	}
}
