package com.pixelsky.goldrush.init;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class CheeseDimensions {

	public static final int CHEESE_DIMENSION_ID = DimensionManager.getNextFreeDimId();
	public static DimensionType CHEESE_DIMENSION;
	
	public CheeseDimensions() {
		init();
		register();
	}
	
	

	public static void init() {
	//	CHEESE_DIMENSION = DimensionType.register("CHEESE", "_cheese", CHEESE_DIMENSION_ID, WorldProviderCheese.class, false);
	}



	public static void register() {
		DimensionManager.registerDimension(CHEESE_DIMENSION_ID, CHEESE_DIMENSION);
	}

}
