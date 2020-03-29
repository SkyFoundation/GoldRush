package com.pixelsky.cheese.blocks;

import com.pixelsky.cheese.DeGeweldigeMod;
import com.pixelsky.cheese.handler.CheeseGuiHandler;
import com.pixelsky.cheese.init.CheeseItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class ComplimentMachine extends Block {
	public Random random = new Random();

	public ComplimentMachine() {
		super(Material.PISTON);
	}

	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing heldItem, float side, float hitX, float hitY) {
		int compliment = random.nextInt(8);
		Item holdingItem = playerIn.getHeldItemMainhand() != null ? playerIn.getHeldItemMainhand().getItem() : null;
		if (playerIn.isCreative()) {
			if (worldIn.isRemote) {
				playerIn.openGui(DeGeweldigeMod.DGMInstance, CheeseGuiHandler.COMPLIMENTGUIID, worldIn, pos.getX(), pos.getY(), pos.getZ());
				return true;
			}
		}
		if (!playerIn.isCreative()) {
			if (worldIn.isRemote && holdingItem != null && holdingItem == CheeseItems.CHEESE) {
				playerIn.openGui(DeGeweldigeMod.DGMInstance, CheeseGuiHandler.COMPLIMENTGUIID, worldIn, pos.getX(), pos.getY(), pos.getZ());
				return true;
			} else if(holdingItem != null && holdingItem == CheeseItems.CHEESE){
				removeItem(playerIn);
				playerIn.addExperience(14);
			}
		}
		return true;
	}

	public void removeItem(EntityPlayer playerIn) {
		playerIn.inventory.decrStackSize(playerIn.inventory.currentItem, 1);
	}
}
