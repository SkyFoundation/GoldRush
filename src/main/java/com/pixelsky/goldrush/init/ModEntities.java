package com.pixelsky.goldrush.init;

import com.pixelsky.goldrush.GoldRush;
import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.blocks.machine.tile.Detector;
import com.pixelsky.goldrush.blocks.machine.tile.Miner;
import com.pixelsky.goldrush.entity.entityblockmarker.EntityBlockMarker;
import com.pixelsky.goldrush.entity.robotTerminator.RobotTerminator;
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
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":robot_terminator"), RobotTerminator.class, "RobotTerminator", ID++, GoldRush.Instance, 50, 1, true);

		GameRegistry.registerTileEntity(Miner.class, "MachineMiner");
		GameRegistry.registerTileEntity(Detector.class, "MachineDetector");
	}
	

}
