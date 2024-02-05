package net.phish.PhishMod1.item.custom;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;

public class PhishOnFireItem extends Item {

   public PhishOnFireItem(Properties pProperties) {
      super(pProperties);
   }

   @Override
   public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents,
         TooltipFlag pIsAdvanced) {
      pTooltipComponents.add(Component.translatable("tooltip.phishmod.phish_on_fire"));
      super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
   }

   @Override
   public InteractionResult useOn(UseOnContext pContext) {
      Player player = pContext.getPlayer();
      Level level = pContext.getLevel();
      BlockPos blockpos = pContext.getClickedPos();
      BlockState blockstate = level.getBlockState(blockpos);
      if (!CampfireBlock.canLight(blockstate) && !CandleBlock.canLight(blockstate)
            && !CandleCakeBlock.canLight(blockstate)) {
         BlockPos blockpos1 = blockpos.relative(pContext.getClickedFace());
         if (BaseFireBlock.canBePlacedAt(level, blockpos1, pContext.getHorizontalDirection())) {
            level.playSound(player, blockpos1, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F,
                  level.getRandom().nextFloat() * 0.4F + 0.8F);
            BlockState blockstate1 = BaseFireBlock.getState(level, blockpos1);
            level.setBlock(blockpos1, blockstate1, 11);
            level.gameEvent(player, GameEvent.BLOCK_PLACE, blockpos);
            ItemStack itemstack = pContext.getItemInHand();
            if (player instanceof ServerPlayer) {
               CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer) player, blockpos1, itemstack);
               itemstack.hurtAndBreak(1, player, (p_41300_) -> {
                  p_41300_.broadcastBreakEvent(pContext.getHand());
               });
            }

            return InteractionResult.sidedSuccess(level.isClientSide());
         } else {
            return InteractionResult.FAIL;
         }
      } else {
         level.playSound(player, blockpos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F,
               level.getRandom().nextFloat() * 0.4F + 0.8F);
         level.setBlock(blockpos, blockstate.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
         level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockpos);
         if (player != null) {
            pContext.getItemInHand().hurtAndBreak(1, player, (p_41303_) -> {
               p_41303_.broadcastBreakEvent(pContext.getHand());
            });
         }

         return InteractionResult.sidedSuccess(level.isClientSide());
      }
   }
}
