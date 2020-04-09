package com.pixelsky.cheese.entities.cheesechicken;

import com.pixelsky.cheese.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderCheeseChicken extends RenderLiving<EntityCheeseChicken> {
    private static final ResourceLocation CHEESE_COW_TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/cheese_chicken.png");

    public RenderCheeseChicken(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCheeseChicken entity) {
        return CHEESE_COW_TEXTURES;
    }
}