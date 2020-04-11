package com.pixelsky.goldrush.gui;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.blocks.machine.MachineMiner;
import com.pixelsky.goldrush.containers.ContainerMiner;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GUIMachineMiner extends GuiContainer {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, "textures/gui/container/machine_miner.png");
    private final InventoryPlayer playerInventory;
    private final MachineMiner.Miner tileMiner;

    public GUIMachineMiner( InventoryPlayer playerInventory, MachineMiner.Miner tileFurnace) {
        super(new ContainerMiner(playerInventory,tileFurnace));
        this.playerInventory = playerInventory;
        this.tileMiner = tileFurnace;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

    }
}
