package com.pixelsky.goldrush.items.robots;

import com.pixelsky.goldrush.Reference;
import com.pixelsky.goldrush.entity.robotTerminator.RobotTerminator;
import com.pixelsky.goldrush.init.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemRobotTerminator extends Item {
    private final String name="robot_terminator";
    public ItemRobotTerminator(){
        super();
        setRegistryName(new ResourceLocation(Reference.MODID,name))
                .setTranslationKey(name)
                .setCreativeTab(CreativeTabs.GOLD_RUSH);
        this.setMaxDamage(3);
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ActionResult pass= new ActionResult<>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));

        if(handIn!=EnumHand.MAIN_HAND)
            return pass;

        if(worldIn.isRemote)
            return pass;

        RobotTerminator destroyer=new RobotTerminator(worldIn);
        destroyer.setPosition(playerIn.posX,playerIn.posY,playerIn.posZ);
        worldIn.spawnEntity(destroyer);
        playerIn.getHeldItem(handIn).damageItem(1,playerIn);
        return   new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));


    }
}
