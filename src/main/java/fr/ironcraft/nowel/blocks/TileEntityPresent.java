package fr.ironcraft.nowel.blocks;


import java.util.Arrays;
import java.util.UUID;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.common.util.Constants;

import com.sun.istack.internal.NotNull;

import fr.ironcraft.nowel.Nowel;


public class TileEntityPresent extends TileEntity implements IInventory
{
	protected UUID giverId, givenId;
	protected ItemStack[] presents;

	public TileEntityPresent()
	{
		super();
		presents = new ItemStack[1];
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);

		giverId = new UUID(compound.getLong("GiverIDMost"), compound.getLong("GiverIDLeast"));
		givenId = new UUID(compound.getLong("GivenIDMost"), compound.getLong("GivenIDLeast"));

		NBTTagList nbttaglist = compound.getTagList("Presents", Constants.NBT.TAG_COMPOUND);
		presents = new ItemStack[getSizeInventory()];
		for (int i = 0; i < nbttaglist.tagCount(); i++)
		{
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 255;

			if (j >= 0 && j < presents.length)
			{
				presents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		
		if (giverId != null) {
			compound.setLong("GiverIDMost", giverId.getMostSignificantBits());
			compound.setLong("GiverIDLeast", giverId.getLeastSignificantBits());
			compound.setLong("GivenIDMost", givenId.getMostSignificantBits());
			compound.setLong("GivenIDLeast", givenId.getLeastSignificantBits());
		}

        NBTTagList nbttaglist = new NBTTagList();
        for(int i = 0; i < presents.length; i++)
        {
            if(presents[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                presents[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }
        compound.setTag("Presents", nbttaglist);
	}

	public Packet getDescriptionPacket()
	{
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeToNBT(nbttagcompound);
		return new S35PacketUpdateTileEntity(pos, getBlockMetadata(), nbttagcompound);
	}

	public void onDataPacket(NetworkManager networkManager, S35PacketUpdateTileEntity packet)
	{
		this.readFromNBT(packet.getNbtCompound());
	}

	public boolean onPlayerClicked(EntityPlayer player, BlockPos pos, IBlockState state, EnumFacing side)
	{
		@NotNull
		UUID playerId = player.getUniqueID();

		if (playerId.equals(giverId))
		{

		}
		else if (playerId.equals(givenId))
		{

		}
		else
		{
			player.addChatMessage(new ChatComponentText("Ce cadeau n'est pas pour vous !"));
			player.addChatMessage(new ChatComponentText("OpenGUI"));
			player.openGui(Nowel.instance, 0, player.worldObj, pos.getX(), pos.getY(), pos.getZ());
		}

		return true;
	}

	@Override
	public String getName()
	{
		return "Hey";
	}

	@Override
	public boolean hasCustomName()
	{
		return false;
	}

	@Override
	public IChatComponent getDisplayName()
	{
		return new ChatComponentText(getName());
	}

	@Override
	public int getSizeInventory()
	{
		return presents.length;
	}

	@Override
	public ItemStack getStackInSlot(int index)
	{
		return presents[index];
	}

	@Override
	public ItemStack decrStackSize(int slotIndex, int amount)
	{
		if (presents[slotIndex] != null)
		{
			ItemStack itemstack;

			if (presents[slotIndex].stackSize <= amount)
			{
				itemstack = presents[slotIndex];
				presents[slotIndex] = null;
				markDirty();
				return itemstack;
			}
			else
			{
				itemstack = presents[slotIndex].splitStack(amount);

				if (presents[slotIndex].stackSize == 0)
				{
					presents[slotIndex] = null;
				}
				markDirty();
				return itemstack;
			}
		}
		else
		{
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slotIndex)
	{
		if (presents[slotIndex] != null)
		{
			ItemStack itemstack = presents[slotIndex];
			presents[slotIndex] = null;
			return itemstack;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int slotIndex, ItemStack stack)
	{
		presents[slotIndex] = stack;

		if (stack != null && stack.stackSize > getInventoryStackLimit())
		{
			stack.stackSize = getInventoryStackLimit();
		}

		markDirty();
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		//		UUID playerId = player.getUniqueID();
		//		return playerId.equals(giverId) || playerId.equals(givenId);
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

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
	{
		return true;
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
		Arrays.fill(presents, null);
		markDirty();
	}
}
