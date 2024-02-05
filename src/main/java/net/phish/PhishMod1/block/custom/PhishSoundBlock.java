package net.phish.PhishMod1.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class PhishSoundBlock extends Block {

    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public PhishSoundBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
            BlockHitResult pHit) {
        pLevel.playSound(pPlayer, pPos, SoundEvents.FISH_SWIM, SoundSource.BLOCKS);
        return InteractionResult.SUCCESS;
    }

    @Override //Powered
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos,
            boolean pIsMoving) {
        if (!pLevel.isClientSide && (pLevel.hasNeighborSignal(pPos))) {
            playSoundToNearbyPlayers(pLevel, pPos, SoundEvents.FISH_SWIM, SoundSource.BLOCKS);
        }
    }

    private void playSoundToNearbyPlayers(Level level, BlockPos pos, net.minecraft.sounds.SoundEvent soundEvent,
            SoundSource soundCategory) {
        double distance = 16.0;

        level.players().forEach(player -> {
            if (player.distanceToSqr(pos.getX(), pos.getY(), pos.getZ()) < distance * distance) {
                player.playNotifySound(soundEvent, soundCategory, 1.0f, 1.0f);
            }
        });
    }

}
