package com.pixelsky.goldrush.blocks.machine.tile;

import com.pixelsky.goldrush.Debug;
import com.pixelsky.goldrush.blocks.machine.MachineDetector;
import com.pixelsky.goldrush.entity.entityblockmarker.EntityBlockMarker;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.items.ItemStackHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Detector extends TileEntity implements ITickable {
    public final long defaultRefleshTime=1000;
    public ItemStackHandler handler;
    //储存用于发光的实体
    private ArrayList<EntityBlockMarker> blockMarkers=new ArrayList<>();
    //前7个槽用于放置升级
    private NonNullList<ItemStack> containerItems = NonNullList.<ItemStack>withSize(27, ItemStack.EMPTY);
    private long timeToReflesh;
    private long speed=6;
    private int range=8;
    private int fortune=1;
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
    public Detector(){

        this.handler=new ItemStackHandler();
    }

    //todo 后期设置为Container内设置的矿石
    private List<Block> getMineList(){
    return Arrays.asList(Blocks.COAL_ORE,Blocks.CHEST,Blocks.IRON_ORE,Blocks.DIAMOND_ORE,Blocks.GOLD_ORE);
    }
    //todo 这个会卡服的
    private ArrayList<BlockPos> getMineBlocks(){

        ArrayList<BlockPos> posList= new ArrayList<>();
        int center_y = MathHelper.floor(this.pos.getY());
        int center_x = MathHelper.floor(this.pos.getX());
        int center_z = MathHelper.floor(this.pos.getZ());
        for (int expand_X = - getRange(); expand_X <= +getRange(); ++expand_X) {
            for (int expand_z = - getRange(); expand_z <= +getRange(); ++expand_z) {
                for (int expend_y = - getRange(); expend_y <= + getRange(); ++expend_y) {
                    int result_x = center_x + expand_X;
                    int result_y = center_y + expend_y;
                    int result_z = center_z + expand_z;
                    BlockPos blockpos = new BlockPos(result_x, result_y, result_z);
                    IBlockState iblockstate = this.world.getBlockState(blockpos);
                    if(shouldMine(iblockstate.getBlock())){
                        posList.add(blockpos);
                    }
                }
            }
        }
        return  posList;
    }
    /*
    private HashMap<Block, ArrayList<BlockPos>> getMineBlocks(){
        HashMap<Block,List> blockPosMap=new HashMap<>();

        while (currentY<maxY){
            while (currentZ<maxZ){
                while (currentX<maxX){
                        BlockPos pos=new BlockPos(currentX,currentY,currentZ);
                        Block block=world.getBlockState(pos).getBlock();
                        if(!this.shouldMine(block))
                            continue;
                        ArrayList<BlockPos> posList;
                    {
                        if (blockPosMap.get(block) == null)
                            posList = new ArrayList<>();
                        else
                            posList = (ArrayList<BlockPos>) blockPosMap.get(block);
                    }
                    posList.add(pos);
                    currentX++;
                }
            currentZ++;
            }
            currentY++;
        }
    return getMineBlocks();
    }
    */

    //更新
    @Override
    public void update()
    {
        //检测是否是工作模式
        if (!check())return;
      ///  Debug.info("工作模式");
        if (!reflesh())return;

       // Debug.info("刷新与添加标记");

        for(BlockPos pos:getMineBlocks()){

        addMarker(pos);
        }
    }
    private void addMarker(BlockPos pos){
        EntityBlockMarker mark=new EntityBlockMarker(world,pos);
        this.blockMarkers.add(mark);

      //  Debug.info("添加标记于"+mark.getPosition()+"地址"+pos);
        world.spawnEntity(mark);
    }
    private boolean check(){
        return (!this.world.isRemote&&isRunning());
    }
    private boolean reflesh(){
        if(timeToReflesh<0){
            timeToReflesh=defaultRefleshTime;
            clearMarks();
            return true;
        }
        timeToReflesh=timeToReflesh-  getSpeed();
        return false;
    }
    private void clearMarks(){
        Iterator<EntityBlockMarker> iterator= this.blockMarkers.iterator();
        while (iterator.hasNext()){
            EntityBlockMarker entityBlockMarker =iterator.next();
            if(entityBlockMarker ==null|| entityBlockMarker.isDead)
                continue;
            entityBlockMarker.setDead();
        }
        this.blockMarkers.clear();
    }
    private boolean shouldMine(Block block){
        return getMineList().contains(block);
    }
    private boolean isRunning() {
        return world.isBlockPowered(getPos());
    }
}
