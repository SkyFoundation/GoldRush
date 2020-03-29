package com.pixelsky.cheese.gui.button;

import com.pixelsky.cheese.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiButtonWithImage extends GuiButton {
	private final ResourceLocation BUTTON_TEXTURES = new ResourceLocation(
			Reference.MODID + ":textures/gui/button_images.png");
	private int textureOffsetX;
	private int textureOffsetY;
	private int type = -1;

	public GuiButtonWithImage(int buttonID, int xPos, int yPos, int xOff,int yOff, int type) {
		super(buttonID, xPos, yPos, 20, 20, "");
		textureOffsetX = xOff;
		textureOffsetY = yOff;
		this.type = type;
	}

	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		if (this.visible) {
			mc.getTextureManager().bindTexture(BUTTON_TEXTURES);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			boolean flag = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width
					&& mouseY < this.y + this.height;
			int i = 0;

			if (flag) {
				i += this.height;
			}

			this.drawTexturedModalRect(this.x, this.y, textureOffsetX, i + textureOffsetY, 20,20);
			if (this.type == 0) {
				this.drawCenteredString(Minecraft.getMinecraft().fontRenderer, "Sell", this.x + 10,
						this.y - 10, 0xffffff);
			} else if (this.type == 1) {
				this.drawCenteredString(Minecraft.getMinecraft().fontRenderer, "Buy", this.x + 10,
						this.y - 10, 0xffffff);
			}
		}
	}
}