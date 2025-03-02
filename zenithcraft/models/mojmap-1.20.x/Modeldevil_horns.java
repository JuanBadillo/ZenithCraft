// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modeldevil_horns<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "devil_horns"), "main");
	private final ModelPart devil_horns;

	public Modeldevil_horns(ModelPart root) {
		this.devil_horns = root.getChild("devil_horns");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition devil_horns = partdefinition.addOrReplaceChild("devil_horns",
				CubeListBuilder.create().texOffs(4, 5)
						.addBox(4.0F, -11.0F, -1.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(4, 5).mirror()
						.addBox(-7.0F, -11.0F, -1.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		devil_horns.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.devil_horns.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.devil_horns.xRot = headPitch / (180F / (float) Math.PI);
	}
}