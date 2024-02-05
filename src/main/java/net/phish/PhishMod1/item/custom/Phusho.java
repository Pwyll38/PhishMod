package net.phish.PhishMod1.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class Phusho extends Item {

    public Phusho(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand){
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        
        if(!pLevel.isClientSide()){
            pLevel.playSound((Player) null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.FISH_SWIM,
            SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));

            pLevel.levelEvent(2001, pPlayer.getOnPos(), Block.getId(pLevel.getBlockState(pPlayer.getOnPos())));

        }

        pPlayer.setDeltaMovement(pPlayer.getDeltaMovement().add(0.0D, 1.5D, 0.0D));
        pPlayer.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 30));


        pPlayer.getItemInHand(pHand).hurtAndBreak(1, pPlayer,
                playerC -> playerC.broadcastBreakEvent(playerC.getUsedItemHand()));

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());

    }


    
}
