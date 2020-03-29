package com.pixelsky.cheese.handler.packet;

import com.pixelsky.cheese.packet.CheeseMessage;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CheeseMessageHandler implements IMessageHandler<CheeseMessage, IMessage> {
	@Override
    public IMessage onMessage(final CheeseMessage message, final MessageContext ctx) {
        final EntityPlayerMP player = ctx.getServerHandler().player;
        IThreadListener mainThread = (WorldServer) player.world;
        mainThread.addScheduledTask(new Runnable() {
            @Override
            public void run() {
            	player.world.spawnEntity(new EntityItem(player.world, player.posX, player.posY, player.posZ, new ItemStack(Items.COOKIE, message.getAmount())));
                if(!message.isCreative()) {
                	player.addExperience(-message.getAmount() * 3);
                }
            }
        });
        return null;
    }
}