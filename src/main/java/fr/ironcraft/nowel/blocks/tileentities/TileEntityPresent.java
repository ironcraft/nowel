package fr.ironcraft.nowel.blocks.tileentities;


import java.util.UUID;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import fr.ironcraft.nowel.inventory.InventoryPresent;
import fr.ironcraft.nowel.utils.EnumGuis;
import fr.ironcraft.nowel.utils.FireworkColor;
import fr.ironcraft.nowel.utils.FireworkEffect;
import fr.ironcraft.nowel.utils.FireworkEffect.Type;


public class TileEntityPresent extends TileEntity
{
	private InventoryPresent inventoryPresent;

	/**
	 * UUID of the last player who put something in that present. Used to
	 * prevent other players to get present by editing.
	 */
	private UUID lastUser;

	public TileEntityPresent()
	{
		super();
		inventoryPresent = new InventoryPresent(1);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);

		// TODO : @wytrem read/write inventory size
		inventoryPresent = new InventoryPresent(1);

		inventoryPresent.clear();
		inventoryPresent.readFromNBT(compound);
		
		long mostSignificantBits = compound.getLong("LastUserMost");
		long leastSignificantBits = compound.getLong("LastUserLeast");
		
		if (mostSignificantBits == -1l && leastSignificantBits == -1l)
		{
			lastUser = null;
		}
		else
		{
			lastUser = new UUID(mostSignificantBits, leastSignificantBits);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		inventoryPresent.writeToNBT(compound);
		
		long mostSignificantBits = -1l;
		long leastSignificantBits = -1l;

		if (lastUser != null)
		{
			mostSignificantBits = lastUser.getMostSignificantBits();
			leastSignificantBits = lastUser.getLeastSignificantBits();
		}
		
		compound.setLong("LastUserMost", mostSignificantBits);
		compound.setLong("LastUserLeast", leastSignificantBits);
	}

	@SuppressWarnings("rawtypes")
	public Packet getDescriptionPacket()
	{
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeToNBT(nbttagcompound);
		return new S35PacketUpdateTileEntity(pos, getBlockMetadata(), nbttagcompound);
	}

	public InventoryPresent getInventoryPresent()
	{
		return inventoryPresent;
	}

	public void setInventoryPresent(InventoryPresent inventoryPresent)
	{
		this.inventoryPresent = inventoryPresent;
	}

	public void onDataPacket(NetworkManager networkManager, S35PacketUpdateTileEntity packet)
	{
		this.readFromNBT(packet.getNbtCompound());
	}

	public boolean onPlayerClicked(EntityPlayer player, BlockPos pos, IBlockState state, EnumFacing side)
	{
		System.out.println("click, last = " + lastUser);
		
		if (lastUser == null || lastUser.equals(player.getPersistentID()))
		{
			EnumGuis.PRESENT.open(player, getWorld(), pos);
			lastUser = player.getPersistentID();
			return true;
		}
		
		return false;
	}

	public void onPlayerDestroyed(BlockPos pos, IBlockState state)
	{
		FireworkEffect effect = FireworkEffect.builder().with(Type.STAR).withColor(FireworkColor.WHITE).build();

		getWorld().makeFireworks(pos.getX(), pos.getY(), pos.getZ(), 0.0f, 0.0f, 0.0f, FireworkEffect.makeReadableNBT(effect.toExplosionTag()));
		InventoryHelper.dropInventoryItems(getWorld(), pos, inventoryPresent);
		
		getWorld().setBlockToAir(pos);
	}
}
