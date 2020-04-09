package com.pixelsky.cheese.entities.cheesemouse;

import com.pixelsky.cheese.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderCheeseMouse extends RenderLiving<EntityCheeseMouse> {
private static final ResourceLocation CHEESE_COW_TEXTURES = new ResourceLocation(Reference.MODID ,"textures/entity/cheese_mouse.png");

public RenderCheeseMouse(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
        }


        @Nullable
        @Override
        protected ResourceLocation getEntityTexture(EntityCheeseMouse entity) {
                return CHEESE_COW_TEXTURES;
        }
}