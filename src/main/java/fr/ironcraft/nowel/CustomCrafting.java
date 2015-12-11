package fr.ironcraft.nowel;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import fr.ironcraft.nowel.items.CustomItems;

public class CustomCrafting {

	public CustomCrafting()
	{
		this.init();
	}
	
	private void init()
	{
		CustomItems items = Nowel.items;
		
		GameRegistry.addRecipe(new ItemStack(items.candyCaneSword), new Object[] {" X ", " X ", " C ", 'X', items.candyCane, 'C' , Items.stick});
		GameRegistry.addRecipe(new ItemStack(items.iceSword), new Object[] {" X ", " X ", " C ", 'X', Blocks.ice, 'C' , Items.stick});
		GameRegistry.addRecipe(new ItemStack(items.santaHat), new Object[] {" A ", " B ", "CDC", 'A', Items.string, 'B', new ItemStack(Blocks.wool, 1, 14), 'C', Items.redstone, 'D', Blocks.wool});
	}
	
}
