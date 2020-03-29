package com.pixelsky.cheese.items;

import com.pixelsky.cheese.capability.cheese.CheeseProvider;
import com.pixelsky.cheese.capability.cheese.ICheese;
import com.pixelsky.cheese.init.CheeseAchievements;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Cheese extends ItemFood {

	public Cheese(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setAlwaysEdible();
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		if (entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityLiving;
			player.addStat(CheeseAchievements.EAT);
			ICheese cheese = player.getCapability(CheeseProvider.CHEESE_CAP, null);
			cheese.add(2);
		}
		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}
}
