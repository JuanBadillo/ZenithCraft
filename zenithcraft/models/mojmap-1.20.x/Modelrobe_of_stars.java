// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelrobe_of_stars<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "robe_of_stars"), "main");
	private final ModelPart hood;
	private final ModelPart bb_main;

	public Modelrobe_of_stars(ModelPart root) {
		this.hood = root.getChild("hood");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition hood = partdefinition.addOrReplaceChild("hood",
				CubeListBuilder.create().texOffs(42, 0)
						.addBox(-5.0F, -8.7682F, -4.0801F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
						.texOffs(52, 30).addBox(-5.0F, -0.2682F, 0.9199F, 10.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
						.texOffs(42, 43).addBox(5.0F, -8.7682F, -4.0801F, 1.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
						.texOffs(45, 11).addBox(-6.0F, -8.7682F, -4.0801F, 1.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
						.texOffs(16, 53).addBox(-5.0F, -7.7682F, 4.9199F, 10.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-8.5F, -10.5F, -2.0F, 17.0F, 21.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -14.9087F, 4.2999F, 0.1047F, 0.0F, 0.0F));

		PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 25).addBox(-3.0F, -0.5F, -3.5F, 6.0F, 21.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.0F, -24.9F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(26, 25).addBox(-3.0F, -0.5F, -3.5F, 6.0F, 21.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-6.0F, -24.9F, 0.0F, 0.0F, 0.0F, 0.0873F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		hood.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.hood.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.hood.xRot = headPitch / (180F / (float) Math.PI);
	}
}