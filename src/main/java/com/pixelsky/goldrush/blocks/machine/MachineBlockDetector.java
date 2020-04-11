package com.pixelsky.goldrush.blocks.machine;

import com.pixelsky.goldrush.GoldRush;
import com.pixelsky.goldrush.entity.EntityBlockMark;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.*;

public class MachineBlockDetector  extends BlockContainer implements IMachine{
    private final String name="machine_blockdetector";
    private boolean isRunning;
    private long speed=5;
    private int range=1;
    private int fortune=1;

    public MachineBlockDetector() {
        super(Material.ROCK);
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

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            playerIn.openGui(GoldRush.Instance, GuiHandler.Detector, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }

    @Override
    public void handelUpgrade() {

    }

    //XXX 暂未测试
    public class Detector extends TileEntity implements ITickable {
        public final long defaultRefleshTime=1000;
        public ItemStackHandler handler;
        public final int tileX=this.getPos().getX();
        public final int tileY=this.getPos().getY();
        public final int tileZ=this.getPos().getZ();
        //储存用于发光的实体
        private ArrayList<EntityBlockMark> blockMarkers=new ArrayList<>();
        //前7个槽用于放置升级
        private NonNullList<ItemStack> containerItems = NonNullList.<ItemStack>withSize(27, ItemStack.EMPTY);
        private final int minX=tileX-range;
        private final int minZ=tileZ-range;
        private final int maxX=tileX+range;
        private final int maxZ=tileZ+range;
        private final int minY=tileY-range;
        private final int maxY=tileY+range;
        private int currentY=minY;
        private int currentX=minX;
        private int currentZ=minZ;
        private long timeToReflesh;

        public Detector(){
            this.handler=new ItemStackHandler();

        }
        //todo 后期设置为Container内设置的矿石
        private List<Block> getMineList(){
        return Arrays.asList(Blocks.COAL_ORE,Blocks.CHEST,Blocks.IRON_ORE);
        }
        //todo 这个会卡服的
        private ArrayList<BlockPos> getMineBlocks(){

            ArrayList<BlockPos> posList= new ArrayList<>();

            while (currentY<maxY){
                while (currentZ<maxZ){
                    while (currentX<maxX){
                        BlockPos pos=new BlockPos(currentX,currentY,currentZ);
                        Block block=world.getBlockState(pos).getBlock();
                        if(!this.shouldMine(block))
                            continue;
                        posList.add(pos);
                        currentX++;
                    }
                    currentZ++;
                }
                currentY++;
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
            if (!reflesh())return;
            for(BlockPos pos:getMineBlocks()){
            addMarker(pos);
            }
        }
        private void addMarker(BlockPos pos){
            EntityBlockMark mark=new EntityBlockMark(world,pos);
            this.blockMarkers.add(mark);
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
            timeToReflesh=timeToReflesh-speed;
            return false;
        }
        private void clearMarks(){
            Iterator<EntityBlockMark> iterator= this.blockMarkers.iterator();
            while (iterator.hasNext()){
                EntityBlockMark entityBlockMark=iterator.next();
                if(entityBlockMark==null||entityBlockMark.isDead)
                    continue;
                entityBlockMark.setDead();
            }
            this.blockMarkers.clear();
        }
        private boolean shouldMine(Block block){
            return getMineList().contains(block);
        }

    }
}
