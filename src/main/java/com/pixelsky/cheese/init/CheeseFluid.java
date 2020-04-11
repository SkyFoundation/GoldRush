package com.pixelsky.cheese.init;

import com.pixelsky.cheese.fluid.HotCheese;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class CheeseFluid {
    public static  Fluid CHEESE_HOT =new HotCheese();
    public CheeseFluid(){
        reg();
    }

    private void reg() {
        FluidRegistry.registerFluid(CHEESE_HOT);

    }
}
