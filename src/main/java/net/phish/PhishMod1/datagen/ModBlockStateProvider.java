package net.phish.PhishMod1.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.phish.PhishMod1.PhishMod1;
import net.phish.PhishMod1.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider{

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PhishMod1.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels(){
        
        blockWithItem(ModBlocks.END_PHISH_ORE);
        blockWithItem(ModBlocks.NETHER_PHISH_ORE);
        blockWithItem(ModBlocks.PHISH_BLOCK);
        blockWithItem(ModBlocks.PHISH_SOUND_BLOCK);
        blockWithItem(ModBlocks.RAW_PHISH_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.PHISH_BLOCK_STAIRS.get()), blockTexture(ModBlocks.PHISH_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.PHISH_BLOCK_SLAB.get()), blockTexture(ModBlocks.PHISH_BLOCK.get()), blockTexture(ModBlocks.PHISH_BLOCK.get()));
        buttonBlock(((ButtonBlock) ModBlocks.PHISH_BLOCK_BUTTON.get()), blockTexture(ModBlocks.PHISH_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.PHISH_BLOCK_PRESSURE_PLATE.get()), blockTexture(ModBlocks.PHISH_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.PHISH_BLOCK_WALL.get()), blockTexture(ModBlocks.PHISH_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.PHISH_BLOCK_FENCE_GATE.get()), blockTexture(ModBlocks.PHISH_BLOCK.get()));
        fenceBlock(((FenceBlock) ModBlocks.PHISH_BLOCK_FENCE.get()), blockTexture(ModBlocks.PHISH_BLOCK.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.PHISH_BLOCK_DOOR.get()), modLoc("block/phish_block_door_bottom"), modLoc("block/phish_block_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.PHISH_BLOCK_TRAPDOOR.get()), modLoc("block/phish_block_trapdoor"), true, "cutout");        
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get())); //Makes the block and item from Block   
    }
    

}
