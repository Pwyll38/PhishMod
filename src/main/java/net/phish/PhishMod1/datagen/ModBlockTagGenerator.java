package net.phish.PhishMod1.datagen;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nullable;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.phish.PhishMod1.PhishMod1;
import net.phish.PhishMod1.block.ModBlocks;
import net.phish.PhishMod1.util.ModTags;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PhishMod1.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.DRILLABLES)
                .add(ModBlocks.END_PHISH_ORE.get()).addTags(Tags.Blocks.ORES)
                .add(ModBlocks.NETHER_PHISH_ORE.get()).addTags(Tags.Blocks.ORES);

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.END_PHISH_ORE.get(), ModBlocks.NETHER_PHISH_ORE.get(), ModBlocks.PHISH_BLOCK.get());

        this.tag(ModTags.Blocks.SAWABLES).addTags(BlockTags.LOGS);

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.PHISH_BLOCK_FENCE.get());

        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.PHISH_BLOCK_FENCE_GATE.get());

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.PHISH_BLOCK_WALL.get());
    }
}
