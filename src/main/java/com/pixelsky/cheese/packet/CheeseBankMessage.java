package com.pixelsky.cheese.packet;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class CheeseBankMessage implements IMessage {

	public CheeseBankMessage() {
	}

	private int value;

	public CheeseBankMessage(int value) {
		this.value = value;
	}
	public void toBytes(ByteBuf buf) {
		buf.writeInt(value);
	}

	public void fromBytes(ByteBuf buf) {
		value = buf.readInt();
	}

	public int getValue() {
		return value;
	}
}