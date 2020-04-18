package com.pixelsky.goldrush.blocks.machine;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.blocks.machine.tile.Detector;
import com.pixelsky.goldrush.init.CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MachineDetector extends Block implements IMachine, ITileEntityProvider
{
    private final String name="machine_detector";

    public MachineDetector() {
        super(Material.ROCK);
        setRegistryName(new ResourceLocation(Reference.MODID,name))
                .setTranslationKey(name)
                .setCreativeTab(CreativeTabs.GOLD_RUSH);
    }

    //getters



    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
        //    playerIn.openGui(GoldRush.Instance, GuiHandler.MACHINE_DETECTOR, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

   // @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {

        return new Detector();
    }

    @Override
    public void handelUpgrade() {

    }

}
