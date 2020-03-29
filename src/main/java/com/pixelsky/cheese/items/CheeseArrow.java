package com.pixelsky.cheese.items;

import com.pixelsky.cheese.entities.cheesearrow.EntityCheeseArrow;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CheeseArrow extends ItemArrow {
	
	public CheeseArrow() {
		super();
	}
	
	@Override
	public EntityArrow createArrow(World world, ItemStack stack, EntityLivingBase shooter) {
        return new EntityCheeseArrow(world, shooter);
    }

}
