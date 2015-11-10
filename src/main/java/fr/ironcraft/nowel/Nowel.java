package fr.ironcraft.nowel;

import fr.ironcraft.nowel.blocks.CustomBlocks;
import fr.ironcraft.nowel.gui.CustomGuiHandler;
import fr.ironcraft.nowel.items.CustomItems;
import fr.ironcraft.nowel.proxy.CommonProxy;
import fr.ironcraft.nowel.worldgen.CustomWorldGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Nowel.MODID, version = Nowel.VERSION)
public class Nowel
{
	@Instance(Nowel.MODID)
	public static Nowel		instance;

	public static final String	MODID	= "ic_nowel";
	public static final String	VERSION	= "1.0";
	public static final String	PATH	= "fr.ironcraft.nowel";

	@SidedProxy(clientSide = PATH + ".proxy.ClientProxy", serverSide = PATH + ".proxy.CommonProxy")
	public static CommonProxy	proxy;
	
	public static CustomItems items;
	public static CustomBlocks blocks;

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
        items = new CustomItems();
        blocks = new CustomBlocks();
        
        new CustomCrafting();

        GameRegistry.registerWorldGenerator(new CustomWorldGenerator(), 0);
        
		proxy.init();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new CustomGuiHandler());
	}

}