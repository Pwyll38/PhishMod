package net.phish.PhishMod1.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.phish.PhishMod1.PhishMod1;
import net.phish.PhishMod1.entity.ModEntities;
import net.phish.PhishMod1.entity.custom.MorayEntity;
import net.phish.PhishMod1.entity.custom.SnorkelEntity;
import net.phish.PhishMod1.entity.custom.TobEntity;

@Mod.EventBusSubscriber(modid = PhishMod1.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.TOB.get(), TobEntity.createAttributes().build());

        event.put(ModEntities.SNORKEL.get(), SnorkelEntity.createAttributes().build());

        event.put(ModEntities.MORAY.get(), MorayEntity.createAttributes().build());
        

        //TWO EVENT.PUT BREAKS THIS FOR SOME REASON 
    }
    
}