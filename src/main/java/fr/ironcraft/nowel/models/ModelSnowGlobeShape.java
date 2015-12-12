package fr.ironcraft.nowel.models;


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;


public class ModelSnowGlobeShape extends ModelBase
{
	public ModelRenderer glassGlobe;
	public ModelRenderer plinth;

	public ModelSnowGlobeShape()
	{
		textureWidth = 64;
		textureHeight = 64;

		glassGlobe = createModelRenderer(0, 0, 1.0f, 1.0f, 1.0f, 14, 14, 14);
		plinth = createModelRenderer(0, 28, 0.0f, 0.0f, 0.0f, 16, 3, 16);
	}

	private ModelRenderer createModelRenderer(int offsetX, int offsetY, float posX, float posY, float posZ, int sizeX, int sizeY, int sizeZ)
	{
		ModelRenderer part = new ModelRenderer(this, offsetX, offsetY);
		part.addBox(posX, posY, posZ, sizeX, sizeY, sizeZ);
		part.setTextureSize(textureWidth, textureHeight);
		return (part);
	}

	public void render()
	{
		float f = 0.0625f;
		glassGlobe.render(f);
		plinth.render(f);
	}
}
