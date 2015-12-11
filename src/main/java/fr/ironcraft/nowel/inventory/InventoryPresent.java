package fr.ironcraft.nowel.inventory;


import static net.minecraft.block.Block.getIdFromBlock;
import static net.minecraft.item.Item.getIdFromItem;

import java.util.Arrays;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.common.util.Constants;
import fr.ironcraft.nowel.Nowel;

public class InventoryPresent implements IInventory
{
	public ItemStack[] inventoryContent;
	public int size;
	
	public InventoryPresent(int size)
	{
		this.size = size;
		inventoryContent = new ItemStack[size];
	}
	
	public void readFromNBT(NBTTagCompound comp)
	{
		NBTTagList nbtlist = comp.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
		for (int i = 0; i < nbtlist.tagCount(); i++)
		{
			NBTTagCompound comp1 = nbtlist.getCompoundTagAt(i);
			int slot = comp1.getInteger("Slot");
			inventoryContent[slot] = ItemStack.loadItemStackFromNBT(comp1);
		}
	}

	public void writeToNBT(NBTTagCompound comp)
	{
		NBTTagList nbtlist = new NBTTagList();

		for (int i = 0; i < size; i++)
		{
			if (inventoryContent[i] != null)
			{
				NBTTagCompound comp1 = new NBTTagCompound();
				comp1.setInteger("Slot", i);
				inventoryContent[i].writeToNBT(comp1);
				nbtlist.appendTag(comp1);
			}
		}
		comp.setTag("Inventory", nbtlist);
	}

	@Override
	public int getSizeInventory()
	{
		return size;
	}

	@Override
	public ItemStack getStackInSlot(int index)
	{
		return inventoryContent[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int amount)
	{
		ItemStack stack = getStackInSlot(index);
		if (stack != null)
		{
			if (stack.stackSize > amount)
			{
				stack = stack.splitStack(amount);
				if (stack.stackSize == 0)
					inventoryContent[index] = null;
			}
			else
			{
				inventoryContent[index] = null;
			}
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int index)
	{
		ItemStack stack = getStackInSlot(index);
		if (stack != null)
		{
			inventoryContent[index] = null;
		}
		
		return stack;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack)
	{
		inventoryContent[index] = stack;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public void markDirty()
	{
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player)
	{
	}

	@Override
	public void closeInventory(EntityPlayer player)
	{
	}

	/**
	 * Nobody would like a player putting a present insdide a present.
	 */
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
	{
		return stack.getItem() != null && getIdFromItem(stack.getItem()) != getIdFromBlock(Nowel.blocks.present);
	}

	@Override
	public String getCommandSenderName()
	{
		return "inventory.present";
	}

	@Override
	public boolean hasCustomName()
	{
		return false;
	}

	@Override
	public IChatComponent getDisplayName()
	{
		return new ChatComponentText(getCommandSenderName());
	}

	@Override
	public int getField(int id)
	{
		return 0;
	}

	@Override
	public void setField(int id, int value)
	{
	}

	@Override
	public int getFieldCount()
	{
		return 0;
	}

	@Override
	public void clear()
	{
		Arrays.fill(inventoryContent, null);
	}
}
