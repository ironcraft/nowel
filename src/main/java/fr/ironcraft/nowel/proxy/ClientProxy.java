package fr.ironcraft.nowel.proxy;


import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import fr.ironcraft.nowel.Nowel;
import fr.ironcraft.nowel.blocks.TileEntityPresent;
import fr.ironcraft.nowel.events.EventHandler;
import fr.ironcraft.nowel.render.blocks.TileEntityPresentRenderer;


public class ClientProxy extends CommonProxy
{
	public void init()
	{
		super.init();
		MinecraftForge.EVENT_BUS.register(new EventHandler());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPresent.class, new TileEntityPresentRenderer());
		renderRegisterObject(Nowel.present, 0, "present");

		renderRegisterObject(Nowel.candyCaneSword, 0, "candyCaneSword");
		renderRegisterObject(Nowel.candyCane, 0, "candyCane");
		renderRegisterObject(Nowel.iceSword, 0, "iceSword");
	}

	public void renderRegisterObject(Item item, int metadata, String name)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, metadata, new ModelResourceLocation(Nowel.MODID + ":" + name, "inventory"));
	}
	
	public void renderRegisterObject(Block block, int metadata, String name)
	{
		renderRegisterObject(Item.getItemFromBlock(block), metadata, name);
	}
}