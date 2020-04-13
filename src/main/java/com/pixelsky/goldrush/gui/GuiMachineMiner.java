package com.pixelsky.goldrush.gui;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.blocks.machine.tile.Miner;
import com.pixelsky.goldrush.containers.ContainerMiner;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiMachineMiner extends GuiContainer {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, "textures/gui/container/machine_miner.png");
    private final InventoryPlayer playerInventory;
    private final Miner tileMiner;

    public GuiMachineMiner(InventoryPlayer playerInventory, Miner tileFurnace) {
        super(new ContainerMiner(playerInventory,tileFurnace));
        this.playerInventory = playerInventory;
        this.tileMiner = tileFurnace;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURE);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize,  18 + 17);
        this.drawTexturedModalRect(i, j +  18 + 17, 0, 126, this.xSize, 96);
    }
}
