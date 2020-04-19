package com.pixelsky.goldrush.entity.robotblockdestroyer;

import com.pixelsky.goldrush.entity.IUpgradeHandler;
import com.pixelsky.goldrush.items.upgrades.IUpgrade;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class RobotDestroyer extends EntityTameable implements IUpgradeHandler {
    private int range_mine =2;
    private int speed_mine =1;
    private long cooldown_mine =100;
    private EntityPlayer summoner;
    private List<IUpgrade> upgrades;
    private int upgrade_limit=5;

    private RobotDestroyer(World world){
        super(world);
        setSize(1,1);
        upgrades=new ArrayList<>();
    }

    public RobotDestroyer(World worldIn, EntityPlayer summoner) {
        this(worldIn);
        this.summoner=summoner;
        setOwnerId(summoner.getUniqueID());

    }
    @Override
    public boolean attackEntityAsMob(Entity entityIn)
    {
        this.world.setEntityState(this, (byte)4);
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(7 + this.rand.nextInt(15)));

        if (flag)
        {
            entityIn.motionY += 0.4000000059604645D;
            this.applyEnchantments(this, entityIn);
        }
         return flag;
    }
    @Override
    protected void entityInit() {
        super.entityInit();
    }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(2,new EntityAIFollowOwner(this,1,3,8));
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.5D, true));
        this.tasks.addTask(1, new EntityAIPanic(this, 2));
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {

        super.processInteract(player, hand);
        if(world.isRemote)
            return false;
        if (hand!=EnumHand.MAIN_HAND)
            return false;
       ItemStack itemStack= player.getHeldItem(hand);
        addUpgrade(itemStack);
        if(player.isSneaking()){
           player.startRiding(this);
        }
        return false;
    }

    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
        if(!checkVaild(world))
            return;
        handleUpgrade();
        if(!checkCooldown())
            return;
        destroyBlocks();
    }
    private boolean addUpgrade(ItemStack stack){
        if(!(stack.getItem() instanceof IUpgrade))
            return false;
        if(this.upgrades.size()>upgrade_limit)
            return false;
        this.upgrades.add((IUpgrade) stack.getItem());
        stack.shrink(1);
        return true;
    }
    private boolean checkVaild(World w){
     //   Debug.info("当前世界是否"+w.isRemote);
        return !w.isRemote;
    }
    private boolean checkCooldown(){
        if(cooldown_mine <0){
            cooldown_mine =100;
        //    Debug.info("处理冷却中"+cooldown_mine);
            return true;
        }
        cooldown_mine = cooldown_mine - speed_mine;
        return false;
    }

    private void destroyBlocks() {
       // Debug.info("开始破坏方块");
        // Debug.info("blockbreakconunter--");
        if ( ! net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this)) {
        return;
        }
            int center_y = MathHelper.floor(this.posY);
            int center_x = MathHelper.floor(this.posX);
            int center_z = MathHelper.floor(this.posZ);
            for (int expand_X = -range_mine; expand_X <= +range_mine; ++expand_X) {
                for (int expand_z = -range_mine; expand_z <= +range_mine; ++expand_z) {
                    for (int expend_y = 0; expend_y <= 4; ++expend_y) {
                        int result_x = center_x + expand_X;
                        int result_y = center_y + expend_y;
                        int result_z = center_z + expand_z;
                        BlockPos blockpos = new BlockPos(result_x, result_y, result_z);
                        IBlockState iblockstate = this.world.getBlockState(blockpos);
                        Block block = iblockstate.getBlock();
                        if (!block.isAir(iblockstate, this.world, blockpos) && block.canEntityDestroy(iblockstate, world, blockpos, summoner)) {
                             if(this.world.destroyBlock(blockpos, true)){
                                 this.world.playEvent(summoner, 1022, new BlockPos(this), 0);
                             }
                        }
                    }
                }
            }



    }

    @Override
    public void handleUpgrade() {

    }
}
