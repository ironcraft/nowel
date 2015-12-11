package fr.ironcraft.nowel.items;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


/**
 * Created by adrien on 10/11/15.
 */
public class SantaHat extends Item
{

	public SantaHat()
	{
		setUnlocalizedName("santa_hat");
		setCreativeTab(CreativeTabs.tabCombat);
		setMaxStackSize(1);
	}

	@Override
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity)
	{
		if (armorType == 0)
			return true;
		return false;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		ItemStack itemstack1 = playerIn.getCurrentArmor(3);

		if (itemstack1 == null)
		{
			playerIn.setCurrentItemOrArmor(4, itemStackIn.copy()); //Forge: Vanilla bug fix associated with fixed setCurrentItemOrArmor indexs for players.
			itemStackIn.stackSize = 0;
		}

		return itemStackIn;
	}

}
