package fr.ironcraft.nowel;

import fr.ironcraft.nowel.blocks.CustomBlocks;
import fr.ironcraft.nowel.items.CustomItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CustomCrafting {

	public CustomCrafting()
	{
		this.init();
	}
	
	private void init()
	{
		CustomItems items = Nowel.items;
		CustomBlocks blocks = Nowel.blocks;
		
		GameRegistry.addRecipe(new ItemStack(items.candyCaneSword), new Object[] {" X ", " X ", " C ", 'X', items.candyCane, 'C' , Items.stick});
		GameRegistry.addRecipe(new ItemStack(items.iceSword), new Object[] {" X ", " X ", " C ", 'X', Blocks.ice, 'C' , Items.stick});
	}
	
}
