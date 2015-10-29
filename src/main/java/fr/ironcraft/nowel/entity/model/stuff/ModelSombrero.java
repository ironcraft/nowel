package fr.ironcraft.nowel.entity.model.stuff;

import org.lwjgl.opengl.GL11;

import fr.ironcraft.nowel.Nowel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;

public class ModelSombrero extends ModelBase
{

	//public List<ModelRenderer> renderers;
	
	
	public ModelRenderer base;
	public ModelRenderer bord1;
	public ModelRenderer bord2;
	public ModelRenderer bord3;
	public ModelRenderer bord4;
	public ModelRenderer h1;
	public ModelRenderer h2;
	public ModelRenderer h3;
	public ModelRenderer h4;

	Minecraft mc = Minecraft.getMinecraft();
	ResourceLocation texture;
	
	public ModelSombrero()
	{
		textureWidth = 256;
		textureHeight = 64;

		texture = new ResourceLocation(Nowel.MODID, "textures/entity/hat/sombrero.png");
		
		base = createModelRenderer(92, 0, -12F, 0F, -12F, 24, 1, 24);
		bord1 = createModelRenderer(115, 26, -12F, 1F, 11F, 24, 1, 1);
		bord2 = createModelRenderer(145, 29, 11F, 1F, -12F, 1, 1, 24);
		bord3 = createModelRenderer(115, 26, -12F, 1F, -12F, 24, 1, 1);
		bord4 = createModelRenderer(145, 29, -12F, 1F, -12F, 1, 1, 24);
		h1 = createModelRenderer(0, 34, -6F, 1F, -6F, 12, 4, 12);
		h2 = createModelRenderer(48, 38, -5F, 5F, -5F, 10, 2, 10);
		h3 = createModelRenderer(88, 40, -4F, 7F, -4F, 8, 2, 8);
		h4 = createModelRenderer(120, 41, -3F, 9F, -3F, 6, 3, 6);
		
		/*
		renderers.add(createModelRenderer(92, 0, -12F, 0F, -12F, 24, 1, 24));
		renderers.add(createModelRenderer(115, 26, -12F, 1F, 11F, 24, 1, 1));
		renderers.add(createModelRenderer(145, 29, 11F, 1F, -12F, 1, 1, 24));
		renderers.add(createModelRenderer(115, 26, -12F, 1F, -12F, 24, 1, 1));
		renderers.add(createModelRenderer(145, 29, -12F, 1F, -12F, 1, 1, 24));
		renderers.add(createModelRenderer(0, 34, -6F, 4F, -6F, 12, 4, 12));
		renderers.add(createModelRenderer(48, 38, -5F, 5F, -5F, 10, 2, 10));
		renderers.add(createModelRenderer(88, 40, -4F, 8F, -4F, 8, 2, 8));
		renderers.add(createModelRenderer(120, 41, -3F, 11F, -3F, 6, 3, 6));
		*/
	}

	private ModelRenderer createModelRenderer(int offsetX, int offsetY, float posX, float posY, float posZ, int sizeX, int sizeY, int sizeZ) {
		float f = -1F;
		ModelRenderer part = new ModelRenderer(this, offsetX, offsetY);
		part.addBox(posX, posY, posZ, sizeX, sizeY, sizeZ);
		part.setRotationPoint(0F, 0F, 0F);
		part.setTextureSize(textureWidth, textureHeight);
		return (part);
	}
	
	/*

	public ModelSombrero()
	{
		this(0.0F);
	}

	public ModelSombrero(float par1)
	{
		this(par1, 0.0F);
	}

	public ModelSombrero(float par1, float par2)
	{
		textureWidth = 256;
		textureHeight = 64;

		base = createModelRenderer(par2, 92, 0, -12F, -7F, -12F, 24, 1, 24);
		bord1 = createModelRenderer(par2, 115, 26, -12F, -8F, 11F, 24, 1, 1);
		bord2 = createModelRenderer(par2, 145, 29, 11F, -8F, -12F, 1, 1, 24);
		bord3 = createModelRenderer(par2, 115, 26, -12F, -8F, -12F, 24, 1, 1);
		bord4 = createModelRenderer(par2, 145, 29, -12F, -8F, -12F, 1, 1, 24);
		h1 = createModelRenderer(par2, 0, 34, -6F, -11F, -6F, 12, 4, 12);
		h2 = createModelRenderer(par2, 48, 38, -5F, -13F, -5F, 10, 2, 10);
		h3 = createModelRenderer(par2, 88, 40, -4F, -15F, -4F, 8, 2, 8);
		h4 = createModelRenderer(par2, 120, 41, -3F, -18F, -3F, 6, 3, 6);

		/*base = new ModelRenderer(this, 92, 0);
		base.addBox(-12F, -7F, -12F, 24, 1, 24);
		base.setRotationPoint(0.0F, 0.0F + par2 - f, 0.0F);
		base.setTextureSize(256, 64);
		bord1 = new ModelRenderer(this, 115, 26);
		bord1.addBox(-12F, -8F, 11F, 24, 1, 1);
		bord1.setRotationPoint(0.0F, 0.0F + par2 - f, 0.0F);
		bord1.setTextureSize(256, 64);
		bord2 = new ModelRenderer(this, 145, 29);
		bord2.addBox(11F, -8F, -12F, 1, 1, 24);
		bord2.setRotationPoint(0.0F, 0.0F + par2 - f, 0.0F);
		bord2.setTextureSize(256, 64);
		bord3 = new ModelRenderer(this, 115, 26);
		bord3.addBox(-12F, -8F, -12F, 24, 1, 1);
		bord3.setRotationPoint(0.0F, 0.0F + par2 - f, 0.0F);
		bord3.setTextureSize(256, 64);
		bord4 = new ModelRenderer(this, 145, 29);
		bord4.addBox(-12F, -8F, -12F, 1, 1, 24);
		bord4.setRotationPoint(0.0F, 0.0F + par2 - f, 0.0F);
		bord4.setTextureSize(256, 64);
		h1 = new ModelRenderer(this, 0, 34);
		h1.addBox(-6F, -11F, -6F, 12, 4, 12);
		h1.setRotationPoint(0.0F, 0.0F + par2 - f, 0.0F);
		h2 = new ModelRenderer(this, 48, 38);
		h2.addBox(-5F, -13F, -5F, 10, 2, 10);
		h2.setRotationPoint(0.0F, 0.0F + par2 - f, 0.0F);
		h3 = new ModelRenderer(this, 88, 40);
		h3.addBox(-4F, -15F, -4F, 8, 2, 8);
		h3.setRotationPoint(0.0F, 0.0F + par2 - f, 0.0F);
		h4 = new ModelRenderer(this, 120, 41);
		h4.addBox(-3F, -18F, -3F, 6, 3, 6);
		h4.setRotationPoint(0F, 0.0F + par2 - f, 0F);
		/
	}
	 */

	/*public void render(float par1, float par2, float par3)
	{
		GL11.glPushMatrix();
		GL11.glScalef(1f, 1f, 1f);
		GL11.glRotatef(par2, 0f, 1f, 0f);
		GL11.glRotatef(par3, 1f, 0f, 0f);
		render(par1);
		GL11.glPopMatrix();
	}*/

	
	public void setRotationAngles(float angleX, float angleY)
	{
		base.rotateAngleX = angleX;
		base.rotateAngleY = angleY;

		this.copyModelAngles(base, bord1);
		this.copyModelAngles(base, bord2);
		this.copyModelAngles(base, bord3);
		this.copyModelAngles(base, bord4);
		this.copyModelAngles(base, h1);
		this.copyModelAngles(base, h2);
		this.copyModelAngles(base, h3);
		this.copyModelAngles(base, h4);
	}
	
	public void render(float angleX, float angleY, float par2)
	{
		setRotationAngles(angleX, angleY);
		mc.renderEngine.bindTexture(texture);
		
		//GL11.glPushMatrix();
		//GL11.glTranslatef(0F, 1.7F, 0F);
		//GL11.glRotatef(180F, 1, 0, 0);

		base.render(par2);
		bord1.render(par2);
		bord2.render(par2);
		bord3.render(par2);
		bord4.render(par2);
		h1.render(par2);
		h2.render(par2);
		h3.render(par2);
		h4.render(par2);
		
		//GL11.glPopMatrix();
	}
	
	public void render(ModelPlayer p, float par2)
	{
		setModelAttributes(p);
		setRotationAngles(p.bipedHead);
		mc.renderEngine.bindTexture(texture);
		
		//GL11.glPushMatrix();
		//GL11.glTranslatef(0F, 1.7F, 0F);
		//GL11.glRotatef(180F, 1, 0, 0);

		base.render(par2);
		bord1.render(par2);
		bord2.render(par2);
		bord3.render(par2);
		bord4.render(par2);
		h1.render(par2);
		h2.render(par2);
		h3.render(par2);
		h4.render(par2);
		
		//GL11.glPopMatrix();
	}

	public void setRotationAngles(ModelRenderer head)
	{
		this.copyModelAngles(head, base);

		this.copyModelAngles(head, bord1);
		this.copyModelAngles(head, bord2);
		this.copyModelAngles(head, bord3);
		this.copyModelAngles(head, bord4);
		this.copyModelAngles(head, h1);
		this.copyModelAngles(head, h2);
		this.copyModelAngles(head, h3);
		this.copyModelAngles(head, h4);
	}
}