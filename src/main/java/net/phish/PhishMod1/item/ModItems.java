package net.phish.PhishMod1.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.phish.PhishMod1.PhishMod1;
import net.phish.PhishMod1.entity.ModEntities;
import net.phish.PhishMod1.item.custom.FuelItem;
import net.phish.PhishMod1.item.custom.PhishBombItem;
import net.phish.PhishMod1.item.custom.PhishDiamondRadarItem;
import net.phish.PhishMod1.item.custom.PhishDrillItem;
import net.phish.PhishMod1.item.custom.PhishOnFireItem;
import net.phish.PhishMod1.item.custom.PhishSawItem;
import net.phish.PhishMod1.item.custom.PhishToolItem;
import net.phish.PhishMod1.item.custom.Phusho;

public class ModItems {
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
                        PhishMod1.MOD_ID);

        public static final RegistryObject<Item> PHISH = ITEMS.register("phish",
                        () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> RAW_PHISH = ITEMS.register("raw_phish",
                        () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> NETHER_PHISH = ITEMS.register("nether_phish",
                        () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> END_PHISH = ITEMS.register("end_phish",
                        () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> PHISH_ON_FIRE = ITEMS.register("phish_on_fire",
                        () -> new PhishOnFireItem(new Item.Properties().durability(1)));

        public static final RegistryObject<Item> DIAMOND_RADAR = ITEMS.register("diamond_radar",
                        () -> new PhishDiamondRadarItem(new Item.Properties().durability(200))); // For custom items,
                                                                                                 // use their
                                                                                                 // constructors

        public static final RegistryObject<Item> PHISH_BOMB = ITEMS.register("phish_bomb",
                        () -> new PhishBombItem(new Item.Properties().stacksTo(16)));

        public static final RegistryObject<Item> PHISH_SAW = ITEMS.register("phish_saw",
                        () -> new PhishSawItem(new Item.Properties().durability(1000)));

        public static final RegistryObject<Item> PHISH_DRILL = ITEMS.register("phish_drill",
                        () -> new PhishDrillItem(new Item.Properties().durability(1000)));

        public static final RegistryObject<Item> PHISH_SHUSHI = ITEMS.register("phish_shushi",
                        () -> new Item(new Item.Properties().food(ModFoods.SHUSHI)));

        public static final RegistryObject<Item> PHISH_SHUSHI_ON_FIRE = ITEMS.register("phish_shushi_on_fire",
                        () -> new FuelItem(new Item.Properties(), 600));

        public static final RegistryObject<Item> CREATURO = ITEMS.register("creaturo",
                        () -> new Item(new Item.Properties().food(ModFoods.CREATURO)));

        public static final RegistryObject<Item> PHISH_SWORD = ITEMS.register("phish_sword",
                        () -> new SwordItem(ModToolTiers.PHISH, 5, 2, new Item.Properties()));

        public static final RegistryObject<Item> PHISH_PICKAXE = ITEMS.register("phish_pickaxe",
                        () -> new PickaxeItem(ModToolTiers.PHISH, 2, 3, new Item.Properties()));

        public static final RegistryObject<Item> PHISH_AXE = ITEMS.register("phish_axe",
                        () -> new AxeItem(ModToolTiers.PHISH, 7, 1, new Item.Properties()));

        public static final RegistryObject<Item> PHISH_SHOVEL = ITEMS.register("phish_shovel",
                        () -> new ShovelItem(ModToolTiers.PHISH, 1, 2, new Item.Properties()));

        public static final RegistryObject<Item> PHISH_HOE = ITEMS.register("phish_hoe",
                        () -> new HoeItem(ModToolTiers.PHISH, 1, 2, new Item.Properties()));

        public static final RegistryObject<Item> PHISH_HELMET = ITEMS.register("phish_helmet",
                        () -> new ArmorItem(ModArmorMaterials.PHISH, ArmorItem.Type.HELMET, new Item.Properties()));

        public static final RegistryObject<Item> PHISH_CHESTPLATE = ITEMS.register("phish_chestplate",
                        () -> new ArmorItem(ModArmorMaterials.PHISH, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

        public static final RegistryObject<Item> PHISH_LEGGINGS = ITEMS.register("phish_leggings",
                        () -> new ArmorItem(ModArmorMaterials.PHISH, ArmorItem.Type.LEGGINGS, new Item.Properties()));

        public static final RegistryObject<Item> PHISH_BOOTS = ITEMS.register("phish_boots",
                        () -> new ArmorItem(ModArmorMaterials.PHISH, ArmorItem.Type.BOOTS, new Item.Properties()));

        public static final RegistryObject<Item> PHUSHO = ITEMS.register("phusho",
                        () -> new Phusho(new Item.Properties().durability(1000)));

        public static final RegistryObject<Item> PREMIUM_FLAKES = ITEMS.register("premium_flakes",
                        () -> new Item(new Item.Properties().fireResistant()));

         public static final RegistryObject<Item> TOB_SPAWN_EGG = ITEMS.register("tob_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.TOB, 0x7e9680, 0xc5d1c5, new Item.Properties()));

        public static final RegistryObject<Item> SNORKEL_SPAWN_EGG = ITEMS.register("snorkel_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SNORKEL, 0x7e9680, 0xc5d1c5, new Item.Properties()));

            public static final RegistryObject<Item> MORAY_SPAWN_EGG = ITEMS.register("moray_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MORAY, 0x7e9680, 0xc5d1c5, new Item.Properties()));

        public static final RegistryObject<Item> PHISH_TOOL = ITEMS.register("phish_tool", 
                ()-> new PhishToolItem(new Item.Properties().durability(30)));

        public static void register(IEventBus eventBus) {
                ITEMS.register(eventBus);
        }
}
