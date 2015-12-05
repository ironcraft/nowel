package fr.ironcraft.nowel.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import fr.ironcraft.nowel.utils.EnumGuis;

public class ItemPresentEmpty extends ItemPresent
{
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World world, EntityPlayer player)
	{
		EnumGuis.PRESENT_CREATION.open(player, world, player.getPosition());
		
		return itemStackIn;
	}
}
