package com.pixelsky.cheese.handler;

import com.pixelsky.cheese.handler.packet.CheeseBankMessageHandler;
import com.pixelsky.cheese.handler.packet.CheeseFillMessageHandler;
import com.pixelsky.cheese.handler.packet.CheeseMessageHandler;
import com.pixelsky.cheese.packet.CheeseBankMessage;
import com.pixelsky.cheese.packet.CheeseFillMessage;
import com.pixelsky.cheese.packet.CheeseMessage;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class CheesePacketHandler {
	
	public CheesePacketHandler() {
		registerPackets();
	}
	
	public static SimpleNetworkWrapper INSTANCE;
	public static int ID = 0;
	
	public void registerPackets() {
		INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("dgmChannel");
		INSTANCE.registerMessage(CheeseMessageHandler.class, CheeseMessage.class, ID++, Side.SERVER);
		INSTANCE.registerMessage(CheeseFillMessageHandler.class, CheeseFillMessage.class, ID++, Side.CLIENT);
		INSTANCE.registerMessage(CheeseBankMessageHandler.class, CheeseBankMessage.class, ID++, Side.SERVER);
	}
}
