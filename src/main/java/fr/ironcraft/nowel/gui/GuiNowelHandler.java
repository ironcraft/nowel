package fr.ironcraft.nowel.gui;

import static fr.ironcraft.nowel.utils.View.rayTrace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import fr.ironcraft.nowel.blocks.tileentities.TileEntityPresent;
import fr.ironcraft.nowel.container.ContainerPresent;
import fr.ironcraft.nowel.utils.EnumGuis;

public class GuiNowelHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		if (id == EnumGuis.PRESENT.getId())
		{
			MovingObjectPosition mop = rayTrace(player, 4);
			
			System.out.println("mop = " + mop);
			
			if (mop != null)
			{
				System.out.println("mop.type = " + mop.typeOfHit);
				
				if (mop.typeOfHit == MovingObjectType.BLOCK)
				{
					BlockPos pos = mop.getBlockPos();
					
					System.out.println("pos = " + pos);

					
					TileEntity tileEntity = world.getTileEntity(pos);

					if (tileEntity != null && tileEntity instanceof TileEntityPresent)
					{
						TileEntityPresent present = (TileEntityPresent) tileEntity;
						return new ContainerPresent(present.getInventoryPresent(), player.inventory, player);
					}
				}
			}
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		if (id == EnumGuis.PRESENT.getId())
		{
			MovingObjectPosition mop = rayTrace(player, 4);
			
			if (mop != null)
			{
				if (mop.typeOfHit == MovingObjectType.BLOCK)
				{
					BlockPos pos = mop.getBlockPos();
					
					TileEntity tileEntity = world.getTileEntity(pos);

					if (tileEntity != null && tileEntity instanceof TileEntityPresent)
					{
						TileEntityPresent present = (TileEntityPresent) tileEntity;
						return new GuiPresent(present.getInventoryPresent(), player.inventory, player);
					}
				}
			}
		}
		
		return null;
	}
}

