package fr.ironcraft.nowel.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import fr.ironcraft.nowel.container.ContainerPresentCreation;
import fr.ironcraft.nowel.inventory.InventoryPresent;
import fr.ironcraft.nowel.items.ItemPresentEmpty;
import fr.ironcraft.nowel.utils.EnumGuis;

public class GuiNowelHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		if (id == EnumGuis.PRESENT_CREATION.getId())
		{
			if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ItemPresentEmpty)
			{
				return new ContainerPresentCreation(new InventoryPresent(player.getCurrentEquippedItem()), player.inventory, player);
			}
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		if (id == EnumGuis.PRESENT_CREATION.getId())
		{
			if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ItemPresentEmpty)
			{
				return new GuiPresentCreation(new InventoryPresent(player.getCurrentEquippedItem()), player.inventory, player);
			}
		}
		
		return null;
	}
}

