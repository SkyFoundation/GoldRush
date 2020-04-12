package com.pixelsky.goldrush.init;

import com.pixelsky.goldrush.fluids.FluidOil;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluid {
 public static  FluidOil FLUID_OIL=new FluidOil();
 //   public static  Fluid CHEESE_HOT =new HotCheese();
    public ModFluid(){
        reg();
    }

    private void reg() {
        FluidRegistry.registerFluid(FLUID_OIL);

    }
}
