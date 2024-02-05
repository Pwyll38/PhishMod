package net.phish.PhishMod1.item;

import java.util.List;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.phish.PhishMod1.PhishMod1;
import net.phish.PhishMod1.util.ModTags;

public class ModToolTiers {
    public static final Tier PHISH = TierSortingRegistry.registerTier(
        new ForgeTier(5, 1500, 6.0F, 4, 35,
            ModTags.Blocks.NEEDS_PHISH_TOOL,
            ()-> Ingredient.of(ModItems.PHISH.get())),
            new ResourceLocation(PhishMod1.MOD_ID, "phish"), 
            List.of(Tiers.NETHERITE), //List of tiers that are lesser then the new tier
            List.of() //List of tiers that are greater then it
    );
}
