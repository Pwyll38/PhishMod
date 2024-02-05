package net.phish.PhishMod1.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.phish.PhishMod1.entity.ModEntities;
import net.phish.PhishMod1.item.ModItems;

public class PhishBombProjectileEntity extends ThrowableItemProjectile{

    public PhishBombProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel); 
    }

    public PhishBombProjectileEntity(Level pLevel) {
        super(ModEntities.PHISH_BOMB_ENTITY.get() ,pLevel);
    }

    public PhishBombProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.PHISH_BOMB_ENTITY.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.PHISH_BOMB.get();
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult){
        if(!this.level().isClientSide()){
            this.level().broadcastEntityEvent(this, (byte)3);
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 5f, Level.ExplosionInteraction.TNT);
            this.discard();
        }

        super.onHitBlock(pResult);

    } 

    @Override
    protected void onHitEntity(EntityHitResult pResult){
        if(!this.level().isClientSide()){
            this.level().broadcastEntityEvent(this, (byte)3);
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 5f, Level.ExplosionInteraction.TNT);
            this.discard();
        }

        super.onHitEntity(pResult);

    } 

    
}
