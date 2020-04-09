package com.pixelsky.cheese.handler;

import com.pixelsky.cheese.capability.haditems.HadItemsProvider;
import com.pixelsky.cheese.capability.haditems.IHadItems;
import com.pixelsky.cheese.capability.shouldgiveitems.IShouldGiveItems;
import com.pixelsky.cheese.capability.shouldgiveitems.ShouldGiveItems;
import com.pixelsky.cheese.capability.shouldgiveitems.ShouldGiveItemsProvider;
import com.pixelsky.cheese.init.CheeseBlocks;
import com.pixelsky.cheese.init.CheeseItems;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;

import java.util.Random;

public class CheeseCommonHandler {

	@SubscribeEvent
	public void onWorldLoad(WorldEvent.Load event) {
		World world = event.getWorld();
		IShouldGiveItems shouldGive = world.getCapability(ShouldGiveItemsProvider.SHOULD_GIVE_CAP, null);
		shouldGive.set(ShouldGiveItems.worldCreateGive);
	}

	@SubscribeEvent
	public void onBonemeal(BonemealEvent event) {
		event.setCanceled(true);
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		IBlockState state = world.getBlockState(pos);
		EntityPlayer player = event.getEntityPlayer();
		ItemStack stack;
		if (player.getHeldItemMainhand().getItem() == Items.DYE && player.getHeldItemMainhand().getMetadata() == 15) {
			stack = player.getHeldItemMainhand();
		} else if (player.getHeldItemOffhand().getItem() == Items.DYE
				&& player.getHeldItemOffhand().getMetadata() == 15) {
			stack = player.getHeldItemOffhand();
		} else {
			stack = ItemStack.EMPTY;
		}
		boolean grown = false;
		IGrowable igrowable;
		if (!world.isRemote) {
			while (state.getBlock() instanceof IGrowable
					&& (igrowable = (IGrowable) state.getBlock()).canGrow(world, pos, state, world.isRemote)) {
				igrowable.grow(world, world.rand, pos, state);
				state = world.getBlockState(pos);
				grown = true;
			}
			if (grown) {
				stack.shrink(1);
			}
		}
	}

	@SubscribeEvent
	public void onPlayerJoin(PlayerLoggedInEvent event) {
		EntityPlayer player = event.player;
		World world = player.world;
		IShouldGiveItems shouldGive = world.getCapability(ShouldGiveItemsProvider.SHOULD_GIVE_CAP, null);
		if (shouldGive.get()) {
			if (world.isRemote)
				return;
			IHadItems hadItems = player.getCapability(HadItemsProvider.HAD_ITEMS_CAP, null);
			if (!hadItems.get()) {
				hadItems.set(true);
				if (!player.inventory.addItemStackToInventory(new ItemStack(CheeseItems.CHEESE, 16))) {
					player.world.spawnEntity(new EntityItem(player.world, player.posX, player.posY, player.posZ,
							new ItemStack(CheeseItems.CHEESE, 16)));
				}
			}
		}
	}

	//没吃cheesee饿死?
	/*
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		ICheese cheese = player.getCapability(CheeseProvider.CHEESE_CAP, null);
		Random random = new Random();
		World world = player.world;
		if (random.nextInt(1500) == 0 && !player.isCreative()
				&& world.getWorldInfo().getDifficulty() != EnumDifficulty.PEACEFUL) {
			cheese.remove(1);
		}
		if (cheese.get() <= 0 && random.nextInt(25) == 0 && !player.isCreative()
				&& world.getWorldInfo().getDifficulty() != EnumDifficulty.PEACEFUL) {
			player.attackEntityFrom(DamageSource.STARVE, 1.5F);
			cheese.set(0);
		}
		if (world.getWorldInfo().getDifficulty() == EnumDifficulty.PEACEFUL && random.nextInt(5) == 0) {
			cheese.add(random.nextInt(2));
		}
	}*/

	@SubscribeEvent
	public void playerInteract(LeftClickBlock event) {
		EnumHand hand = event.getHand();
		BlockPos pos = event.getPos();
		World world = event.getWorld();
		EntityPlayer player = event.getEntityPlayer();
		pos = pos.offset(event.getFace());
		if (world.getBlockState(pos).getBlock() == CheeseBlocks.CHEESE_FIRE && hand == EnumHand.MAIN_HAND) {
			event.setCanceled(true);
			if (world.isRemote)
				world.playSound(player, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.8F, 1.5F);
			if (!world.isRemote)
				world.setBlockToAir(pos);
		}
	}

	@SubscribeEvent
	public void playerTick(TickEvent.PlayerTickEvent event) {
		EntityPlayer player = event.player;
		World world = player.world;
		BlockPos pos = player.getPosition();
		Random random = new Random();
		if (world.getBlockState(pos.west()).getBlock() == CheeseBlocks.CHEESE_FIRE
				|| world.getBlockState(pos.east()).getBlock() == CheeseBlocks.CHEESE_FIRE
				|| world.getBlockState(pos.north()).getBlock() == CheeseBlocks.CHEESE_FIRE
				|| world.getBlockState(pos.south()).getBlock() == CheeseBlocks.CHEESE_FIRE) {
			if (!world.isRemote && random.nextInt(20) == 0 && !player.isImmuneToFire() && !player.isCreative()
					&& event.phase == Phase.END) {
				player.setFire(random.nextInt(5) + 5);
			}
		}
	}
}
