package fr.ironcraft.nowel.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import fr.ironcraft.nowel.Nowel;

public class CustomItems {

	public static Item candyCane;
    public static Item candyCaneSword;
    public static Item iceSword;
    public static Item record_nowel;
    public static Item santaHat;
	public static Item presentEmpty;
	
    public CustomItems()
    {
    	this.init();
    }
    
	private void init()
	{
        candyCane = new ItemFood(2, 0.1F, false).setUnlocalizedName("candy-cane").setFull3D().setCreativeTab(Nowel.TAB_NOWEL);
        candyCaneSword = new ItemSword(Item.ToolMaterial.STONE).setUnlocalizedName("candy-cane_sword").setCreativeTab(Nowel.TAB_NOWEL);
        iceSword = new ItemSword(Item.ToolMaterial.STONE).setUnlocalizedName("ice_sword").setCreativeTab(Nowel.TAB_NOWEL);
		record_nowel = new ItemCustomRecord("nowel").setUnlocalizedName("record.nowel").setCreativeTab(Nowel.TAB_NOWEL);
        santaHat = new SantaHat();
		presentEmpty = new ItemPresentEmpty().setUnlocalizedName("empty_present").setCreativeTab(Nowel.TAB_NOWEL);

        this.register();
	}
	
	private void register()
	{
		this.registerItem(candyCane, "candyCane");
		this.registerItem(candyCaneSword, "candyCaneSword");
		this.registerItem(iceSword, "iceSword");
		this.registerItem(record_nowel, "record_nowel");
		this.registerItem(santaHat, "santaHat");
		this.registerItem(presentEmpty, "empty_present");
	}
	
	private void registerItem(Item item, String name)
	{
        GameRegistry.registerItem(item, name);
        if (Side.CLIENT != null)
        	this.registerItemRender(item, 0, name);
	}
	
	public void registerItemRender(Item item, int metadata, String name)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, metadata, new ModelResourceLocation(Nowel.MODID + ":" + name, "inventory"));
	}
}
