package fr.ironcraft.nowel.render.blocks;


import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import fr.ironcraft.nowel.Nowel;
import fr.ironcraft.nowel.blocks.tileentities.TileEntityPresent;


public class TileEntityPresentRenderer extends TileEntitySpecialRenderer
{
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double posX, double posY, double posZ, float partialTickTime, int meta)
	{
		GL11.glPushMatrix();
		GL11.glTranslated(posX, posY, posZ);
		renderTileEntityPresent((TileEntityPresent) tileEntity, tileEntity.getWorld(), partialTickTime, meta, Nowel.blocks.present);
		GL11.glPopMatrix();
	}

	private void renderTileEntityPresent(TileEntityPresent tileEntity, World world, float partialTickTime, int meta, Block block)
	{
		// None.
	}
}
