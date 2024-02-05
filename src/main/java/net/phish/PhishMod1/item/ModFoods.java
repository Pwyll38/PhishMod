package net.phish.PhishMod1.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SHUSHI = new FoodProperties.Builder().alwaysEat().meat().nutrition(5)
        .saturationMod(0.3f).effect(
            ()-> new MobEffectInstance(MobEffects.DOLPHINS_GRACE,500),0.9f).build();
            
    public static final FoodProperties CREATURO = new FoodProperties.Builder().alwaysEat().meat().nutrition(1)
        .saturationMod(0.3f).effect(
            ()-> new MobEffectInstance(MobEffects.BAD_OMEN,9900),0.9f).build();
    
}
