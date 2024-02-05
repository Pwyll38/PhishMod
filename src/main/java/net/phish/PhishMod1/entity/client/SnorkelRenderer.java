package net.phish.PhishMod1.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.phish.PhishMod1.PhishMod1;
import net.phish.PhishMod1.entity.custom.SnorkelEntity;


public class SnorkelRenderer extends MobRenderer<SnorkelEntity, SnorkelModel<SnorkelEntity>>{

    public SnorkelRenderer(Context pContext) {
        super(pContext, new SnorkelModel<>(pContext.bakeLayer(ModModelsLayers.SNORKEL_LAYER)), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(SnorkelEntity pEntity) {
        return new ResourceLocation(PhishMod1.MOD_ID, "textures/entity/snorkel.png");
    }

    @Override
    public void render(SnorkelEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f); 
        }

        

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

}
