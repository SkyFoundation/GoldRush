package com.pixelsky.goldrush.fluids;

import com.pixelsky.goldrush.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidOil extends Fluid {
    public FluidOil( ) {
        super("fluid_oil", new ResourceLocation(Reference.MODID, "fluids/oil_still"),  new ResourceLocation(Reference.MODID, "fluids/oil_flow"));
        setRarity(EnumRarity.COMMON);
        setLuminosity(0);
        setDensity(2000);
        setViscosity(1000);
        setTemperature(120);
        setFillSound(SoundEvents.ITEM_BUCKET_FILL);
        FluidRegistry.addBucketForFluid(this);
    }
}
