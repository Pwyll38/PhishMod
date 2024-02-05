package net.phish.PhishMod1.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.phish.PhishMod1.entity.custom.PhishBombProjectileEntity;
import net.minecraft.stats.Stats;


public class PhishToolItem extends Item {

    public PhishToolItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        pLevel.playSound((Player) null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.ALLAY_HURT,
                SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!pLevel.isClientSide) {
            pPlayer.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 150));
            
            pPlayer.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 150));
            
            pPlayer.addEffect(new MobEffectInstance(MobEffects.GLOWING, 150));
            
            pPlayer.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 150));
            
            pPlayer.addEffect(new MobEffectInstance(MobEffects.HUNGER, 150));

        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.shrink(1);
            itemstack.hurtAndBreak(1, pPlayer, playerC -> playerC.broadcastBreakEvent(playerC.getUsedItemHand()));
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }

}
