package fr.ironcraft.nowel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
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
import fr.ironcraft.nowel.worldgen.CustomWorldGenerator;

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

    public static Item candyCane;
    public static Item iceSword;
    public static Item candyCaneSword;

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
        
        GameRegistry.registerWorldGenerator(new CustomWorldGenerator(), 0);

        //Items BEGIN
        candyCane = (new ItemFood(2, 0.1F, false).setUnlocalizedName("candyCane").setFull3D()); //Missing Texture
        GameRegistry.registerItem(candyCane, "candyCane");

        iceSword = (new ItemSword(Item.ToolMaterial.STONE).setUnlocalizedName("iceSword")); //Missing Texture
        GameRegistry.registerItem(iceSword, "iceSword");

        candyCaneSword = (new ItemSword(Item.ToolMaterial.STONE).setUnlocalizedName("candyCaneSword")); //Missing Texture
        GameRegistry.registerItem(candyCaneSword, "candyCaneSword");
        //Items END

		proxy.init();

		//Crafts BEGIN
		GameRegistry.addRecipe(new ItemStack(candyCaneSword), new Object[] {" X ", " X ", " C ", 'X', candyCane, 'C' , Items.stick});
		GameRegistry.addRecipe(new ItemStack(iceSword), new Object[] {" X ", " X ", " C ", 'X', Blocks.ice, 'C' , Items.stick});
		//Craft END

        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandlerPresent());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

	}
}