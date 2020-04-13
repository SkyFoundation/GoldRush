package com.pixelsky.goldrush.entity.robotTerminator;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTerminator extends ModelBase {
    private final ModelRenderer bone;
    private final ModelRenderer bone1;

    public ModelTerminator() {
        textureWidth = 64;
        textureHeight = 64;

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 24.0F, 0.0F);

        bone1 = new ModelRenderer(this);
        bone1.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone.addChild(bone1);
        bone1.cubeList.add(new ModelBox(bone1, 24, 18, 4.0F, -3.0F, -2.0F, 1, 4, 4, 0.0F, false));
        bone1.cubeList.add(new ModelBox(bone1, 0, 0, -5.0F, -4.0F, -2.0F, 1, 4, 4, 0.0F, false));
        bone1.cubeList.add(new ModelBox(bone1, 0, 0, -5.0F, -16.0F, -5.0F, 10, 8, 10, 0.0F, false));
        bone1.cubeList.add(new ModelBox(bone1, 0, 18, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));
        bone1.cubeList.add(new ModelBox(bone1, 30, 5, -2.0F, -3.0F, -5.0F, 4, 4, 1, 0.0F, false));
        bone1.cubeList.add(new ModelBox(bone1, 30, 0, -2.0F, -3.0F, 4.0F, 4, 4, 1, 0.0F, false));
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
