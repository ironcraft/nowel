package fr.ironcraft.nowel.blocks;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import fr.ironcraft.nowel.Nowel;
import fr.ironcraft.nowel.blocks.tileentities.TileEntityPresent;
import fr.ironcraft.nowel.items.ItemBlockPresent;


public class CustomBlocks
{

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
		this.registerTileEntityBlock(present, "present", TileEntityPresent.class, ItemBlockPresent.class);
		this.registerBlock(garland, "garland");
	}

	private void registerBlock(Block block, String name)
	{
		this.registerBlock(block, name, ItemBlock.class);
	}
	
	private void registerBlock(Block block, String name, Class<? extends ItemBlock> clazz, Object...args)
	{
		GameRegistry.registerBlock(block, clazz, name, args);
		if (Side.CLIENT != null)
			Nowel.items.registerItemRender(Item.getItemFromBlock(block), 0, name);
	}

	private void registerBlock(Block block, String name, Class<? extends ItemBlock> clazz)
	{
		registerBlock(block, name, clazz, new Object[] {});
	}

	@SuppressWarnings("unused")
	private void registerTileEntityBlock(Block block, String name, Class<? extends TileEntity> tile)
	{
		this.registerTileEntityBlock(block, name, tile, ItemBlock.class);
	}

	private void registerTileEntityBlock(Block block, String name, Class<? extends TileEntity> tile, Class<? extends ItemBlock> clazz)
	{
		this.registerTileEntityBlock(block, name, tile, clazz, new Object[] {});
	}
	
	private void registerTileEntityBlock(Block block, String name, Class<? extends TileEntity> tile, Class<? extends ItemBlock> clazz, Object...args)
	{
		this.registerBlock(block, name, clazz, args);
		GameRegistry.registerTileEntity(tile, Nowel.MODID + ":" + name + "_tileentity");
	}
}
