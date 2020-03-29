package com.pixelsky.cheese.handler.packet;

import com.pixelsky.cheese.capability.cheese.CheeseProvider;
import com.pixelsky.cheese.capability.cheese.ICheese;
import com.pixelsky.cheese.packet.CheeseFillMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CheeseFillMessageHandler implements IMessageHandler<CheeseFillMessage, IMessage> {
	@Override
    public IMessage onMessage(final CheeseFillMessage message, final MessageContext ctx) {
		final EntityPlayerSP player = Minecraft.getMinecraft().player;
        IThreadListener mainThread = Minecraft.getMinecraft().getIntegratedServer();
        mainThread.addScheduledTask(new Runnable() {
            @Override
            public void run() {
                ICheese cheese = player.getCapability(CheeseProvider.CHEESE_CAP, null);
                cheese.set(20);
            }
        });
        return null;
    }
}