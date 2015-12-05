package fr.ironcraft.nowel.utils;

import fr.ironcraft.nowel.Nowel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public enum EnumGuis
{
	PRESENT_CREATION;
	
	public int getId()
	{
		return ordinal();
	}
	
	public void open(EntityPlayer player, World world, BlockPos pos)
	{
		player.openGui(Nowel.instance, getId(), world, pos.getX(), pos.getY(), pos.getZ());
	}
}
