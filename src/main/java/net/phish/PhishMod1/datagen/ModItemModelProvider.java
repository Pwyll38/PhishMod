package net.phish.PhishMod1.datagen;

import net.phish.PhishMod1.PhishMod1;
import net.phish.PhishMod1.block.ModBlocks;
import net.phish.PhishMod1.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItemModelProvider extends ItemModelProvider{

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper){
        super(output,PhishMod1.MOD_ID, existingFileHelper);
    }


    

    @Override
    protected void registerModels(){
        simpleItem(ModItems.PHISH);
        simpleItem(ModItems.RAW_PHISH);
        simpleItem(ModItems.NETHER_PHISH);
        simpleItem(ModItems.END_PHISH);
        simpleItem(ModItems.PHISH_ON_FIRE);
        simpleItem(ModItems.DIAMOND_RADAR);
        simpleItem(ModItems.PHISH_BOMB);
        simpleItem(ModItems.PHISH_SAW);
        simpleItem(ModItems.PHISH_DRILL);
        simpleItem(ModItems.PHISH_SHUSHI);
        simpleItem(ModItems.PHISH_ON_FIRE);
        simpleItem(ModItems.PHISH_SHUSHI_ON_FIRE);
        simpleItem(ModItems.PHISH_HELMET);
        simpleItem(ModItems.PHISH_CHESTPLATE);
        simpleItem(ModItems.PHISH_LEGGINGS);
        simpleItem(ModItems.PHISH_BOOTS);


        simpleBlockItem(ModBlocks.PHISH_BLOCK_DOOR);

        fenceItem(ModBlocks.PHISH_BLOCK_FENCE, ModBlocks.PHISH_BLOCK);
        buttonItem(ModBlocks.PHISH_BLOCK_BUTTON, ModBlocks.PHISH_BLOCK);
        wallItem(ModBlocks.PHISH_BLOCK_WALL, ModBlocks.PHISH_BLOCK);

        evenSimplerBlockItem(ModBlocks.PHISH_BLOCK_SLAB);
        evenSimplerBlockItem(ModBlocks.PHISH_BLOCK_STAIRS);
        evenSimplerBlockItem(ModBlocks.PHISH_BLOCK_FENCE_GATE);
        evenSimplerBlockItem(ModBlocks.PHISH_BLOCK_PRESSURE_PLATE);

        handheldItem(ModItems.PHISH_AXE);
        handheldItem(ModItems.PHISH_HOE);
        handheldItem(ModItems.PHISH_PICKAXE);
        handheldItem(ModItems.PHISH_SHOVEL);
        handheldItem(ModItems.PHISH_SWORD);
        handheldItem(ModItems.PHISH_TOOL);

        trapdoorItem(ModBlocks.PHISH_BLOCK_TRAPDOOR);

        withExistingParent(ModItems.TOB_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.SNORKEL_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.MORAY_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return  withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(PhishMod1.MOD_ID,"item/"+item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PhishMod1.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(PhishMod1.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(PhishMod1.MOD_ID,"item/" + item.getId().getPath()));
    }





    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(PhishMod1.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(PhishMod1.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(PhishMod1.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

}
