package com.pixelsky.goldrush.blocks.machine;

import com.pixelsky.goldrush.GoldRush;
import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.blocks.machine.tile.Detector;
import com.pixelsky.goldrush.handler.GuiHandler;
import com.pixelsky.goldrush.init.CreativeTabs;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MachineDetector extends BlockContainer implements IMachine{
    private final String name="machine_detector";
    private long speed=5;
    private int range=8;
    private int fortune=1;

    public MachineDetector() {
        super(Material.ROCK);
        setRegistryName(new ResourceLocation(Reference.MODID,name))
                .setTranslationKey(name)
                .setCreativeTab(CreativeTabs.GOLD_RUSH);
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
            playerIn.openGui(GoldRush.Instance, GuiHandler.MACHINE_DETECTOR, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new Detector(this);
    }

    @Override
    public void handelUpgrade() {

    }

}
