package com.pixelsky.cheese.entities.cheesemouse;

import com.pixelsky.cheese.entities.LootTables;
import com.pixelsky.cheese.init.CheeseItems;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;

//TODO 改为中立
public class EntityCheeseMouse extends EntityRabbit {
    public EntityCheeseMouse(World worldIn) {
        super(worldIn);
        this.setSize(0.4F, 0.2F);
    }

    public EntityCheeseMouse createChild(EntityAgeable ageable) {
        return new EntityCheeseMouse(this.world);
    }
    @Override
    public boolean isBreedingItem(@Nullable ItemStack stack) {
        return stack != null && stack.getItem() == CheeseItems.CHEESE;
    }
    @Nullable
    protected ResourceLocation getLootTable() {
        return LootTables.ENTITY_CHEESE_MOUSE;
    }
}