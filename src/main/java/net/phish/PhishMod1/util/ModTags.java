package net.phish.PhishMod1.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.phish.PhishMod1.PhishMod1;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> SAWABLES = tag("saw_sawables");// Creates a key for use in the code
        public static final TagKey<Block> DRILLABLES = tag("drillables");
        public static final TagKey<Block> NEEDS_PHISH_TOOL = tag("needs_phish_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(PhishMod1.MOD_ID, name));
        }

    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(PhishMod1.MOD_ID, name));
        }

    }

}
