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
        //前7个槽用于放置升级
        for(int i=0;i<7;i++){

            this.addSlotToContainer(new SlotItemHandler(miner.handler, i, 9, 9*i));
        }
        //now i = 7;
        //本UI一共剩余的20个槽储存槽
        //4x5
        for(int i=0;i<4;i++){
            this.addSlotToContainer(new SlotItemHandler(miner.handler, i, 18, 9*i));
            for(int j=0;j<5;j++){

                this.addSlotToContainer(new SlotItemHandler(miner.handler, i, 18+j*9, 9*i));
            }
        }
        //玩家的背包
        int xPos = 8;
        int yPos = 127;
        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, xPos + x * 18, yPos + y * 18));
            }
        }

        for (int x = 0; x < 9; ++x) {
            this.addSlotToContainer(new Slot(playerInv, x, xPos + x * 18, yPos + 58));
        }


    }
    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

    private IInventory getPlayerInv(){
        return playerInv;
    }
}
