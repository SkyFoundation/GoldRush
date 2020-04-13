package com.pixelsky.goldrush.containers;

import com.pixelsky.goldrush.blocks.machine.tile.Miner;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerMiner extends Container {
    private final Miner miner;
    private final IInventory playerInv;
    //FIXME 我都不确定这个可以工作
    public ContainerMiner(InventoryPlayer playerInventory, Miner miner)
    {
        this.miner=miner;
        this.playerInv=playerInventory;

    }
    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

    private IInventory getPlayerInv(){
        return playerInv;
    }
}
