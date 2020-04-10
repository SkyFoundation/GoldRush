package com.pixelsky.cheese.entities.cheesemouse;

import com.google.common.base.Predicate;
import com.pixelsky.cheese.entities.LootTables;
import com.pixelsky.cheese.entities.cheesechicken.EntityCheeseChicken;
import com.pixelsky.cheese.entities.cheesecow.EntityCheeseCow;
import com.pixelsky.cheese.init.CheeseBlocks;
import com.pixelsky.cheese.init.CheeseItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCarrot;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

//TODO 改为中立
public class EntityCheeseMouse extends EntityRabbit {
    public EntityCheeseMouse(World worldIn) {
        super(worldIn);
        this.setSize(0.4F, 0.2F);

    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.2D));
        this.tasks.addTask(2, new EntityAIMate(this, 0.8D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.0D, CheeseItems.CHEESE, false));
        this.tasks.addTask(4, new EntityAIAvoidEntity<>(this, EntityPlayer.class, 10.0F, 2.2D, 2.2D));

        this.tasks.addTask(4, new EntityCheeseMouse.AIRaidBlock(this));
          this.tasks.addTask(5, new EntityCheeseMouse.AIRaidCrop(this));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 0.6D));
        this.tasks.addTask(8, new EntityAIOcelotAttack(this));
        this.tasks.addTask(11, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityCheeseChicken.class, false));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityCheeseCow.class, false));

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
    static class AIRaidCrop extends EntityAIMoveToBlock
    {
        private final EntityCheeseMouse rabbit;

        public AIRaidCrop(EntityCheeseMouse rabbitIn)
        {
            super(rabbitIn, 0.699999988079071D, 16);
            this.rabbit = rabbitIn;
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            if (this.runDelay <= 0)
            {
                if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.rabbit.world, this.rabbit))
                {
                    return false;
                }
            }

            return super.shouldExecute();
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            super.updateTask();
            this.rabbit.getLookHelper().setLookPosition((double)this.destinationBlock.getX() + 0.5D, (double)(this.destinationBlock.getY() + 1), (double)this.destinationBlock.getZ() + 0.5D, 10.0F, (float)this.rabbit.getVerticalFaceSpeed());
            if (this.getIsAboveDestination())
            {
                World world = this.rabbit.world;
                BlockPos blockpos = this.destinationBlock.up();
                IBlockState iblockstate = world.getBlockState(blockpos);
                Block block = iblockstate.getBlock();

                if ( block instanceof BlockCrops)
                {
                       world.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 2);
                        world.destroyBlock(blockpos, true);

                    this.rabbit.createEatingParticles();
                }
                this.runDelay = 10;
            }
        }

        /**
         * Return true to set given position as destination
         */
        protected boolean shouldMoveTo(World worldIn, BlockPos pos)
        {
            Block block = worldIn.getBlockState(pos).getBlock();

            if (block == Blocks.FARMLAND)
            {
                pos = pos.up();
                IBlockState iblockstate = worldIn.getBlockState(pos);
                block = iblockstate.getBlock();

                if (block instanceof BlockCrops)
                {
                    return true;
                }
            }

            return false;
        }
    }
    static class AIRaidBlock extends EntityAIMoveToBlock
    {
        private final EntityCheeseMouse rabbit;

        public AIRaidBlock(EntityCheeseMouse rabbitIn)
        {
            super(rabbitIn, 0.699999988079071D, 16);
            this.rabbit = rabbitIn;
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            if (this.runDelay <= 0)
            {
                if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.rabbit.world, this.rabbit))
                {
                    return false;
                }

            }

            return super.shouldExecute();
        }


        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            super.updateTask();
            this.rabbit.getLookHelper().setLookPosition((double)this.destinationBlock.getX() + 0.5D, (double)(this.destinationBlock.getY() + 1), (double)this.destinationBlock.getZ() + 0.5D, 10.0F, (float)this.rabbit.getVerticalFaceSpeed());
            if (this.getIsAboveDestination())
            {
                World world = this.rabbit.world;
                BlockPos blockpos = this.destinationBlock;
                IBlockState iblockstate = world.getBlockState(blockpos);
                Block block = iblockstate.getBlock();
               boolean isRaidBlock= block == CheeseBlocks.CHEESE_BLOCK||block == CheeseBlocks.CHEESE_STONE;
                if ( isRaidBlock)
                {
                        world.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 2);
                        world.destroyBlock(blockpos, true);
                    this.rabbit.createEatingParticles();
                }
                this.runDelay = 10;
            }
        }

        /**
         * Return true to set given position as destination
         */
        protected boolean shouldMoveTo(World worldIn, BlockPos pos)
        {
            Block block = worldIn.getBlockState(pos).getBlock();


            if (block == CheeseBlocks.CHEESE_BLOCK||block == CheeseBlocks.CHEESE_STONE )
            {
               return true;
            }

            return false;
        }
    }

}