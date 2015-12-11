package fr.ironcraft.nowel.gui;


import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import fr.ironcraft.nowel.Nowel;
import fr.ironcraft.nowel.PresentCreationMessage;
import fr.ironcraft.nowel.container.ContainerPresentCreation;
import fr.ironcraft.nowel.inventory.InventoryPresent;


public class GuiPresentCreation extends GuiContainer
{
	private static final ResourceLocation presentBackground = new ResourceLocation(Nowel.MODID + ":textures/gui/container/present.png");
	private IInventory presentTileEntity;
	@SuppressWarnings("unused")
	private IInventory playerInventory;
	private GuiTextField nameField;
	private GuiButton send;

	public GuiPresentCreation(InventoryPresent tile, InventoryPlayer inventory, EntityPlayer player)
	{
		super(new ContainerPresentCreation(tile, inventory, player));
		this.presentTileEntity = tile;
		this.playerInventory = inventory;
		this.allowUserInput = false;
		this.xSize = 176;
		this.ySize = 153;
	}

	public void initGui()
	{
		super.initGui();
		Keyboard.enableRepeatEvents(true);
		int i = (this.width - this.xSize) / 2;
		int j = (this.height - this.ySize) / 2;
		this.nameField = new GuiTextField(0, this.fontRendererObj, i + 7, j + 47, 78, 12);
		this.nameField.setTextColor(-1);
		this.nameField.setDisabledTextColour(-1);
		this.nameField.setMaxStringLength(40);

		this.buttonList.add(send = new GuiButton(0, i + 91, j + 43, 78, 20, "Valider"));
		send.enabled = false;
	}

	/**
	 * Called when the screen is unloaded. Used to disable keyboard repeat
	 * events.
	 */
	public void onGuiClosed()
	{
		super.onGuiClosed();
		Keyboard.enableRepeatEvents(false);
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException
	{
		if (button.id == 0)
		{
			Nowel.network.sendToServer(new PresentCreationMessage(nameField.getText()));
		}
	}

	/**
	 * Fired when a key is typed (except F11 who toggle full screen). This is
	 * the equivalent of
	 * KeyListener.keyTyped(KeyEvent e). Args : character (character on the
	 * key), keyCode (lwjgl Keyboard key code)
	 */
	protected void keyTyped(char typedChar, int keyCode) throws IOException
	{
		if (this.nameField.textboxKeyTyped(typedChar, keyCode))
		{
			updateButtonState();
		}
		else
		{
			super.keyTyped(typedChar, keyCode);
		}
	}
	
	@Override
	protected void handleMouseClick(Slot slotIn, int slotId, int clickedButton, int clickType)
	{
		super.handleMouseClick(slotIn, slotId, clickedButton, clickType);
		
		updateButtonState();
	}

	protected void updateButtonState()
	{
		if (!nameField.getText().isEmpty() && ((ContainerPresentCreation) inventorySlots).canCreatePresent())
		{
			send.enabled = true;
		}
		else
		{
			send.enabled = false;
		}
	}

	/**
	 * Draws the screen and all the components in it. Args : mouseX, mouseY,
	 * renderPartialTicks
	 */
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		super.drawScreen(mouseX, mouseY, partialTicks);
		GlStateManager.disableLighting();
		GlStateManager.disableBlend();
		this.nameField.drawTextBox();
	}
	
    /**
     * Called when the mouse is clicked. Args : mouseX, mouseY, clickedButton
     */
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        this.nameField.mouseClicked(mouseX, mouseY, mouseButton);
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