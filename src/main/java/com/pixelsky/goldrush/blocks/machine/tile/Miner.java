package com.pixelsky.goldrush.blocks.machine.tile;

import com.pixelsky.goldrush.Debug;
import com.pixelsky.goldrush.blocks.machine.MachineMiner;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;

import java.util.List;

//todo 修复restore
public class Miner extends TileEntity implements ITickable {
    private final MachineMiner machineMiner;
    public ItemStackHandler handler;
   //前7个槽用于放置升级
    private NonNullList<ItemStack> containerItems = NonNullList.<ItemStack>withSize(27, ItemStack.EMPTY);
    private BlockPos currenMinePos;
    private long destroyProgress =0;
    private int timeToReflesh=10;

    public Miner(MachineMiner machineMiner){
        this.machineMiner = machineMiner;
        this.handler=new ItemStackHandler();
    }

    //挖矿代码
    private void getNextBlock(){

        int center_y = MathHelper.floor(this.pos.getY());
        int center_x = MathHelper.floor(this.pos.getX());
        int center_z = MathHelper.floor(this.pos.getZ());
        if(currenMinePos==null){
            currenMinePos=new BlockPos(-machineMiner.getRange()+center_x,center_y-1,-machineMiner.getRange()+center_z);
        }
        Debug.info("获取下一个方块中");
        Debug.info("当前方块"+ currenMinePos);
        if(!checkNull(currenMinePos))
            return;
        for (int expand_X = -machineMiner.getRange(); expand_X <= +machineMiner.getRange(); ++expand_X) {
            for (int expand_z = -machineMiner.getRange(); expand_z <= +machineMiner.getRange(); ++expand_z) {
                for (int expend_y = -1; expend_y >=-machineMiner.getRange(); --expend_y) {
                    int result_x = center_x + expand_X;
                    int result_y = center_y + expend_y;
                    int result_z = center_z + expand_z;
                    BlockPos blockpos = new BlockPos(result_x, result_y, result_z);
                    Debug.info("Current pos" +result_x+"|"+result_y+"|"+result_z);
                    if (!checkNull(new BlockPos(result_x,result_y,result_z)) ){
                        currenMinePos = new BlockPos(result_x,result_y,result_z);
                        Debug.info("Current Breaking"+ currenMinePos);
                        break;
                    }
                }
            }
        }

    }
    private void damageBlock(){
        if(destroyProgress>=getDestroyTime())
        {

            //消除所有裂痕并破坏掉
            //于BC的源码有变动
            world.sendBlockBreakProgress(getCurrentBlock().hashCode(), currenMinePos,-1);
            world.playEvent(2001, currenMinePos, Block.getStateId(getCurrentBlock()));

            List<ItemStack> itemStackList = getCurrentBlock().getBlock().getDrops(world, currenMinePos,getCurrentBlock(), machineMiner.getFortune());
            world.setBlockState(currenMinePos, Blocks.AIR.getDefaultState(),3);

            for (ItemStack stack : itemStackList)
            {
                    EntityItem entityItem = new EntityItem(world, currenMinePos.getX(), currenMinePos.getY(), currenMinePos.getZ(),stack);
                    entityItem.attackEntityFrom(DamageSource.LAVA, -Integer.MAX_VALUE + 10);
                    entityItem.setGlowing(true);
                    world.spawnEntity(entityItem);
            }
        }else
        {
            destroyProgress=destroyProgress+1000000* machineMiner.getSpeed();
            //修改方块的裂痕进程 最后一个参数范围0-9
            world.sendBlockBreakProgress(getCurrentBlock().getBlock().hashCode(), currenMinePos,(int)((destroyProgress*9)/getDestroyTime()));
        }
    }
    private void floatItem(){
        AxisAlignedBB AABB = new AxisAlignedBB(pos.getX()- machineMiner.getRange(),pos.getY()- machineMiner.getRange(),pos.getZ()- machineMiner.getRange(),pos.getX()+ machineMiner.getRange(),pos.getY(),pos.getZ()+ machineMiner.getRange());
        for(EntityItem im:world.getEntitiesWithinAABB(EntityItem.class, AABB)){

            im.addVelocity(Math.random()*2,Math.random()*3,Math.random()*2);
        }

    }
    private boolean reflesh(){
        if(timeToReflesh<0){
            timeToReflesh=10;
            return true;
        }
        timeToReflesh--;
        return false;
    }

    //更新
    @Override
    public void update()
    {
        if (!reflesh())return;

        //检测是否是工作模式
    if (!check())return;
        Debug.info("工作");
    //获取下一个破坏的方块
        getNextBlock();
    //破坏方块
        damageBlock();
    //漂浮物品
        floatItem();
    }
    //util

    private IBlockState getCurrentBlock(){
        return world.getBlockState(currenMinePos);
    }
    private boolean check(){
       return (!this.world.isRemote&&isRunning());
    }

    private boolean isRunning() {
   return world.isBlockPowered(getPos());
    }

    private boolean checkNull(BlockPos pos){
        return world.getBlockState(pos)==Blocks.AIR.getDefaultState();
    }
    private long getDestroyTime(){

       return (long) Math.floor(16 * 1_000_000L * ((getHardness() + 1) * 2) * 1);
    }

    private float getHardness(){
    return  world.getBlockState(pos).getBlockHardness(world, currenMinePos);
    }

}
