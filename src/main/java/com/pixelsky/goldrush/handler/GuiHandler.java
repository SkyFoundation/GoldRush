package com.pixelsky.goldrush.handler;

import com.pixelsky.goldrush.Debug;
import com.pixelsky.goldrush.blocks.machine.tile.Miner;
import com.pixelsky.goldrush.containers.ContainerMiner;
import com.pixelsky.goldrush.gui.GuiMachineMiner;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {
public static final int MACHINE_MINER =0;
public static final int MACHINE_DETECTOR =1;
//public static final int ROBOT_DESTROYER =2;
//public static final int ITEM_DETECTOR=3;
    @Nullable
    @Override
    public Container getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        switch (id){
            case MACHINE_MINER:
                return new ContainerMiner(player.inventory, (Miner) world.getTileEntity(new BlockPos(x,y,z)));

            case MACHINE_DETECTOR:
              //  return new ContainerMiner(player.inventory, (MachineMiner.Miner) world.getTileEntity(new BlockPos(x,y,z)));
        }


        Debug.info("Error Server UI Id "+id);
        return null;
    }

    @Nullable
    @Override
    public GuiContainer getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {

        switch (id){
            case MACHINE_MINER:
                return new GuiMachineMiner(player.inventory,(Miner) world.getTileEntity(new BlockPos(x,y,z)));
        }
        Debug.info("Error Client UI Id "+id);
        return null;
    }
}
