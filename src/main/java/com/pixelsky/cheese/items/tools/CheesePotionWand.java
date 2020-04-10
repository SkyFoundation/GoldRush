package com.pixelsky.cheese.items.tools;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class CheesePotionWand extends Item {
	
	private Potion potion;
	private String desc;
	
	public CheesePotionWand(Potion pot, String effect) {
		this.setMaxStackSize(1);
		this.setMaxDamage(52);
		potion = pot;
	//	desc = effect;
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if(!worldIn.isRemote) {
			List<EntityLivingBase> entities = worldIn.getEntitiesWithinAABB(EntityLivingBase.class, playerIn.getEntityBoundingBox().expand(2, 2, 2));
			for (int i = 0; i < entities.size(); i++) {
				EntityLivingBase entity = entities.get(i);
				if(potion != null && entity != playerIn)
				entity.addPotionEffect(new PotionEffect(potion, 200, 2));
				if(potion == null)
				entity.setFire(10);
				if(!playerIn.isCreative() && entity != playerIn) {
					ItemStack stack = playerIn.getHeldItem(handIn);
					Random random = new Random();
					stack.damageItem(random.nextInt(2), playerIn);
				}
			}
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{

		if(desc != null)

			tooltip.add(TextFormatting.GOLD + desc + TextFormatting.RESET);
	}


}
