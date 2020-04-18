package com.pixelsky.goldrush.items.tools;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.entity.robotTerminator.RobotTerminator;
import com.pixelsky.goldrush.init.CreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


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

	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		Block block=worldIn.getBlockState(pos).getBlock();
		if(!canUse(block))
		return EnumActionResult.PASS;
		player.getHeldItem(hand).shrink(1);
		worldIn.setBlockToAir(pos);
		//player.playSound();
		ItemStack im=drop();
		if (im!=null) {
			EntityItem item = new EntityItem(worldIn);
			item.setItem(im);
			worldIn.spawnEntity(item);
		}
		return EnumActionResult.SUCCESS;
	}
	private boolean canUse(Block block){
		return block== Blocks.SAND||block==Blocks.DIRT;
	}
	private ItemStack drop(){
	double random=Math.random();
	int ammount = (int) (random+Math.random()*2);
	if(random>0.5)
		return null;
	else if (random>0.6)
		return new ItemStack(Items.GOLD_NUGGET,ammount);
	else if(random>0.7)
		return new ItemStack(Items.IRON_NUGGET,ammount);
	else if (random>0.8)
		return new ItemStack(Items.GOLD_INGOT,ammount);
	else if(random>0.9)
		return new ItemStack(Items.EMERALD,ammount);
	else if (random>0.95)
		return new ItemStack(Items.DIAMOND,ammount);
	else if (random>0.99)
		return new ItemStack(Items.NETHER_STAR,ammount);
	return new ItemStack(Items.DRAGON_BREATH,ammount);
	}
}
