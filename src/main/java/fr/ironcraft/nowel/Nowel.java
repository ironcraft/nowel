package fr.ironcraft.nowel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import fr.ironcraft.nowel.blocks.BlockPresent;
import fr.ironcraft.nowel.blocks.TileEntityPresent;
import fr.ironcraft.nowel.proxy.CommonProxy;

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
	
	public static BlockPresent present;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		present = (BlockPresent) (new BlockPresent().setUnlocalizedName("present"));
		GameRegistry.registerBlock(present, "present");
        GameRegistry.registerTileEntity(TileEntityPresent.class, MODID + ":present_tileentity");
		proxy.init();
		
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandlerPresent());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

	}
}