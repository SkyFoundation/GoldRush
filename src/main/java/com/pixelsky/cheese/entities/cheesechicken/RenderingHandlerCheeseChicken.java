package com.pixelsky.cheese.entities.cheesechicken;

import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderingHandlerCheeseChicken  implements IRenderFactory {
    @Override
    public Render createRenderFor(RenderManager manager) {
        return new RenderCheeseChicken(manager, new ModelChicken(), 0.5F);
    }
}
