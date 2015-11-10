package fr.ironcraft.nowel.gui;

import fr.ironcraft.nowel.blocks.TileEntityPresent;
import fr.ironcraft.nowel.container.ContainerPresent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class CustomGuiHandler implements IGuiHandler
{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
		
        if(tile instanceof TileEntityPresent) {
            return new ContainerPresent((TileEntityPresent)tile, player.inventory, player);
        }
        
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
		
        if(tile instanceof TileEntityPresent) {
            return new GuiPresent((TileEntityPresent)tile, player.inventory, player);
        }
        
		return null;
	}
}
