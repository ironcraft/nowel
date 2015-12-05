package fr.ironcraft.nowel.blocks;

import fr.ironcraft.nowel.Nowel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class CustomBlocks {

	public Block present;
	public Block garland;

	public CustomBlocks()
	{
		this.init();
	}
	
	private void init()
	{
		present = new BlockPresent().setUnlocalizedName("present").setCreativeTab(Nowel.TAB_NOWEL);
		garland = new DecoBlock().setUnlocalizedName("garland").setCreativeTab(Nowel.TAB_NOWEL);

		this.register();
	}
	
	private void register()
	{
		this.registerTileEntityBlock(present, "present", TileEntityPresent.class);
		this.registerBlock(garland, "garland");
	}
	
	private void registerBlock(Block block, String name)
	{
        GameRegistry.registerBlock(block, name);
        if (Side.CLIENT != null)
        	Nowel.items.registerItemRender(Item.getItemFromBlock(block), 0, name);
	}
	
	private void registerTileEntityBlock(Block block, String name, Class<? extends TileEntity> tile)
	{
		this.registerBlock(block, name);
		GameRegistry.registerTileEntity(tile, Nowel.MODID + ":" + name + "_tileentity");
	}
}
