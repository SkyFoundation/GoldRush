package com.pixelsky.cheese.entities;

import com.google.common.collect.Maps;
import com.pixelsky.cheese.entities.cheesecow.EntityCheeseCow;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntitySpawnPlacementRegistry;

import java.util.Map;

public class CheeseSpawnPlacementRegistry extends EntitySpawnPlacementRegistry {
	private final Map < Class<?>, EntityLiving.SpawnPlacementType > ENTITY_PLACEMENTS = Maps. < Class<?>, EntityLiving.SpawnPlacementType > newHashMap();
	public CheeseSpawnPlacementRegistry() {
		ENTITY_PLACEMENTS.put(EntityCheeseCow.class, EntityLiving.SpawnPlacementType.ON_GROUND);
	}
	
}
