package com.pixelsky.goldrush.entity.entityblockmarker;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHandlerMarker implements IRenderFactory {

    @Override
    public Render createRenderFor(RenderManager manager) {
        return new RenderMarker(manager);
    }
    class RenderMarker extends Render<EntityBlockMarker> {
        protected RenderMarker(RenderManager renderManager) {
            super(renderManager);

        }

        @Override
        protected ResourceLocation getEntityTexture(EntityBlockMarker entity) {
            return null;
        }
    }
}
