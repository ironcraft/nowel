package fr.ironcraft.nowel.utils;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import fr.ironcraft.nowel.Nowel;


public enum EnumGuis
{
	PRESENT;

	public int getId()
	{
		return ordinal();
	}

	public void open(EntityPlayer player, World world, BlockPos pos)
	{
		player.openGui(Nowel.instance, getId(), world, pos.getX(), pos.getY(), pos.getZ());
	}
}
