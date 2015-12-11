package fr.ironcraft.nowel.container;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import fr.ironcraft.nowel.container.slot.SlotPresent;
import fr.ironcraft.nowel.inventory.InventoryPresent;


public class ContainerPresent extends Container
{
	private InventoryPresent presentTileEntity;

	public ContainerPresent(InventoryPresent presentInventory, InventoryPlayer playerInventory, EntityPlayer player)
	{
		presentTileEntity = presentInventory;
		presentTileEntity.openInventory(player);

		this.addSlotToContainer(new SlotPresent(presentInventory, 0, 80, 18));

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

	/**
	 * Used to save content.
	 */
	@Override
	public void onContainerClosed(EntityPlayer player)
	{
		super.onContainerClosed(player);
	}

	public void writeToNBT(ItemStack stack)
	{
		if (!stack.hasTagCompound())
		{
			stack.setTagCompound(new NBTTagCompound());
		}
		presentTileEntity.writeToNBT(stack.getTagCompound());
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
}
