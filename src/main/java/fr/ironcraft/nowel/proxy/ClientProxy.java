package fr.ironcraft.nowel.proxy;

import fr.ironcraft.nowel.events.EventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	public void init()
	{
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
}