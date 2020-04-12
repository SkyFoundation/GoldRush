package com.pixelsky.goldrush.entity.robotTerminator;

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
      //  private final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/robot_destoryer.png");
        private final ResourceLocation TEXTURES = new ResourceLocation( "textures/entity/bat.png");

        protected RenderDestoryer(RenderManager renderManager) {
            super(renderManager);
        }


        @Override
        protected ResourceLocation getEntityTexture(RobotTerminator entity) {
            return TEXTURES;
        }
    }
}
