package net.phish.PhishMod1.datagen.loot;

import java.util.Set;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.phish.PhishMod1.block.ModBlocks;
import net.phish.PhishMod1.item.ModItems;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(),FeatureFlags.REGISTRY.allFlags());
    }


    @Override
    protected void generate() {

        this.dropSelf(ModBlocks.PHISH_BLOCK.get());// The blocks that drop themselves
        this.dropSelf(ModBlocks.PHISH_SOUND_BLOCK.get());

        this.dropSelf(ModBlocks.PHISH_BLOCK_BUTTON.get());
        this.dropSelf(ModBlocks.PHISH_BLOCK_FENCE.get());
        this.dropSelf(ModBlocks.PHISH_BLOCK_FENCE_GATE.get());
        this.dropSelf(ModBlocks.PHISH_BLOCK_WALL.get());
        this.dropSelf(ModBlocks.PHISH_BLOCK_STAIRS.get());
        this.dropSelf(ModBlocks.PHISH_BLOCK_TRAPDOOR.get());
        this.dropSelf(ModBlocks.PHISH_BLOCK_PRESSURE_PLATE.get());

        this.add(ModBlocks.PHISH_BLOCK_SLAB.get(),
            block-> createSlabItemTable(ModBlocks.PHISH_BLOCK_SLAB.get())); 
        this.add(ModBlocks.PHISH_BLOCK_DOOR.get(),
            block-> createDoorTable(ModBlocks.PHISH_BLOCK_DOOR.get())); 



        // For ores
        this.add(ModBlocks.NETHER_PHISH_ORE.get(),
                block -> createLapisLikeOreDrops(block, ModItems.PHISH.get()));
        this.add(ModBlocks.END_PHISH_ORE.get(),
                block -> createLapisLikeOreDrops(block, ModItems.PHISH.get()));
        this.add(ModBlocks.RAW_PHISH_BLOCK.get(),
                block -> createLapisLikeOreDrops(block, ModItems.PHISH.get()));

    }


    //Copied from createLapisOreDrops to change params
    protected LootTable.Builder createLapisLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0F, 9.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;

    }

}
