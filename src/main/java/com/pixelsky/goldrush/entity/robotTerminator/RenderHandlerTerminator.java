package com.pixelsky.goldrush.entity.robotTerminator;

import com.pixelsky.goldrush.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHandlerTerminator implements IRenderFactory {

    @Override
    public Render createRenderFor(RenderManager manager) {
        return new RenderDestoryer(manager);
    }

    class RenderDestoryer extends Render<RobotTerminator> {

        //todo 修改模型
        private final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entitys/robot_terminator.png");
        protected RenderDestoryer(RenderManager renderManager) {
            super(renderManager);
        }

        @Override
        public void doRender(RobotTerminator entity, double x, double y, double z, float entityYaw, float partialTicks) {
            bindEntityTexture(entity);
            GlStateManager.pushMatrix();
            GlStateManager.enableAlpha();
            GlStateManager.enableTexture2D();
            GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
            GlStateManager.enableCull();
            GlStateManager.translate((float)x, (float)y+2, (float)z );
            GlStateManager.scale(1, -1.0F, -1);
            new ModelTerminator().render(entity,0,0,0,entity.rotationYaw,entity.rotationPitch,0.1f);
            GlStateManager.popMatrix();
            super.doRender(entity, x, y, z, entityYaw, partialTicks);
        }

        @Override
        protected ResourceLocation getEntityTexture(RobotTerminator entity) {
            return TEXTURES;
        }
    }
}
