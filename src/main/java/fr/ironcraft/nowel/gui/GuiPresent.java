package fr.ironcraft.nowel.gui;


import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.ironcraft.nowel.Nowel;
import fr.ironcraft.nowel.container.ContainerPresent;
import fr.ironcraft.nowel.inventory.InventoryPresent;


public class GuiPresent extends GuiContainer
{
	private static final ResourceLocation presentBackground = new ResourceLocation(Nowel.MODID, "textures/gui/container/present.png");
	private IInventory presentTileEntity;
	@SuppressWarnings("unused")
	private InventoryPlayer playerInventory;

	public GuiPresent(InventoryPresent tile, InventoryPlayer inventory, EntityPlayer player)
	{
		super(new ContainerPresent(tile, inventory, player));
		this.presentTileEntity = tile;
		this.playerInventory = inventory;
		this.allowUserInput = false;
		this.xSize = 176;
		this.ySize = 153;
	}

	public void initGui()
	{
		super.initGui();
	}

	/**
	 * Called when the screen is unloaded. Used to disable keyboard repeat
	 * events.
	 */
	public void onGuiClosed()
	{
		super.onGuiClosed();
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException
	{
	}

	/**
	 * Fired when a key is typed (except F11 who toggle full screen). This is
	 * the equivalent of
	 * KeyListener.keyTyped(KeyEvent e). Args : character (character on the
	 * key), keyCode (lwjgl Keyboard key code)
	 */
	protected void keyTyped(char typedChar, int keyCode) throws IOException
	{
		super.keyTyped(typedChar, keyCode);
	}
	
	@Override
	protected void handleMouseClick(Slot slotIn, int slotId, int clickedButton, int clickType)
	{
		super.handleMouseClick(slotIn, slotId, clickedButton, clickType);
	}


	/**
	 * Draws the screen and all the components in it. Args : mouseX, mouseY,
	 * renderPartialTicks
	 */
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
    /**
     * Called when the mouse is clicked. Args : mouseX, mouseY, clickedButton
     */
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        super.mouseClicked(mouseX, mouseY, mouseButton);
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
		String tileName = this.presentTileEntity.getDisplayName().getFormattedText();
		this.fontRendererObj.drawString(tileName, (this.xSize - this.fontRendererObj.getStringWidth(tileName)) / 2, 6, 0);
	}
}