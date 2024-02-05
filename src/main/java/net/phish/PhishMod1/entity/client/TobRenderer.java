package net.phish.PhishMod1.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.phish.PhishMod1.PhishMod1;
import net.phish.PhishMod1.entity.custom.TobEntity;

public class TobRenderer extends MobRenderer<TobEntity, TobModel<TobEntity>>{

    public TobRenderer(Context pContext) {
        super(pContext, new TobModel<>(pContext.bakeLayer(ModModelsLayers.TOB_LAYER)), 0.2f);
    }

    @Override
    public ResourceLocation getTextureLocation(TobEntity pEntity) {
        return new ResourceLocation(PhishMod1.MOD_ID, "textures/entity/tob.png");
    }

    @Override
    public void render(TobEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f); 
        }

        

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

}
