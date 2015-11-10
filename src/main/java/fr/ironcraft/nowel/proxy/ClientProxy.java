package fr.ironcraft.nowel.proxy;


import fr.ironcraft.nowel.Nowel;
import fr.ironcraft.nowel.blocks.TileEntityPresent;
import fr.ironcraft.nowel.events.EventHandler;
import fr.ironcraft.nowel.render.blocks.TileEntityPresentRenderer;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;


public class ClientProxy extends CommonProxy
{
	public void init()
	{
		super.init();
		MinecraftForge.EVENT_BUS.register(new EventHandler());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPresent.class, new TileEntityPresentRenderer());
	}
	
}