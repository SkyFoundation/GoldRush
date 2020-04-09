package com.pixelsky.cheese.entities;

import com.pixelsky.cheese.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTables extends LootTableList {
	public static final ResourceLocation ENTITIES_CHEESE_COW = register("cheese_cow");
	public static final ResourceLocation CHESTS_CHEESE = register("cheese_chest");
	public static final ResourceLocation ENTITY_CHEESE_MOUSE = register("cheese_mouse");

	public static final ResourceLocation ENTITY_CHEESE_CHICKEN = register("cheese_chicken");
    public static final ResourceLocation ENTITY_CHEESE_BOSS = register("cheese_boss");

    private static ResourceLocation register(String id) {
        return register(new ResourceLocation(Reference.MODID, id));
    }
}
