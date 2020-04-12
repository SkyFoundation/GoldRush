package com.pixelsky.goldrush.blocks.machine;

import com.pixelsky.goldrush.Debug;
import com.pixelsky.goldrush.GoldRush;
import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.handler.GuiHandler;
import com.pixelsky.goldrush.init.CreativeTabs;
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
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.List;

public class MachineMiner extends BlockContainer implements IMachine{
    private final String name="machine_miner";
    private long speed=1;
    private int range=4;
    private int fortune=1;
    public MachineMiner() {
        super(Material.ROCK);
        setRegistryName(new ResourceLocation(Reference.MODID,name))
                .setTranslationKey(name)
                .setCreativeTab(CreativeTabs.GOLD_RUSH);
    }
    @Override
    public void handelUpgrade() {

    }
    //getters

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


    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            playerIn.openGui(GoldRush.Instance, GuiHandler.MACHINE_MINER, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new Miner();
    }



    //XXX 暂未测试
   public class Miner extends TileEntity implements ITickable {
       public ItemStackHandler handler;
       //前7个槽用于放置升级
        private NonNullList<ItemStack> containerItems = NonNullList.<ItemStack>withSize(27, ItemStack.EMPTY);
        private BlockPos currenMinePos;
        private long destroyProgress =0;
        public Miner(){
            this.handler=new ItemStackHandler();
        }

        //挖矿代码
        private void getNextBlock(){

            int center_y = MathHelper.floor(this.pos.getY());
            int center_x = MathHelper.floor(this.pos.getX());
            int center_z = MathHelper.floor(this.pos.getZ());
            if(currenMinePos==null){
                currenMinePos=new BlockPos(-getRange()+center_x,center_y-1,-getRange()+center_z);
            }
            Debug.info("获取下一个方块中");
            Debug.info("当前方块"+ currenMinePos);
            if(!checkNull(currenMinePos))
                return;
            for (int expand_X = -getRange(); expand_X <= +getRange(); ++expand_X) {
                for (int expand_z = -getRange(); expand_z <= +getRange(); ++expand_z) {
                    for (int expend_y = -1; expend_y >=-getRange(); --expend_y) {
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

                List<ItemStack> itemStackList = getCurrentBlock().getBlock().getDrops(world, currenMinePos,getCurrentBlock(),getFortune());
                world.setBlockState(currenMinePos, Blocks.AIR.getDefaultState(),3);

                for (ItemStack stack : itemStackList)
                {
                        EntityItem entityItem = new EntityItem(world, currenMinePos.getX(), currenMinePos.getY(), currenMinePos.getZ(),stack);
                        entityItem.attackEntityFrom(DamageSource.LAVA, -Integer.MAX_VALUE + 10);
                        world.spawnEntity(entityItem);
                }
            }else
            {
                destroyProgress=destroyProgress+1000000*getSpeed();
                //修改方块的裂痕进程 最后一个参数范围0-9
                world.sendBlockBreakProgress(getCurrentBlock().getBlock().hashCode(), currenMinePos,(int)((destroyProgress*9)/getDestroyTime()));
            }
        }
        private void floatItem(){
            AxisAlignedBB AABB = new AxisAlignedBB(pos.getX()-getRange(),pos.getY()-getRange(),pos.getZ()-getRange(),pos.getX()+range,pos.getY(),pos.getZ()+range);
            for(EntityItem im:world.getEntitiesWithinAABB(EntityItem.class, AABB)){
                im.addVelocity(Math.random()*2,Math.random()*2,Math.random()*2);
            }

        }
        //更新
        @Override
        public void update()
        {
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
}
