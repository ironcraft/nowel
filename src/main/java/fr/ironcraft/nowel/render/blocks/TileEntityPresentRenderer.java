package fr.ironcraft.nowel.render.blocks;


import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

import org.lwjgl.opengl.GL11;

import fr.ironcraft.nowel.blocks.tileentities.TileEntityPresent;


public class TileEntityPresentRenderer extends TileEntitySpecialRenderer<TileEntityPresent>
{

	@Override
	public void renderTileEntityAt(TileEntityPresent te, double x, double y, double z, float partialTicks, int destroyStage)
	{
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glPopMatrix();		
	}
}
