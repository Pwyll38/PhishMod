package net.phish.PhishMod1.item.custom;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class PhishDiamondRadarItem extends Item{
    
    public PhishDiamondRadarItem (Properties pProperties){
        super(pProperties);
    }

    @Override
   public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
    pTooltipComponents.add(Component.translatable("tooltip.phishmod.diamond_radar"));
    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
   }
   
    @Override
    public InteractionResult useOn(UseOnContext pContext){

        if(!pContext.getLevel().isClientSide()){
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();

            boolean foundBlock = false;

            for(int i = 0; i<=positionClicked.getY()+64;i++){
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));
                
                if(isValuableBlock(state)){
                    outputDiamondCoordinates(positionClicked.below(i), player, state.getBlock());
                    foundBlock = true;
                    break;
                }

            }
            if(!foundBlock){
                player.sendSystemMessage(Component.literal("No luck"));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
            player-> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
        
    }

    private void outputDiamondCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage((Component.literal("Found! At ("+ blockPos.getX()+ ","+blockPos.getY()+","+ blockPos.getZ()+")")));

    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(Blocks.DIAMOND_ORE);
    }


}
