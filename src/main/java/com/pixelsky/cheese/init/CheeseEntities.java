package com.pixelsky.cheese.init;

import com.pixelsky.cheese.DeGeweldigeMod;
import com.pixelsky.cheese.Reference;
import com.pixelsky.cheese.entities.EntityCheeseMountable;
import com.pixelsky.cheese.entities.cheesearrow.EntityCheeseArrow;
import com.pixelsky.cheese.entities.cheesearrow.RenderingHandlerCheeseArrow;
import com.pixelsky.cheese.entities.cheeseball.EntityCheeseBall;
import com.pixelsky.cheese.entities.cheeseball.RenderingHandlerCheeseBall;
import com.pixelsky.cheese.entities.cheeseboss.EntityCheeseBoss;
import com.pixelsky.cheese.entities.cheeseboss.RenderingHandlerCheeseBoss;
import com.pixelsky.cheese.entities.cheesecow.EntityCheeseCow;
import com.pixelsky.cheese.entities.cheesecow.RenderingHandlerCheeseCow;
import com.pixelsky.cheese.entities.tileentities.blocks.TileEntityCheeseBoard;
import com.pixelsky.cheese.entities.tileentities.blocks.TileEntityCheeseFurnace;
import com.pixelsky.cheese.entities.tileentities.blocks.TileEntityCheeseMirror;
import com.pixelsky.cheese.entities.tileentities.render.RenderCheeseBoard;
import com.pixelsky.cheese.entities.tileentities.render.RenderCheeseMirror;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CheeseEntities {
	private int ID = 0;
	
	public CheeseEntities() {
		register();
		addSpawn();
	}
	
	public void register() {

		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":cheese_cow"), EntityCheeseCow.class, "CheeseCow", ID++, DeGeweldigeMod.DGMInstance, 80, 1, true, 0x917B1B, 0x8E814E);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":cheese_arrow"), EntityCheeseArrow.class, "CheeseArrow", ID++, DeGeweldigeMod.DGMInstance, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":cheese_boss"), EntityCheeseBoss.class, "CheeseBoss", ID++, DeGeweldigeMod.DGMInstance, 250, 5, true, 0x9E881E, 0x685503);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":cheese_ball"), EntityCheeseBall.class, "Cheese", ID++, DeGeweldigeMod.DGMInstance, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":cheese_mountable"), EntityCheeseMountable.class, "CheeseMountable", ID++, DeGeweldigeMod.DGMInstance, 64, 1, true);

		GameRegistry.registerTileEntity(TileEntityCheeseFurnace.class, "CheeseFurnace");
		GameRegistry.registerTileEntity(TileEntityCheeseBoard.class, "CheeseBoard");
		GameRegistry.registerTileEntity(TileEntityCheeseMirror.class, "CheeseMirror");

	}
	
	public void addSpawn() {
		EntityRegistry.addSpawn(EntityCheeseCow.class, 8, 4, 4, EnumCreatureType.CREATURE, Biomes.PLAINS);
	}
}
