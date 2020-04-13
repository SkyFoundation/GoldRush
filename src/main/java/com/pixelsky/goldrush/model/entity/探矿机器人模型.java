//Paste this code into your mod.

import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class custom_model extends ModelBase {
	private final ModelRenderer bone;
	private final ModelRenderer bone1;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;

	public custom_model() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);

		bone1 = new ModelRenderer(this);
		bone1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(bone1);
		bone1.cubeList.add(new ModelBox(bone1, 5, 5, 7.0F, -3.0F, -7.0F, 1, 3, 3, 0.0F, false));
		bone1.cubeList.add(new ModelBox(bone1, 0, 8, 7.0F, -3.0F, 4.0F, 1, 3, 3, 0.0F, false));
		bone1.cubeList.add(new ModelBox(bone1, 0, 22, -8.0F, -3.0F, 4.0F, 1, 3, 3, 0.0F, false));
		bone1.cubeList.add(new ModelBox(bone1, 0, 0, -8.0F, -3.0F, -7.0F, 1, 3, 3, 0.0F, false));
		bone1.cubeList.add(new ModelBox(bone1, 0, 0, -7.0F, -7.0F, -8.0F, 14, 6, 16, 0.0F, false));
		bone1.cubeList.add(new ModelBox(bone1, 0, 22, -4.0F, -15.0F, -4.0F, 8, 8, 8, 0.0F, false));
		bone1.cubeList.add(new ModelBox(bone1, 32, 32, -7.0F, -6.0F, -10.0F, 14, 4, 2, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -4.0F, -9.0F);
		bone.addChild(bone2);
		bone2.cubeList.add(new ModelBox(bone2, 0, 54, 7.0F, -1.0F, -9.0F, 1, 2, 10, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 50, 20, -8.0F, -1.0F, -9.0F, 1, 2, 10, 0.0F, false));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 0.0F, -8.0F);
		bone2.addChild(bone3);
		bone3.cubeList.add(new ModelBox(bone3, 24, 22, -7.0F, -2.0F, -2.0F, 14, 4, 4, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 46, 46, -6.5F, -4.0F, -4.0F, 1, 8, 8, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 44, 0, -3.5F, -4.0F, -4.0F, 1, 8, 8, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 36, 38, -0.5F, -4.0F, -4.0F, 1, 8, 8, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 18, 38, 2.5F, -4.0F, -4.0F, 1, 8, 8, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 0, 38, 5.5F, -4.0F, -4.0F, 1, 8, 8, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bone.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}