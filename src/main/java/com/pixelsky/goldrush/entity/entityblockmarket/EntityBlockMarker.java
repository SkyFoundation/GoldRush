package com.pixelsky.goldrush.entity.entityblockmarket;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
//todo 修复无法在不现实碰撞箱的情况下,能够现实边框
//现在只有在F3+B的状态下才可以找到矿石
public class EntityBlockMarker extends Entity {
    //与检测器相等
    private long time=1000;
    private EntityBlockMarker(World worldIn) {
        super(worldIn);;
        this.setSize(1,1);
    }

    public EntityBlockMarker(World world, BlockPos pos) {
        super(world);
        this.setPosition(pos.getX()+0.5,pos.getY(),pos.getZ()+0.5);
        this.setSize(1,1);
    }

    @Override
    public boolean processInitialInteract(EntityPlayer player, EnumHand hand) {
        return false;
    }

    @Override
    protected void entityInit() {
    this.setGlowing(true);
    }

    @Override
    public void onEntityUpdate() {
        this.time=time-1;
        if(time<=0)
            //防止实体未被自动清除
            this.setDead();
        this.onRemovedFromWorld();
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {

    }
}
