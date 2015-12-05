package fr.ironcraft.nowel.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public abstract class ItemPresent extends Item
{
	public ItemPresent()
	{
		super();
		setCreativeTab(CreativeTabs.tabDecorations);
	}
}
