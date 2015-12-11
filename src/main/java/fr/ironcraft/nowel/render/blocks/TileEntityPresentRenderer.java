package fr.ironcraft.nowel.render.blocks;


import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import fr.ironcraft.nowel.Nowel;
import fr.ironcraft.nowel.blocks.tileentities.TileEntityPresent;
import fr.ironcraft.nowel.entity.model.ModelPresent;


public class TileEntityPresentRenderer extends TileEntitySpecialRenderer<TileEntityPresent>
{
	private static ModelPresent presentModel = new ModelPresent(0.5f);
	

	@Override
	public void renderTileEntityAt(TileEntityPresent te, double x, double y, double z, float partialTicks, int destroyStage)
	{
		int meta = te.getBlockMetadata();
		
		ResourceLocation[] array = new ResourceLocation[16];
		
		for (int i = 0; i < 16; i++)
		{
			array[i] = new ResourceLocation(Nowel.MODID, "textures/entity/present/present_" + i + ".png");
		}
		

        int l = te.getWorld().getCombinedLight(te.getPos(), 0);
        int l1 = l % 65536;
        int l2 = l / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)l1, (float)l2); 
		
		GlStateManager.pushMatrix();
		GlStateManager.translate(x, y, z);
		GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
		GlStateManager.translate(0.5f, -1.15f, -0.5f);
		GlStateManager.scale(0.75f, 0.75f, 0.75f);
		bindTexture(array[meta]);

		presentModel.render();
		GlStateManager.popMatrix();
	}
}
