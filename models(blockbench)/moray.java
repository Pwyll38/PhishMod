// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class moray<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "moray"), "main");
	private final ModelPart moray;

	public moray(ModelPart root) {
		this.moray = root.getChild("moray");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition moray = partdefinition.addOrReplaceChild("moray", CubeListBuilder.create(), PartPose.offset(-2.6333F, 21.4742F, -3.9566F));

		PartDefinition head_bone = moray.addOrReplaceChild("head_bone", CubeListBuilder.create(), PartPose.offsetAndRotation(3.1333F, -10.7722F, -3.88F, 0.1309F, 0.0F, 0.0F));

		PartDefinition head_r1 = head_bone.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 3.3351F, -13.7781F, -0.1309F, 0.0F, 0.0F));

		PartDefinition seg_1_jnt = moray.addOrReplaceChild("seg_1_jnt", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, -1.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-1.0F, -5.0F, -1.0F, 0.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(2.6333F, -2.4742F, -15.0434F));

		PartDefinition seg_3_jnt7 = moray.addOrReplaceChild("seg_3_jnt7", CubeListBuilder.create().texOffs(17, 18).addBox(-2.0F, -10.0F, -1.0F, 2.0F, 2.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(0, 7).addBox(-1.0F, -11.0F, -1.0F, 0.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(2.6333F, 3.5258F, 0.9566F));

		PartDefinition seg_3_jnt18 = moray.addOrReplaceChild("seg_3_jnt18", CubeListBuilder.create().texOffs(20, 0).addBox(-2.0F, -10.0F, -8.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(-1.0F, -11.0F, -8.0F, 0.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(2.6333F, 3.5258F, 22.9566F));

		PartDefinition mouth_3_jnt = moray.addOrReplaceChild("mouth_3_jnt", CubeListBuilder.create(), PartPose.offset(1.6333F, -4.3321F, -17.0964F));

		PartDefinition mouth_r1 = mouth_3_jnt.addOrReplaceChild("mouth_r1", CubeListBuilder.create().texOffs(0, 6).addBox(-2.0F, 1.4254F, -2.1868F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.6804F, 0.0114F, 0.4363F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		moray.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}