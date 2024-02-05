package net.phish.PhishMod1.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.phish.PhishMod1.PhishMod1;
import net.phish.PhishMod1.entity.client.ModModelsLayers;
import net.phish.PhishMod1.entity.client.MorayModel;
import net.phish.PhishMod1.entity.client.SnorkelModel;
import net.phish.PhishMod1.entity.client.TobModel;


@Mod.EventBusSubscriber(modid = PhishMod1.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent 
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelsLayers.TOB_LAYER, TobModel::createBodyLayer);

        event.registerLayerDefinition(ModModelsLayers.SNORKEL_LAYER, SnorkelModel::createBodyLayer);

        event.registerLayerDefinition(ModModelsLayers.MORAY_LAYER, MorayModel::createBodyLayer);

        
    }
}
