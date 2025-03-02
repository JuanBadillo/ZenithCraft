// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelcrazy_antenna<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "crazy_antenna"), "main");
	private final ModelPart Helmet;
	private final ModelPart bone2;

	public Modelcrazy_antenna(ModelPart root) {
		this.Helmet = root.getChild("Helmet");
		this.bone2 = this.Helmet.getChild("bone2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Helmet = partdefinition.addOrReplaceChild("Helmet", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.75F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Helmet.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(8, 26).addBox(-1.0F, -4.5F, -1.0F, 2.0F, 7.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition bone2 = Helmet.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(0, 26)
						.addBox(0.0F, -8.0F, 0.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 12)
						.addBox(-4.5F, -3.0F, -4.0F, 11.0F, 3.0F, 11.0F, new CubeDeformation(0.25F)),
				PartPose.offsetAndRotation(-1.0F, -12.0F, -2.0F, 0.6981F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Helmet.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.Helmet.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Helmet.xRot = headPitch / (180F / (float) Math.PI);
	}
}