package fr.ironcraft.nowel.render.blocks;


import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import fr.ironcraft.nowel.Nowel;
import fr.ironcraft.nowel.blocks.BlockSnowGlobe.SnowGlobeTypes;
import fr.ironcraft.nowel.blocks.tileentities.TileEntitySnowGlobe;
import fr.ironcraft.nowel.models.ModelSnowGlobeShape;


public class TileEntitySnowGlobeRenderer extends TileEntitySpecialRenderer<TileEntitySnowGlobe>
{
	private static ModelSnowGlobeShape shapeModel = new ModelSnowGlobeShape();
	private static final ResourceLocation shapeModelTexture = new ResourceLocation(Nowel.MODID, "textures/blocks/snowglobe.png");

	@Override
	public void renderTileEntityAt(TileEntitySnowGlobe te, double x, double y, double z, float partialTicks, int destroyStage)
	{
		// Get block metadata
		int meta = te.getBlockMetadata();
		SnowGlobeTypes type = SnowGlobeTypes.byMetadata(meta);

		// Setup lighting
		int l = te.getWorld().getCombinedLight(te.getPos(), 0);
		int l1 = l % 65536;
		int l2 = l / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) l1, (float) l2);

		GlStateManager.pushMatrix();
		{
			// Transform setup
			GlStateManager.translate(x, y, z);
			renderType(te, type, partialTicks);
		}
		GlStateManager.popMatrix();
	}

	private void renderType(TileEntitySnowGlobe te, SnowGlobeTypes type, float partialTicks)
	{
		shapeModel = new ModelSnowGlobeShape();
		bindTexture(shapeModelTexture);
		shapeModel.render();
		
		if (type.equals(SnowGlobeTypes.PURE_SNOW))
		{

		}
	}
}
