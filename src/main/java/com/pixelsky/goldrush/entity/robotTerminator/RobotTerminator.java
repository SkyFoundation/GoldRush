package com.pixelsky.goldrush.entity.robotTerminator;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class RobotTerminator extends Entity {
    private long cooldown_mine =300;
    private int speed_mine =20;
    private int range_mine =2;

    public RobotTerminator(World worldIn) {
        super(worldIn);
        this.setSize(0.5f,0.5f);
    }

    @Override
    protected void entityInit() {

    }
    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
        if(!checkVaild(world))
            return;

        // Debug.info("已更新升级组建");
        if(!checkCooldown())
            return;
        updateMotion();
        destroyBlocks();
    }
    private void updateMotion(){
        this.move(MoverType.SELF,0,-1,0);
        if(this.posY<5)
            this.setDead();
    }
    private boolean checkVaild(World w){
        //   Debug.info("当前世界是否"+w.isRemote);
        return !w.isRemote;
    }
    private boolean checkCooldown(){
        if(cooldown_mine <0){
            cooldown_mine =400;
            //    Debug.info("处理冷却中"+cooldown_mine);
            return true;
        }
        cooldown_mine = cooldown_mine - speed_mine;
        return false;
    }

    private void destroyBlocks() {
        // Debug.info("开始破坏方块");
        // Debug.info("blockbreakconunter--");
        if ( ! net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this)) {
            return;
        }
        int center_y = MathHelper.floor(this.posY);
        int center_x = MathHelper.floor(this.posX);
        int center_z = MathHelper.floor(this.posZ);
        for (int expand_X = -range_mine; expand_X <= +range_mine; ++expand_X) {
            for (int expand_z = -range_mine; expand_z <= +range_mine; ++expand_z) {
                for (int expend_y = -range_mine; expend_y <= +range_mine; ++expend_y) {
                    int result_x = center_x + expand_X;
                    int result_y = center_y + expend_y;
                    int result_z = center_z + expand_z;
                    BlockPos blockpos = new BlockPos(result_x, result_y, result_z);
                    IBlockState iblockstate = this.world.getBlockState(blockpos);
                    Block block = iblockstate.getBlock();
                    if (!block.isAir(iblockstate, this.world, blockpos) && block.canEntityDestroy(iblockstate, world, blockpos, this)) {
                        this.world.destroyBlock(blockpos, false);

                        for (ItemStack stack : block.getDrops(world,blockpos,iblockstate,1))
                        {
                            EntityItem entityItem = new EntityItem(world, result_x,result_y,result_z,stack);
                            entityItem.setGlowing(true);
                            entityItem.addVelocity(Math.random(),3,Math.random());
                            entityItem.attackEntityFrom(DamageSource.LAVA, -Integer.MAX_VALUE + 10);
                            world.spawnEntity(entityItem);
                        }
                    }
                }
            }
        }



    }
    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {

    }
}
