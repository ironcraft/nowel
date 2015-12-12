package fr.ironcraft.nowel.proxy;


import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import fr.ironcraft.nowel.blocks.tileentities.TileEntityPresent;
import fr.ironcraft.nowel.blocks.tileentities.TileEntitySnowGlobe;
import fr.ironcraft.nowel.events.EventHandler;
import fr.ironcraft.nowel.render.blocks.TileEntityPresentRenderer;
import fr.ironcraft.nowel.render.blocks.TileEntitySnowGlobeRenderer;


public class ClientProxy extends CommonProxy
{
	public void init()
	{
		super.init();
		MinecraftForge.EVENT_BUS.register(new EventHandler());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPresent.class, new TileEntityPresentRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySnowGlobe.class, new TileEntitySnowGlobeRenderer());
	}

}