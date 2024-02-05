package net.phish.PhishMod1.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.phish.PhishMod1.PhishMod1;
import net.phish.PhishMod1.block.ModBlocks;


public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PhishMod1.MOD_ID); 

    public static final RegistryObject<CreativeModeTab> PHISH_TAB = CREATIVE_MODE_TABS.register("phish_tab", 
    ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.PHISH.get()))
    .title(Component.translatable("creativetab.phish_tab"))
    .displayItems((pParameters, pOutput) -> {
        pOutput.accept(ModItems.PHISH.get());
        pOutput.accept(ModItems.RAW_PHISH.get());
        pOutput.accept(ModItems.END_PHISH.get());
        pOutput.accept(ModItems.NETHER_PHISH.get());
        pOutput.accept(ModItems.PHISH_ON_FIRE.get());
        pOutput.accept(ModItems.DIAMOND_RADAR.get());
        pOutput.accept(ModItems.PHISH_BOMB.get());
        pOutput.accept(ModItems.PHISH_SAW.get());
        pOutput.accept(ModItems.PHISH_DRILL.get());
        pOutput.accept(ModItems.PHISH_TOOL.get());

        pOutput.accept(ModItems.PHISH_PICKAXE.get());
        pOutput.accept(ModItems.PHISH_SHOVEL.get());
        pOutput.accept(ModItems.PHISH_SWORD.get());
        pOutput.accept(ModItems.PHISH_HOE.get());
        pOutput.accept(ModItems.PHISH_AXE.get());

        pOutput.accept(ModItems.PHISH_SHUSHI.get());
        pOutput.accept(ModItems.PHISH_SHUSHI_ON_FIRE.get());
        pOutput.accept(ModItems.PREMIUM_FLAKES.get());

        pOutput.accept(ModBlocks.PHISH_BLOCK.get());
        pOutput.accept(ModBlocks.RAW_PHISH_BLOCK.get());
        pOutput.accept(ModBlocks.END_PHISH_ORE.get());
        pOutput.accept(ModBlocks.NETHER_PHISH_ORE.get());
        pOutput.accept(ModBlocks.PHISH_SOUND_BLOCK.get());

        
        pOutput.accept(ModBlocks.PHISH_BLOCK_BUTTON.get());
        pOutput.accept(ModBlocks.PHISH_BLOCK_DOOR.get());
        pOutput.accept(ModBlocks.PHISH_BLOCK_FENCE.get());
        pOutput.accept(ModBlocks.PHISH_BLOCK_FENCE_GATE.get());
        pOutput.accept(ModBlocks.PHISH_BLOCK_PRESSURE_PLATE.get());
        pOutput.accept(ModBlocks.PHISH_BLOCK_SLAB.get());
        pOutput.accept(ModBlocks.PHISH_BLOCK_STAIRS.get());
        pOutput.accept(ModBlocks.PHISH_BLOCK_TRAPDOOR.get());
        pOutput.accept(ModBlocks.PHISH_BLOCK_WALL.get());

        pOutput.accept(ModItems.CREATURO.get());
        pOutput.accept(ModItems.PHUSHO.get());

        pOutput.accept(ModItems.PHISH_HELMET.get());
        pOutput.accept(ModItems.PHISH_CHESTPLATE.get());
        pOutput.accept(ModItems.PHISH_LEGGINGS.get());
        pOutput.accept(ModItems.PHISH_BOOTS.get());

        pOutput.accept(ModItems.TOB_SPAWN_EGG.get());
        pOutput.accept(ModItems.SNORKEL_SPAWN_EGG.get());
        pOutput.accept(ModItems.MORAY_SPAWN_EGG.get());
        
        
    })
    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }}
