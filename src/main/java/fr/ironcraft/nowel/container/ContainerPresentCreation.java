package fr.ironcraft.nowel.container;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import fr.ironcraft.nowel.Nowel;
import fr.ironcraft.nowel.container.slot.SlotDye;
import fr.ironcraft.nowel.container.slot.SlotPresent;
import fr.ironcraft.nowel.inventory.InventoryPresent;

public class ContainerPresentCreation extends Container
{
	private InventoryPresent presentTileEntity;
	private IInventory inventoryDye;

	public ContainerPresentCreation(InventoryPresent presentInventory, InventoryPlayer playerInventory, EntityPlayer player)
	{
		inventoryDye = new InventoryBasic("DyeInventory", false, 1);
		presentTileEntity = presentInventory;
		presentTileEntity.openInventory(player);

		this.addSlotToContainer(new SlotDye(inventoryDye, 0, 70, 20));
		this.addSlotToContainer(new SlotPresent(presentInventory, 0, 90, 20));

		byte b0 = 71;

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

	public void onValidate(String receiverName, EntityPlayer player)
	{
		if (canCreatePresent())
		{
			System.out.println("id = " + getSlotFromInventory(inventoryDye, 0).getStack().getItemDamage());
			ItemStack filledUpPresent = new ItemStack(Nowel.blocks.present, 1, getSlotFromInventory(inventoryDye, 0).getStack().getItemDamage());
			player.inventory.decrStackSize(player.inventory.currentItem, 1);
			// TODO : @wytrem make it localized
			filledUpPresent.setStackDisplayName("Cadeau pour " + receiverName);
			writeToNBT(filledUpPresent);
			player.inventory.addItemStackToInventory(filledUpPresent);
		}
		
		player.closeScreen();
	}

	public boolean canCreatePresent()
	{
		return getSlotFromInventory(presentTileEntity, 0).getHasStack() && getSlotFromInventory(inventoryDye, 0).getHasStack();
	}
}
