// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelsombrero_vaquero<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "sombrero_vaquero"), "main");
	private final ModelPart bone;

	public Modelsombrero_vaquero(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.0F, -11.6F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(24, 12)
						.addBox(-5.0F, -8.6F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(32, 3)
						.addBox(-4.0F, -12.6F, -4.0F, 3.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(32, 3)
						.mirror().addBox(1.0F, -12.6F, -4.0F, 3.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(-18, 12).addBox(-5.0F, -7.6F, -9.0F, 10.0F, 0.0F, 18.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head_r1 = bone.addOrReplaceChild("Head_r1",
				CubeListBuilder.create().texOffs(-18, 30).mirror()
						.addBox(-5.0F, 0.0F, -9.0F, 5.0F, 0.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-5.0F, -7.6F, 0.0F, 0.0F, 0.0F, 0.8727F));

		PartDefinition Head_r2 = bone.addOrReplaceChild("Head_r2",
				CubeListBuilder.create().texOffs(-18, 30).addBox(0.0F, 0.0F, -9.0F, 5.0F, 0.0F, 18.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, -7.6F, 0.0F, 0.0F, 0.0F, -0.8727F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.bone.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.bone.xRot = headPitch / (180F / (float) Math.PI);
	}
}