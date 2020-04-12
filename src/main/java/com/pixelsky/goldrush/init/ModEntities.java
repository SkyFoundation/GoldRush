package com.pixelsky.goldrush.init;

import com.pixelsky.goldrush.GoldRush;
import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.blocks.machine.MachineDetector;
import com.pixelsky.goldrush.blocks.machine.MachineMiner;
import com.pixelsky.goldrush.entity.entityblockmarket.EntityBlockMarker;
import com.pixelsky.goldrush.entity.robotblockdestroyer.RobotDestroyer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModEntities {
	private int ID = 0;

	
	public ModEntities() {
		register();
	}
	
	public void register() {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":robot_destroyer"), RobotDestroyer.class, "RobotDestroyer", ID++, GoldRush.Instance, 50, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":block_marker"), EntityBlockMarker.class, "BlockMarker", ID++, GoldRush.Instance, 50, 1, false);

		GameRegistry.registerTileEntity(MachineMiner.Miner.class, "MachineMiner");

		GameRegistry.registerTileEntity(MachineDetector.Detector.class, "MachineDetector");
	}
	

}
