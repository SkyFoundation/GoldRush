package com.pixelsky.goldrush.entity;

import com.pixelsky.goldrush.blocks.machine.MachineBlockDetector;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityBlockMark extends Entity {
    //与检测器相等
    private long time=1000;
    private EntityBlockMark(World worldIn) {
        super(worldIn);;
    }

    public EntityBlockMark(World world, BlockPos pos) {
        super(world);
        this.setPosition(pos.getX(),posY,posZ);
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
