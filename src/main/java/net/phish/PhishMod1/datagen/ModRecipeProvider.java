package net.phish.PhishMod1.datagen;

import java.util.List;
import java.util.function.Consumer;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.phish.PhishMod1.PhishMod1;
import net.phish.PhishMod1.block.ModBlocks;
import net.phish.PhishMod1.item.ModItems;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> PHISH_ORE_SMELTABLES = List.of(ModBlocks.END_PHISH_ORE.get(),
            ModBlocks.NETHER_PHISH_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, PHISH_ORE_SMELTABLES, RecipeCategory.MISC, ModItems.PHISH.get(), 0.25f, 150,
                "phish");
        oreSmelting(pWriter, PHISH_ORE_SMELTABLES, RecipeCategory.MISC, ModItems.PHISH.get(), 0.25f, 250,
                "phish");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PHISH_BLOCK.get())
                .pattern("III")
                .pattern("IPI")
                .pattern("III")
                .define('P', ModItems.PHISH.get())
                .define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(ModItems.PHISH.get()), has(ModItems.PHISH.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PHISH.get(), 3)
                .requires(ModItems.NETHER_PHISH.get())
                .unlockedBy(getHasName(ModItems.NETHER_PHISH.get()), has(ModItems.NETHER_PHISH.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NETHER_PHISH.get(), 3)
                .requires(ModItems.END_PHISH.get())
                .unlockedBy(getHasName(ModItems.END_PHISH.get()), has(ModItems.END_PHISH.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PHISH_SOUND_BLOCK.get())
                .pattern("PPP")
                .pattern("PNP")
                .pattern("PPP")
                .define('P', ModItems.PHISH.get())
                .define('N', Items.NOTE_BLOCK)
                .unlockedBy(getHasName(ModItems.PHISH.get()), has(ModItems.PHISH.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PHISH_SHUSHI.get())
                .pattern("DDD")
                .pattern("DPD")
                .pattern("DDD")
                .define('P', ModItems.PHISH.get())
                .define('D', Items.DRIED_KELP)
                .unlockedBy(getHasName(ModItems.PHISH.get()), has(ModItems.PHISH.get()))
                .save(pWriter);

        // TO-DO: RECIPE DE FORNALHA SHUSHI ON FIRE
        // simpleCookingRecipe(pWriter, "Furnace", RecipeCategory.MISC, 50,
        // ModItems.PHISH_SHUSHI, ModItems.PHISH_SHUSHI_ON_FIRE, 0.15f);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PHISH_SAW.get())
                .pattern("PPI")
                .pattern("PPI")
                .pattern("IDI")
                .define('P', ModItems.PHISH.get())
                .define('D', Items.DIAMOND)
                .define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(ModItems.PHISH.get()), has(ModItems.PHISH.get()))
                .save(pWriter);

        // TO-DO: RECIPE DE PHISH PELO RAW PHISH, PHISH ON FIRE,
        // simpleCookingRecipe(pWriter, "Furnace", RecipeCategory.MISC, 50,
        // ModItems.PHISH_SHUSHI, ModItems.PHISH_SHUSHI_ON_FIRE, 0.15f);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PHISH_DRILL.get())
                .pattern("PPP")
                .pattern("IDI")
                .pattern("IDI")
                .define('P', ModItems.PHISH.get())
                .define('D', Items.DIAMOND)
                .define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(ModItems.PHISH.get()), has(ModItems.PHISH.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PHISH_BOMB.get())
                .pattern("GGG")
                .pattern("GPG")
                .pattern("GGG")
                .define('P', ModItems.PHISH.get())
                .define('G', Items.GUNPOWDER)
                .unlockedBy(getHasName(ModItems.PHISH.get()), has(ModItems.PHISH.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_RADAR.get())
                .pattern("PDP")
                .pattern("PCP")
                .pattern("PPP")
                .define('P', ModItems.PHISH.get())
                .define('D', Items.DIAMOND)
                .define('C', Items.COMPASS)
                .unlockedBy(getHasName(ModItems.PHISH.get()), has(ModItems.PHISH.get()))
                .save(pWriter);

        // Decoracoes

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PHISH_BLOCK_DOOR.get())
                .pattern("BB ")
                .pattern("BB ")
                .pattern("BB ")
                .define('B', ModBlocks.PHISH_BLOCK.get())
                .unlockedBy(getHasName(ModItems.PHISH.get()), has(ModBlocks.PHISH_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PHISH_BLOCK_TRAPDOOR.get())
                .pattern("   ")
                .pattern("BB ")
                .pattern("BB ")
                .define('B', ModBlocks.PHISH_BLOCK.get())
                .unlockedBy(getHasName(ModItems.PHISH.get()), has(ModBlocks.PHISH_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PHISH_BLOCK_WALL.get())
                .pattern("   ")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModBlocks.PHISH_BLOCK.get())
                .unlockedBy(getHasName(ModItems.PHISH.get()), has(ModBlocks.PHISH_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PHISH_BLOCK_PRESSURE_PLATE.get())
                .pattern("   ")
                .pattern("   ")
                .pattern("BB ")
                .define('B', ModBlocks.PHISH_BLOCK.get())
                .unlockedBy(getHasName(ModItems.PHISH.get()), has(ModBlocks.PHISH_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PHISH_BLOCK_FENCE.get())
                .pattern("   ")
                .pattern("BSB")
                .pattern("BSB")
                .define('B', ModBlocks.PHISH_BLOCK.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.PHISH.get()), has(ModBlocks.PHISH_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.PHISH_BLOCK_BUTTON.get(), 1)
                .requires(ModBlocks.PHISH_BLOCK.get())
                .unlockedBy(getHasName(ModItems.PHISH.get()), has(ModBlocks.PHISH_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PHISH_BLOCK_SLAB.get())
                .pattern("   ")
                .pattern("   ")
                .pattern("BBB")
                .define('B', ModBlocks.PHISH_BLOCK.get())
                .unlockedBy(getHasName(ModItems.PHISH.get()), has(ModBlocks.PHISH_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PHISH_BLOCK_STAIRS.get())
                .pattern("B  ")
                .pattern("BB ")
                .pattern("BBB")
                .define('B', ModBlocks.PHISH_BLOCK.get())
                .unlockedBy(getHasName(ModItems.PHISH.get()), has(ModBlocks.PHISH_BLOCK.get()))
                .save(pWriter);



        // Ferramentas normais

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PHISH_AXE.get())
                .pattern("PP ")
                .pattern("PS ")
                .pattern(" S ")
                .define('P', ModItems.PHISH.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.PHISH.get()), has(ModItems.PHISH.get()))
                .save(pWriter);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PHISH_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('P', ModItems.PHISH.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.PHISH.get()), has(ModItems.PHISH.get()))
                .save(pWriter);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PHISH_SWORD.get())
                .pattern(" P ")
                .pattern(" P ")
                .pattern(" S ")
                .define('P', ModItems.PHISH.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.PHISH.get()), has(ModItems.PHISH.get()))
                .save(pWriter);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PHISH_SHOVEL.get())
                .pattern(" P ")
                .pattern(" P ")
                .pattern(" S ")
                .define('P', ModItems.PHISH.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.PHISH.get()), has(ModItems.PHISH.get()))
                .save(pWriter);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PHISH_HOE.get())
                .pattern("PP ")
                .pattern(" S ")
                .pattern(" S ")
                .define('P', ModItems.PHISH.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.PHISH.get()), has(ModItems.PHISH.get()))
                .save(pWriter);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PHUSHO.get())
                .pattern("PPP")
                .pattern("WWW")
                .pattern("WWW")
                .define('P', ModItems.PHISH.get())
                .define('W', Items.WHITE_WOOL)
                .unlockedBy(getHasName(ModItems.PHISH.get()), has(ModItems.PHISH.get()))
                .save(pWriter);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PREMIUM_FLAKES.get())
                .pattern(" S ")
                .pattern(" B ")
                .pattern("   ")
                .define('S', ModItems.PHISH_SHUSHI.get())
                .define('B', Items.GLASS_BOTTLE)
                .unlockedBy(getHasName(ModItems.PHISH_SHUSHI.get()), has(ModItems.PHISH_SHUSHI.get()))
                .save(pWriter);

                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PHISH_TOOL.get())
                .pattern(" P ")
                .pattern("ISI")
                .pattern("ISI")
                .define('P', ModItems.PHISH.get())
                .define('S', Items.STICK)
                .define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(ModItems.PHISH_SHUSHI.get()), has(ModItems.PHISH_SHUSHI.get()))
                .save(pWriter);

                

    }

    // Copied from RecipeProvider

    protected static void oreSmelting(Consumer<FinishedRecipe> pWriter, List<ItemLike> pIngredients, RecipeCategory pCategory,
            ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pWriter, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience,
                pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pWriter, List<ItemLike> pIngredients, RecipeCategory pCategory,
            ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pWriter, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience,
                pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  PhishMod1.MOD_ID+ ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

}
