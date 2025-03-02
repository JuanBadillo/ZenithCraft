// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelamogustop<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "amogustop"), "main");
	private final ModelPart Body;
	private final ModelPart LeftArm;
	private final ModelPart RighArm;

	public Modelamogustop(ModelPart root) {
		this.Body = root.getChild("Body");
		this.LeftArm = root.getChild("LeftArm");
		this.RighArm = root.getChild("RighArm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-8.0F, -12.0F, -7.0F, 16.0F, 28.0F, 14.0F, new CubeDeformation(0.75F)).texOffs(30, 42)
						.addBox(-6.0F, -7.0F, 7.4F, 12.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 8.3F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(18, 47)
				.addBox(-0.1F, -12.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.1F)),
				PartPose.offset(1.0F, 18.0F, 0.0F));

		PartDefinition RighArm = partdefinition.addOrReplaceChild("RighArm",
				CubeListBuilder.create().texOffs(19, 45).mirror()
						.addBox(-0.9F, -12.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.1F)).mirror(false),
				PartPose.offset(-1.0F, 18.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RighArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.RighArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
	}
}