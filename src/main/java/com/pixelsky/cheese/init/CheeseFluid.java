package com.pixelsky.cheese.init;

import com.pixelsky.cheese.Reference;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class CheeseFluid {
    public static final Fluid CHEESE_FLUID = new Fluid("cheese_fluid", new ResourceLocation(Reference.MODID,"liquid/cheese_still"), new ResourceLocation(Reference.MODID,"liquid/cheese_flow"), new ResourceLocation(Reference.MODID,"liquid/cheese_overlay")).setDensity(1).setViscosity(2);
    public CheeseFluid(){
        reg();
    }

    private void reg() {
        FluidRegistry.registerFluid(CHEESE_FLUID);
        FluidRegistry.addBucketForFluid(CHEESE_FLUID);
    }
}
