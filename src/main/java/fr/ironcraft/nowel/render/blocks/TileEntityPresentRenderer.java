package fr.ironcraft.nowel.render.blocks;


import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import fr.ironcraft.nowel.Nowel;
import fr.ironcraft.nowel.blocks.tileentities.TileEntityPresent;
import fr.ironcraft.nowel.models.ModelPresent;


public class TileEntityPresentRenderer extends TileEntitySpecialRenderer<TileEntityPresent>
{
	private static final ModelPresent presentModel = new ModelPresent(0.5f);
	private static final ResourceLocation[] textures = new ResourceLocation[16];

	static
	{
		// Load a texture for every EnumDye item
		for (int i = 0; i < 16; i++)
		{
			textures[i] = new ResourceLocation(Nowel.MODID, "textures/entity/present/present_" + i + ".png");
		}
	}

	@Override
	public void renderTileEntityAt(TileEntityPresent te, double x, double y, double z, float partialTicks, int destroyStage)
	{
		// Get block metadata
		int meta = te.getBlockMetadata();

		// Setup lighting
		int l = te.getWorld().getCombinedLight(te.getPos(), 0);
		int l1 = l % 65536;
		int l2 = l / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) l1, (float) l2);

		GlStateManager.pushMatrix();
		{
			// Transform setup
			GlStateManager.translate(x, y, z);
			GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
			GlStateManager.translate(0.5f, -1.15f, -0.5f);
			GlStateManager.scale(0.75f, 0.75f, 0.75f);

			// Bind correct texture
			bindTexture(textures[meta]);

			// Then render the model
			presentModel.render();
		}
		GlStateManager.popMatrix();
	}
}
