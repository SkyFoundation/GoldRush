package com.pixelsky.goldrush.items.tools;

import com.pixelsky.goldrush.Debug;
import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.init.CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
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
		.setCreativeTab(CreativeTabs.GOLD_RUSH)
				.setMaxDamage(18)
				.setMaxStackSize(1);
    }

	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(hand!=EnumHand.MAIN_HAND)
			return EnumActionResult.PASS;

		if(worldIn.isRemote)
			return EnumActionResult.PASS;

		Block block=worldIn.getBlockState(pos).getBlock();
		if(!canUse(block))
		return EnumActionResult.PASS;
		player.getHeldItem(hand).damageItem(1,player);
		worldIn.setBlockToAir(pos);
		//player.playSound();
		ItemStack im=drop();
		if (im!=null) {
		//	Debug.info(im.getDisplayName());
			EntityItem item = new EntityItem(worldIn);
			item.setItem(im);
			item.setPosition(pos.getX(),pos.getY(),pos.getZ());
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
	if(random<0.4)
		return null;
	else if(random >0.4&&random<0.8)
		return new ItemStack(Items.FLINT,ammount);
	else if (random>0.8&&random<0.9)
		return new ItemStack(Items.GOLD_NUGGET,ammount);
	else if(random>0.9&&random<0.93)
		return new ItemStack(Items.IRON_NUGGET,ammount);
	else if (random>0.93&&random<0.97)
		return new ItemStack(Items.GOLD_INGOT,ammount);
	else if(random>0.97&&random<0.99)
		return new ItemStack(Items.EMERALD,ammount);
	else if (random>0.99&&random<0.999)
		return new ItemStack(Items.DIAMOND,ammount);
	else if (random>0.999&&random<1)
		return new ItemStack(Items.NETHER_STAR,ammount);
	return new ItemStack(Items.DRAGON_BREATH,ammount);
	}
}
