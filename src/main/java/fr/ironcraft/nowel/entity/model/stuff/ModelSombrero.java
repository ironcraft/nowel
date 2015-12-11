package fr.ironcraft.nowel.entity.model.stuff;


import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;
import fr.ironcraft.nowel.Nowel;


public class ModelSombrero extends ModelBase
{

	public ModelRenderer base;
	public ModelRenderer bord1;
	public ModelRenderer bord2;
	public ModelRenderer bord3;
	public ModelRenderer bord4;
	public ModelRenderer h1;
	public ModelRenderer h2;
	public ModelRenderer h3;
	public ModelRenderer h4;

	ResourceLocation texture;

	public ModelSombrero()
	{
		textureWidth = 256;
		textureHeight = 64;

		texture = new ResourceLocation(Nowel.MODID, "textures/entity/hat/sombrero.png");

		base = createModelRenderer(92, 0, -12F, -2F, -12F, 24, 1, 24);
		bord1 = createModelRenderer(115, 26, -12F, -3F, 11F, 24, 1, 1);
		bord2 = createModelRenderer(145, 29, 11F, -3F, -12F, 1, 1, 24);
		bord3 = createModelRenderer(115, 26, -12F, -3F, -12F, 24, 1, 1);
		bord4 = createModelRenderer(145, 29, -12F, -3F, -12F, 1, 1, 24);
		h1 = createModelRenderer(0, 34, -6F, -6F, -6F, 12, 4, 12);
		h2 = createModelRenderer(48, 38, -5F, -8F, -5F, 10, 2, 10);
		h3 = createModelRenderer(88, 40, -4F, -10F, -4F, 8, 2, 8);
		h4 = createModelRenderer(120, 41, -3F, -13F, -3F, 6, 3, 6);

	}

	private ModelRenderer createModelRenderer(int offsetX, int offsetY, float posX, float posY, float posZ, int sizeX, int sizeY, int sizeZ)
	{
		ModelRenderer part = new ModelRenderer(this, offsetX, offsetY);
		part.addBox(posX, posY, posZ, sizeX, sizeY, sizeZ);
		part.setRotationPoint(0F, 0F, 0F);
		part.setTextureSize(textureWidth, textureHeight);
		return (part);
	}

	public void setRotationAngles(float angleX, float angleY)
	{
		base.rotateAngleX = angleX;
		base.rotateAngleY = angleY;

		copyModelAngles(base, bord1);
		copyModelAngles(base, bord2);
		copyModelAngles(base, bord3);
		copyModelAngles(base, bord4);
		copyModelAngles(base, h1);
		copyModelAngles(base, h2);
		copyModelAngles(base, h3);
		copyModelAngles(base, h4);
	}

	public void render(float angleX, float angleY, float par2)
	{
		setRotationAngles(angleX, angleY);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);

		base.render(par2);
		bord1.render(par2);
		bord2.render(par2);
		bord3.render(par2);
		bord4.render(par2);
		h1.render(par2);
		h2.render(par2);
		h3.render(par2);
		h4.render(par2);
	}

}