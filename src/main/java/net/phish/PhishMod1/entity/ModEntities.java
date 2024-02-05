package net.phish.PhishMod1.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.phish.PhishMod1.PhishMod1;
import net.phish.PhishMod1.entity.custom.MorayEntity;
import net.phish.PhishMod1.entity.custom.PhishBombProjectileEntity;
import net.phish.PhishMod1.entity.custom.SnorkelEntity;
import net.phish.PhishMod1.entity.custom.TobEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PhishMod1.MOD_ID);

    public static final RegistryObject<EntityType<PhishBombProjectileEntity>> PHISH_BOMB_ENTITY = 
        ENTITY_TYPES.register("phish_bomb_entity", ()-> EntityType.Builder.<PhishBombProjectileEntity>of(PhishBombProjectileEntity::new, MobCategory.MISC)
            .sized(0.5f, 0.5f).build("phish_bomb_entity"));

    public static final RegistryObject<EntityType<TobEntity>> TOB = 
        ENTITY_TYPES.register("tob", ()-> EntityType.Builder.of(TobEntity::new, MobCategory.CREATURE)
            .sized(0.5f, 0.5f).build("tob_entity"));

    public static final RegistryObject<EntityType<SnorkelEntity>> SNORKEL = 
            ENTITY_TYPES.register("snorkel", ()-> EntityType.Builder.of(SnorkelEntity::new, MobCategory.CREATURE)
                .sized(0.5f, 0.5f).build("snorkel_entity"));

    public static final RegistryObject<EntityType<MorayEntity>> MORAY = 
                ENTITY_TYPES.register("moray", ()-> EntityType.Builder.of(MorayEntity::new, MobCategory.CREATURE)
                    .sized(1.5f, 0.5f).build("moray_entity"));

    
    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
    
}
