package net.phish.PhishMod1.item.custom;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

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

public class PhishSawItem extends Item {

    public PhishSawItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents,
            TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.phishmod.phish_saw"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockPos = pContext.getClickedPos();
        BlockState blockState = level.getBlockState(blockPos);

        if (isSawable(blockState)) {
            Set<BlockPos> sawableVein = getConnectedSawableBlocks(blockPos, level);
            for (BlockPos pos : sawableVein) {
                level.destroyBlock(pos, true);
                level.levelEvent(2001, pos, Block.getId(level.getBlockState(pos)));
            }

        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                playerC -> playerC.broadcastBreakEvent(playerC.getUsedItemHand()));
        return InteractionResult.SUCCESS;
    }

    private Set<BlockPos> getConnectedSawableBlocks(BlockPos startPos, Level level) {
        Set<BlockPos> visited = new HashSet<>();
        Set<BlockPos> toVisit = new HashSet<>();
        Set<BlockPos> result = new HashSet<>();

        toVisit.add(startPos);

        while (!toVisit.isEmpty()) {
            BlockPos currentPos = toVisit.iterator().next();
            toVisit.remove(currentPos);

            if (visited.contains(currentPos) || !isSawable(level.getBlockState(currentPos))) {
                continue;
            }

            visited.add(currentPos);
            result.add(currentPos);

            for (BlockPos neighbor : getAdjacentPositions(currentPos)) {
                if (!visited.contains(neighbor) && isSawable(level.getBlockState(neighbor))) {
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
    private boolean isSawable(BlockState state) {
        return state.is(ModTags.Blocks.SAWABLES);
    }

}
