package fr.ironcraft.nowel.gui;


import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.ironcraft.nowel.Nowel;
import fr.ironcraft.nowel.blocks.TileEntityPresent;
import fr.ironcraft.nowel.container.ContainerPresent;


public class GuiPresent extends GuiContainer
{
	private static final ResourceLocation presentBackground = new ResourceLocation(Nowel.MODID + ":textures/gui/container/present.png");
	private TileEntityPresent presentTileEntity;
	@SuppressWarnings("unused")
	private IInventory playerInventory;

	public GuiPresent(TileEntityPresent tile, InventoryPlayer inventory, EntityPlayer player)
	{
		super(new ContainerPresent(tile, inventory, player));
		this.presentTileEntity = tile;
		this.playerInventory = inventory;
		this.allowUserInput = false;
		this.ySize = 170;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialRenderTick, int x, int y)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); 
		this.mc.getTextureManager().bindTexture(presentBackground);
		int k = (this.width - this.xSize) / 2; 
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y)
	{
		String tileName = this.presentTileEntity.hasCustomName() ? this.presentTileEntity.getName() : I18n.format(this.presentTileEntity.getName());
		this.fontRendererObj.drawString(tileName, (this.xSize - this.fontRendererObj.getStringWidth(tileName)) / 2, 6, 0);
	}
}