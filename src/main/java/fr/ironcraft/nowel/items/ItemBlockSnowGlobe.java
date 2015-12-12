package fr.ironcraft.nowel.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import fr.ironcraft.nowel.blocks.BlockSnowGlobe;

public class ItemBlockSnowGlobe extends ItemBlock
{
	public ItemBlockSnowGlobe(Block block)
	{
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	/**
	 * Converts the given ItemStack damage value into a metadata value to be
	 * placed in the world when this Item is
	 * placed as a Block (mostly used with ItemBlocks).
	 */
	public int getMetadata(int damage)
	{
		return damage;
	}

	/**
	 * Returns the unlocalized name of this item. This version accepts an
	 * ItemStack so different stacks can have
	 * different names based on their damage or NBT.
	 */
	public String getUnlocalizedName(ItemStack stack)
	{
		return super.getUnlocalizedName() + "." + BlockSnowGlobe.SnowGlobeTypes.byMetadata(stack.getMetadata()).getName();
	}
}
