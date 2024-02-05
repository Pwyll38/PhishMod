package net.phish.PhishMod1;

import com.mojang.logging.LogUtils;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.phish.PhishMod1.block.ModBlocks;
import net.phish.PhishMod1.entity.ModEntities;
import net.phish.PhishMod1.entity.client.MorayRenderer;
import net.phish.PhishMod1.entity.client.SnorkelRenderer;
import net.phish.PhishMod1.entity.client.TobRenderer;
import net.phish.PhishMod1.item.ModCreativeModeTabs;
import net.phish.PhishMod1.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;

import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PhishMod1.MOD_ID)
public class PhishMod1 {
    public static final String MOD_ID = "phishmod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public PhishMod1() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        



        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {


    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.PHISH_BOMB_ENTITY.get(), ThrownItemRenderer::new);

            EntityRenderers.register(ModEntities.TOB.get(), TobRenderer::new);
            EntityRenderers.register(ModEntities.SNORKEL.get(), SnorkelRenderer::new);
            EntityRenderers.register(ModEntities.MORAY.get(), MorayRenderer::new);
        }
    }
}