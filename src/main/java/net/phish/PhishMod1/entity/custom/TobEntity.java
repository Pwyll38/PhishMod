package net.phish.PhishMod1.entity.custom;

import javax.annotation.Nullable;

import org.jetbrains.annotations.ApiStatus.OverrideOnly;
import org.joml.Math;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.OcelotAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.animal.Salmon;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.MelonBlock;
import net.phish.PhishMod1.entity.ModEntities;
import net.phish.PhishMod1.item.ModItems;
import net.minecraft.world.entity.player.Player;

public class TobEntity extends Animal {

    public TobEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public final AnimationState idleAnimationState = new AnimationState();

    private int idleAnimationTimeout = 0;

    @Override
    public void tick(){
        super.tick();
        if(this.level().isClientSide()){
            setUpAnimationStates();
        }
    }

    private void setUpAnimationStates(){
        if(this.idleAnimationTimeout <=0){
            this.idleAnimationTimeout = this.random.nextInt(40)+80;
            this.idleAnimationState.start(this.tickCount);
        }else{
            --this.idleAnimationTimeout;
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick){
        float f;
        if(this.getPose()==Pose.STANDING){
            f = Math.min(pPartialTick*6F, 1f);
        }else{
            f = 0;
        }
        this.walkAnimation.update(f, 0.2f);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.15D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.5D, Ingredient.of(ModItems.PREMIUM_FLAKES.get()), false));
        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.5D));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.5D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 1f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.MOVEMENT_SPEED, 0.05D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D)
                .add(Attributes.FOLLOW_RANGE, 2.0D);

    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntities.TOB.get().create(pLevel);
    }

    @Nullable
    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(ModItems.PREMIUM_FLAKES.get());
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound(){
        return SoundEvents.AMBIENT_UNDERWATER_ENTER;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource){
        return SoundEvents.AMETHYST_BLOCK_CHIME;
    }
}
