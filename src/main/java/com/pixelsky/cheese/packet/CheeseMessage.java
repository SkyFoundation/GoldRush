package com.pixelsky.cheese.packet;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class CheeseMessage implements IMessage {
	
	public CheeseMessage(){
	}
	
	private boolean creative;
	private int amount;
	
	public CheeseMessage(boolean isCreative, int cookieAmount) {
		this.amount = cookieAmount;
		this.creative = isCreative;
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeBoolean(creative);
		buf.writeInt(amount);
	}
	
	@Override 
	public void fromBytes(ByteBuf buf) {
		creative = buf.readBoolean();
		amount = buf.readInt();
	}
	
	public int getAmount() {
		return amount;
	}
	
	public boolean isCreative() {
		return creative;
	}
}
