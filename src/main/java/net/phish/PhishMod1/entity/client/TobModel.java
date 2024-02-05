package net.phish.PhishMod1.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;


import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import net.phish.PhishMod1.entity.animations.ModAnimationDefinitions;
import net.phish.PhishMod1.entity.custom.TobEntity;

public class TobModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart fins;
	private final ModelPart tail;
	private final ModelPart bb_main;

	public TobModel(ModelPart root) {
		this.fins = root.getChild("fins");
		this.tail = root.getChild("tail");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition fins = partdefinition.addOrReplaceChild("fins", CubeListBuilder.create().texOffs(8, 8).addBox(2.0F, -2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(8, 7).addBox(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(6, 8).addBox(-2.0F, -2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(4, 8).addBox(-2.0F, -8.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(6, 7).addBox(0.0F, -8.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(4, 7).addBox(2.0F, -8.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 7).addBox(-5.0F, -6.0F, -1.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(2, 7).addBox(-6.0F, -3.0F, -1.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, -7.0F, -1.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 24.0F, 1.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -7.0F, -1.0F, 6.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateWalk(ModAnimationDefinitions.TOB_SWIMMING, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((TobEntity) entity).idleAnimationState, ModAnimationDefinitions.TOB_SWIMMING, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		fins.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
			
	@Override
	public ModelPart root() {
		return bb_main;
	}
}