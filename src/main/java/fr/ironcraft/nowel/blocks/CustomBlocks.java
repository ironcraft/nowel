package fr.ironcraft.nowel.blocks;

import fr.ironcraft.nowel.Nowel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class CustomBlocks {

	public static Block present;
	
	public CustomBlocks()
	{
		this.init();
	}
	
	private void init()
	{
		present = new BlockPresent().setUnlocalizedName("present").setCreativeTab(Nowel.TAB_NOWEL);
		
		this.register();
	}
	
	private void register()
	{
		this.registerTileEntityBlock(present, "present");
	}
	
	private void registerBlock(Block block, String name)
	{
        GameRegistry.registerBlock(block, name);
        if (Side.CLIENT != null)
        	Nowel.items.registerItemRender(Item.getItemFromBlock(block), 0, name);
	}
	
	private void registerTileEntityBlock(Block block, String name)
	{
		registerBlock(block, name);
		GameRegistry.registerTileEntity(TileEntityPresent.class, Nowel.MODID + ":"+name+"_tileentity");
	}
}
