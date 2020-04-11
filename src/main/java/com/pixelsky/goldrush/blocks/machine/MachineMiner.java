package com.pixelsky.goldrush.blocks.machine;

import com.pixelsky.goldrush.GoldRush;
import com.pixelsky.goldrush.handler.GuiHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.List;

public class MachineMiner extends BlockContainer implements IMachine{
    private final String name="machine_miner";
    private boolean isRunning;
    private long speed=5;
    private int range=1;
    private int fortune=1;

    public MachineMiner() {
        super(Material.ROCK);
        handelScopeUpgrade();
        handelSpeedUpgrade();
    }

    //getters
    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getFortune() {
        return fortune;
    }

    public void setFortune(int fortune) {
        this.fortune = fortune;
    }

    //process
    @Override
    public void handelScopeUpgrade() {
        //todo updgrade scope
    }

    @Override
    public void handelSpeedUpgrade() {
        //todo updgrade speed
    }
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            playerIn.openGui(GoldRush.Instance, GuiHandler.Miner, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }

     //XXX 暂未测试
   public class Miner extends TileEntity implements ITickable {
       public ItemStackHandler handler;
       public final int tileX=this.getPos().getX();
       public final int tileY=this.getPos().getY();
       public final int tileZ=this.getPos().getZ();
       //前7个槽用于放置升级
        private NonNullList<ItemStack> containerItems = NonNullList.<ItemStack>withSize(27, ItemStack.EMPTY);
        private BlockPos currentPos;
        private final int minX=tileX-range;
        private final int minZ=tileZ-range;
        private final int maxX=tileX+range;
        private final int maxZ=tileZ+range;
        private final int minY=tileY-range;
        private int currentDepth=tileY-1;
        private int currentX=minX;
        private int currentZ=minZ;
        private long destroyProgress =0;
        public Miner(){
            this.handler=new ItemStackHandler();
        }
        //挖矿代码
        private void getNextBlock(){
            BlockPos current=new BlockPos(currentX,currentDepth,currentZ);
          if(!checkNull(current))return;
          while (currentDepth>minY) {
              while (currentX < maxX) {
                  while (currentZ < maxZ) {
                      if (checkNull(new BlockPos(currentX, currentDepth, currentZ)))
                          continue;
                      currentPos = new BlockPos(currentX, currentDepth, currentZ);
                      currentZ++;
                  }
                  currentX++;
              }
              currentDepth--;
          }
        }
        private void damageBlock(){
            if(destroyProgress>=getDestroyTime())
            {
                destroyProgress=0;
                //消除所有裂痕并破坏掉
                //于BC的源码有变动
                world.sendBlockBreakProgress(getCurrentBlock().hashCode(),currentPos,-1);
                world.playEvent(2001,currentPos, Block.getStateId(getCurrentBlock()));

                List<ItemStack> itemStackList = getCurrentBlock().getBlock().getDrops(world,currentPos,getCurrentBlock(),getFortune());
                world.setBlockState(currentPos, Blocks.AIR.getDefaultState(),3);

                for (ItemStack stack : itemStackList)
                {
                        EntityItem entityItem = new EntityItem(world,currentX,currentDepth,currentZ,stack);
                        entityItem.attackEntityFrom(DamageSource.LAVA, -Integer.MAX_VALUE + 10);
                        world.spawnEntity(entityItem);


                }
            }else
            {
                //修改方块的裂痕进程 最后一个参数范围0-9
                world.sendBlockBreakProgress(getCurrentBlock().getBlock().hashCode(),currentPos,(int)((destroyProgress*getSpeed())/getDestroyTime()));
            }
        }
        private void floatItem(){
            AxisAlignedBB AABB = new AxisAlignedBB(minX,minY,minZ,maxX,minY,maxZ);
            for(EntityItem im:world.getEntitiesWithinAABB(EntityItem.class, AABB)){
                im.addVelocity(0,1,1);
            }

        }
        //更新
        @Override
        public void update()
        {
            //检测是否是工作模式
        if (!check())return;
        //获取下一个破坏的方块
            getNextBlock();
        //破坏方块
            damageBlock();
        //漂浮物品
            floatItem();
        }
        //util
        private IBlockState getCurrentBlock(){
            return world.getBlockState(currentPos);
        }
        private boolean check(){
           return (!this.world.isRemote&&isRunning());
        }
        private boolean checkNull(BlockPos pos){
            return world.getBlockState(pos)==Blocks.AIR.getDefaultState();
        }
        private long getDestroyTime(){

           return (long) Math.floor(16 * 1_000_000L * ((getHardness() + 1) * 2) * 1);
        }
        private float getHardness(){
        return  world.getBlockState(pos).getBlockHardness(world,currentPos);
        }

    }
}
