package com.pixelsky.goldrush.entity.robotblockdestroyer;

import com.pixelsky.goldrush.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBat;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHandlerDestoryer implements IRenderFactory {

    @Override
    public Render createRenderFor(RenderManager manager) {
        return new RenderDestoryer(manager,new ModelDestoryer(),0.5f);
    }

    class RenderDestoryer extends RenderLiving<RobotDestroyer> {

        //todo 修改模型
      private final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/robot_destoryer.png");

        public RenderDestoryer(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
            super(rendermanagerIn, modelbaseIn, shadowsizeIn);
        }

        @Override
        protected ResourceLocation getEntityTexture(RobotDestroyer entity) {
            return TEXTURES;
        }
    }
}
