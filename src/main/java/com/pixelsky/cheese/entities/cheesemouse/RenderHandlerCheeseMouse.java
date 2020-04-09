package com.pixelsky.cheese.entities.cheesemouse;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHandlerCheeseMouse implements IRenderFactory{
    @Override
    public Render createRenderFor(RenderManager manager) {
        return new RenderCheeseMouse(manager,new ModelCheeseMouse(),0.5f);
    }
}

