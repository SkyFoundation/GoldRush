package com.pixelsky.goldrush.blocks.machine;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.init.CreativeTabs;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

public abstract class AbstractMachine extends BlockContainer {

    protected AbstractMachine(Material materialIn) {
        super(materialIn);
        this.setRegistryName(Reference.MODID,getName())
                .setTranslationKey(getName())
                .setCreativeTab(CreativeTabs.GOLD_RUSH);
    }
    abstract String getName();

}
