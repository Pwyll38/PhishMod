package net.phish.PhishMod1.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.phish.PhishMod1.util.ModTags;
import net.minecraft.world.level.Level;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

public class PhishDrillItem extends Item {

     @Override
   public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
    pTooltipComponents.add(Component.translatable("tooltip.phishmod.phish_drill"));
    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
   }
   

    public PhishDrillItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockPos = pContext.getClickedPos();
        BlockState blockState = level.getBlockState(blockPos);

        if (isDrillable(blockState)) {
            Set<BlockPos> drillableVein = getConnectedDrillableBlocks(blockPos, level);
            for (BlockPos pos : drillableVein) {
                level.destroyBlock(pos, true);
                level.levelEvent(2001, pos, Block.getId(level.getBlockState(pos)));
            }

        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                playerC -> playerC.broadcastBreakEvent(playerC.getUsedItemHand()));
        return InteractionResult.SUCCESS;
    }

    private Set<BlockPos> getConnectedDrillableBlocks(BlockPos startPos, Level level) {
        Set<BlockPos> visited = new HashSet<>();
        Set<BlockPos> toVisit = new HashSet<>();
        Set<BlockPos> result = new HashSet<>();

        toVisit.add(startPos);

        while (!toVisit.isEmpty()) {
            BlockPos currentPos = toVisit.iterator().next();
            toVisit.remove(currentPos);

            if (visited.contains(currentPos) || !isDrillable(level.getBlockState(currentPos))) {
                continue;
            }

            visited.add(currentPos);
            result.add(currentPos);

            for (BlockPos neighbor : getAdjacentPositions(currentPos)) {
                if (!visited.contains(neighbor) && isDrillable(level.getBlockState(neighbor))) {
                    toVisit.add(neighbor);
                }
            }
        }
        return result;
    }

    private Set<BlockPos> getAdjacentPositions(BlockPos pos) {
        return Set.of(
                pos.east(), pos.west(), pos.above(), pos.below(), pos.north(), pos.south());
    }

    private boolean isDrillable(BlockState state) {
        return state.is(ModTags.Blocks.DRILLABLES);
    }

}
