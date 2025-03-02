// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelyuna_jumpsuit<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "yuna_jumpsuit"), "main");
	private final ModelPart Body;
	private final ModelPart shoe;
	private final ModelPart alien;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;

	public Modelyuna_jumpsuit(ModelPart root) {
		this.Body = root.getChild("Body");
		this.shoe = this.Body.getChild("shoe");
		this.alien = this.shoe.getChild("alien");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(16, 16)
						.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.7F)).texOffs(40, 0)
						.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.85F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition shoe = Body.addOrReplaceChild("shoe",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-2.0F, 2.4F, -3.5F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 8)
						.addBox(-2.0F, -1.6F, -2.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(8.0F, -8.4F, 0.5F));

		PartDefinition alien = shoe.addOrReplaceChild("alien",
				CubeListBuilder.create().texOffs(18, 0)
						.addBox(-2.5F, -1.5F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(-1.0F)).texOffs(20, 10)
						.addBox(-2.5F, -3.5F, -1.5F, 5.0F, 4.0F, 2.0F, new CubeDeformation(-1.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 16)
				.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.45F)),
				PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(40, 16).mirror()
						.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.45F)).mirror(false),
				PartPose.offset(5.0F, 2.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}