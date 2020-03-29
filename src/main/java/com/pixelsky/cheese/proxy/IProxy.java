package com.pixelsky.cheese.proxy;

import com.pixelsky.cheese.entities.CheeseSpawnPlacementRegistry;
import com.pixelsky.cheese.handler.CheesePacketHandler;
import com.pixelsky.cheese.init.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

interface IProxy {
    void preInit(FMLPreInitializationEvent event);
     void init(FMLInitializationEvent event) ;
     void postInit(FMLPostInitializationEvent event) ;
    void serverStart(FMLServerStartingEvent event) ;
}
