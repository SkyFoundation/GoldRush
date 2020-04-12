package com.pixelsky.goldrush.blocks;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.init.CreativeTabs;
import com.pixelsky.goldrush.init.ModFluid;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidClassic;

public class FluidOilBlock extends BlockFluidClassic {
    private final String  name="fluid_oil";
    public FluidOilBlock() {
        super(ModFluid.FLUID_OIL, Material.WATER);

        setRegistryName(new ResourceLocation(Reference.MODID,name))
                .setTranslationKey(name)
                .setCreativeTab(CreativeTabs.GOLD_RUSH);
    }
}

