package com.pixelsky.goldrush.proxy;

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
