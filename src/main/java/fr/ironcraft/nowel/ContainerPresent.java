package fr.ironcraft.nowel;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import fr.ironcraft.nowel.blocks.TileEntityPresent;


public class ContainerPresent extends Container
{
	private TileEntityPresent presentTileEntity;

	public ContainerPresent(TileEntityPresent tile, InventoryPlayer playerInventory, EntityPlayer player)
	{
		presentTileEntity = tile;
		presentTileEntity.openInventory(player);

		this.addSlotToContainer(new Slot(tile, 0, 80, 20));
		byte b0 = 51;

		for (int i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, i * 18 + b0));
			}
		}

		for (int i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 58 + b0));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn)
	{
		return presentTileEntity.isUseableByPlayer(playerIn);
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot) inventorySlots.get(slotIndex);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (slotIndex < presentTileEntity.getSizeInventory())
			{
				if (!this.mergeItemStack(itemstack1, presentTileEntity.getSizeInventory(), inventorySlots.size(), true))
				{
					return null;
				}
			}
			else if (!this.mergeItemStack(itemstack1, 0, presentTileEntity.getSizeInventory(), false))
			{
				return null;
			}

			if (itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack) null);
			}
			else
			{
				slot.onSlotChanged();
			}
		}
		return itemstack;
	}

	public void onContainerClosed(EntityPlayer player)
	{
		super.onContainerClosed(player);
		presentTileEntity.closeInventory(player);
	}
}
