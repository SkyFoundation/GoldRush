package com.pixelsky.cheese.entities.cheesemouse;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

    public class ModelCheeseMouse extends ModelBase {
        private final ModelRenderer bb_main;
        private final ModelRenderer bone;

        public ModelCheeseMouse() {
            textureWidth = 32;
            textureHeight = 32;

            bb_main = new ModelRenderer(this);
            bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
            bb_main.cubeList.add(new ModelBox(bb_main, 3, 2, -1.5F, -3.5F, -5.5F, 1, 1, 0, 0.0F, false));
            bb_main.cubeList.add(new ModelBox(bb_main, 3, 0, 0.5F, -3.5F, -5.5F, 1, 1, 0, 0.0F, false));
            bb_main.cubeList.add(new ModelBox(bb_main, 0, 2, 0.2F, -2.4F, -6.5F, 1, 1, 1, 0.0F, false));
            bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -1.2F, -2.4F, -6.5F, 1, 1, 1, 0.0F, false));

            bone = new ModelRenderer(this);
            bone.setRotationPoint(0.0F, 24.0F, 0.0F);
            bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, -3.0F, -2.0F, 4, 3, 5, 0.0F, false));
            bone.cubeList.add(new ModelBox(bone, 10, 15, -3.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));
            bone.cubeList.add(new ModelBox(bone, 8, 10, -0.5F, -1.0F, 4.0F, 1, 1, 4, 0.0F, false));
            bone.cubeList.add(new ModelBox(bone, 17, 17, -1.0F, -2.0F, 3.0F, 2, 2, 1, 0.0F, false));
            bone.cubeList.add(new ModelBox(bone, 13, 0, -1.0F, -2.0F, -7.0F, 2, 1, 2, 0.0F, false));
            bone.cubeList.add(new ModelBox(bone, 12, 15, -2.5F, -1.0F, -6.0F, 1, 1, 2, 0.0F, false));
            bone.cubeList.add(new ModelBox(bone, 14, 12, -0.5F, -2.0F, -8.0F, 1, 1, 1, 0.0F, false));
            bone.cubeList.add(new ModelBox(bone, 14, 8, -3.0F, -2.0F, 1.0F, 1, 2, 2, 0.0F, false));
            bone.cubeList.add(new ModelBox(bone, 0, 14, 2.0F, -2.0F, 1.0F, 1, 2, 2, 0.0F, false));
            bone.cubeList.add(new ModelBox(bone, 4, 14, 2.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));
            bone.cubeList.add(new ModelBox(bone, 0, 8, -1.5F, -3.0F, -5.0F, 3, 3, 3, 0.0F, false));
            bone.cubeList.add(new ModelBox(bone, 13, 3, -2.0F, -2.0F, -4.9F, 1, 1, 1, 0.0F, false));
            bone.cubeList.add(new ModelBox(bone, 6, 15, 1.5F, -1.0F, -6.0F, 1, 1, 2, 0.0F, false));
            bone.cubeList.add(new ModelBox(bone, 9, 8, 1.0F, -2.0F, -4.9F, 1, 1, 1, 0.0F, false));
        }

        @Override
        public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
            bb_main.render(f5);
            bone.render(f5);
        }
        public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
            modelRenderer.rotateAngleX = x;
            modelRenderer.rotateAngleY = y;
            modelRenderer.rotateAngleZ = z;
        }
    }