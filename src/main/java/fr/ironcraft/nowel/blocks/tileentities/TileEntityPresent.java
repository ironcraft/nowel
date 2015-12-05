package fr.ironcraft.nowel.blocks.tileentities;


import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import fr.ironcraft.nowel.inventory.InventoryPresent;
import fr.ironcraft.nowel.utils.FireworkColor;
import fr.ironcraft.nowel.utils.FireworkEffect;
import fr.ironcraft.nowel.utils.FireworkEffect.Type;


public class TileEntityPresent extends TileEntity
{
	private InventoryPresent inventoryPresent;

	public TileEntityPresent()
	{
		super();
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
	}

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
		FireworkEffect effect = FireworkEffect.builder().with(Type.STAR).withColor(FireworkColor.WHITE).build();
		
		player.worldObj.makeFireworks(pos.getX(), pos.getY(), pos.getZ(), 0.0f, 0.0f, 0.0f, FireworkEffect.makeReadableNBT(effect.toExplosionTag()));
		player.inventory.addItemStackToInventory(inventoryPresent.getStackInSlot(0));
		
		return true;
	}
}
