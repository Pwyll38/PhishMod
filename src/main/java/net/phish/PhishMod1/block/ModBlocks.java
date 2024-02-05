package net.phish.PhishMod1.block;

import java.util.function.Supplier;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.phish.PhishMod1.PhishMod1;
import net.phish.PhishMod1.block.custom.PhishSoundBlock;
import net.phish.PhishMod1.item.ModItems;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = 
        DeferredRegister.create(ForgeRegistries.BLOCKS, PhishMod1.MOD_ID);



    public static final RegistryObject<Block> PHISH_BLOCK = registerBlock("phish_block", 
    ()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CORAL_BLOCK).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RAW_PHISH_BLOCK = registerBlock("raw_phish_block", 
    ()->new Block(BlockBehaviour.Properties.copy(Blocks.SAND).sound(SoundType.SCULK).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> NETHER_PHISH_ORE = registerBlock("nether_phish_ore", 
    ()->new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.SCULK)
    .requiresCorrectToolForDrops().strength(3f),UniformInt.of(3,6)));

    public static final RegistryObject<Block> END_PHISH_ORE = registerBlock("end_phish_ore", 
    ()->new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.SCULK)
    .requiresCorrectToolForDrops().strength(4f),UniformInt.of(3,6)));

    public static final RegistryObject<Block> PHISH_SOUND_BLOCK = registerBlock("phish_sound_block", 
    ()->new PhishSoundBlock(BlockBehaviour.Properties.copy(Blocks.NOTE_BLOCK)));



    public static final RegistryObject<Block> PHISH_BLOCK_STAIRS = registerBlock("phish_block_stairs", 
    ()->new StairBlock(()-> ModBlocks.PHISH_BLOCK.get().defaultBlockState() ,
        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CORAL_BLOCK).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> PHISH_BLOCK_SLAB = registerBlock("phish_block_slab", 
    ()->new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CORAL_BLOCK).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> PHISH_BLOCK_BUTTON = registerBlock("phish_block_button", 
    ()->new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.CORAL_BLOCK).requiresCorrectToolForDrops(), BlockSetType.IRON, 10, true));

    public static final RegistryObject<Block> PHISH_BLOCK_PRESSURE_PLATE = registerBlock("phish_block_pressure_plate", 
    ()->new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
        BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CORAL_BLOCK).requiresCorrectToolForDrops(), BlockSetType.IRON));

    public static final RegistryObject<Block> PHISH_BLOCK_FENCE = registerBlock("phish_block_fence", 
    ()->new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CORAL_BLOCK).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> PHISH_BLOCK_FENCE_GATE = registerBlock("phish_block_fence_gate", 
    ()->new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CORAL_BLOCK).requiresCorrectToolForDrops(), SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));

    public static final RegistryObject<Block> PHISH_BLOCK_WALL = registerBlock("phish_block_wall", 
    ()->new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CORAL_BLOCK).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> PHISH_BLOCK_DOOR = registerBlock("phish_block_door", 
    ()->new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CORAL_BLOCK).requiresCorrectToolForDrops().noOcclusion(), BlockSetType.BIRCH));

    public static final RegistryObject<Block> PHISH_BLOCK_TRAPDOOR = registerBlock("phish_block_trapdoor", 
    ()->new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CORAL_BLOCK).requiresCorrectToolForDrops().noOcclusion(), BlockSetType.BIRCH));



    
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
    
}
