package fr.ironcraft.nowel.entity.model.stuff;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;
import fr.ironcraft.nowel.Nowel;

public class ModelSantaHat extends ModelBase
{

	public ModelRenderer h0;
	public ModelRenderer h1;
	public ModelRenderer h2;
	public ModelRenderer h3;
	public ModelRenderer h4;

	ResourceLocation texture;
	
	public ModelSantaHat()
	{
		textureWidth = 32;
		textureHeight = 32;

		texture = new ResourceLocation(Nowel.MODID, "textures/entity/hat/santa.png");
		
		h0 = createModelRenderer(0, 0, -5F, -7F, -5F, 10, 1, 10);
		h1 = createModelRenderer(0, 16, -4F, -9F, -4F, 8, 2, 8);
		h2 = createModelRenderer(0, 16, -3F, -11F, -3F, 6, 2, 6);
		h3 = createModelRenderer(0, 16, -2F, -12F, -2F, 4, 1, 4);
		h4 = createModelRenderer(0, 16, -1F, -13F, -1F, 2, 1, 2);

	}

	private ModelRenderer createModelRenderer(int offsetX, int offsetY, float posX, float posY, float posZ, int sizeX, int sizeY, int sizeZ) {
		float f = -1F;
		ModelRenderer part = new ModelRenderer(this, offsetX, offsetY);
		part.addBox(posX, posY, posZ, sizeX, sizeY, sizeZ);
		part.setRotationPoint(0F, -22.5F, 0F);
		part.setTextureSize(textureWidth, textureHeight);
		return (part);
	}
	
	public void setRotationAngles(float angleX, float angleY)
	{
		h0.rotateAngleX = angleX;
		h0.rotateAngleY = angleY;

		this.copyModelAngles(h0, h1);
		this.copyModelAngles(h0, h2);
		this.copyModelAngles(h0, h3);
		this.copyModelAngles(h0, h4);
	}
	
	public void render(float angleX, float angleY, float par2)
	{
		setRotationAngles(angleX, angleY);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);

		h0.render(par2);
		h1.render(par2);
		h2.render(par2);
		h3.render(par2);
		h4.render(par2);
	}

}