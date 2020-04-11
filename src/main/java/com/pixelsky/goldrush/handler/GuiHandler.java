package com.pixelsky.goldrush.handler;

import com.pixelsky.goldrush.Debug;
import com.pixelsky.goldrush.blocks.machine.MachineMiner;
import com.pixelsky.goldrush.containers.ContainerMiner;
import com.pixelsky.goldrush.gui.GUIMachineMiner;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {
public static final int Miner=0;
    @Nullable
    @Override
    public Container getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        switch (id){
            case 0:
                return new ContainerMiner(player.inventory, (MachineMiner.Miner) world.getTileEntity(new BlockPos(x,y,z)));
        }


        Debug.info("Error Server UI Id "+id);
        return null;
    }

    @Nullable
    @Override
    public GuiContainer getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {

        switch (id){
            case 0:
                return new GUIMachineMiner(player.inventory,(MachineMiner.Miner) world.getTileEntity(new BlockPos(x,y,z)));
        }
        Debug.info("Error Client UI Id "+id);
        return null;
    }
}
