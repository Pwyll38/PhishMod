package net.phish.PhishMod1.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.phish.PhishMod1.PhishMod1;
import net.phish.PhishMod1.entity.custom.MorayEntity;


public class MorayRenderer extends MobRenderer<MorayEntity, MorayModel<MorayEntity>>{

    public MorayRenderer(Context pContext) {
        super(pContext, new MorayModel<>(pContext.bakeLayer(ModModelsLayers.MORAY_LAYER)), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(MorayEntity pEntity) {
        return new ResourceLocation(PhishMod1.MOD_ID, "textures/entity/moray.png");
    }

    @Override
    public void render(MorayEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f); 
        }

        

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

}
