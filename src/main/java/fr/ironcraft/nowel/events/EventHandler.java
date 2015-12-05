package fr.ironcraft.nowel.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.lwjgl.opengl.GL11;

import fr.ironcraft.nowel.entity.model.stuff.ModelSantaHat;
import fr.ironcraft.nowel.items.SantaHat;

public class EventHandler {

	ModelSantaHat santa = new ModelSantaHat();


	@SubscribeEvent
	public void OnRenderPlayer(RenderPlayerEvent.Post e)
	{
        ItemStack itemStack = e.entityPlayer.getCurrentArmor(3);
        if(itemStack != null && itemStack.getItem() instanceof SantaHat) {
            float shift = e.entityPlayer.isSneaking() ? 0.24F : 0F;

            GL11.glPushMatrix();
            GL11.glTranslatef((float) e.x, (float) e.y - shift, (float) e.z);
            GL11.glRotatef(180F, 1, 0, 0);
            santa.render((float) Math.toRadians(((EntityPlayer) e.entity).rotationPitch), (float) Math.toRadians(((EntityPlayer) e.entity).rotationYawHead), 0.0625F);
            GL11.glPopMatrix();
        }
    }
	
	/*
	@SubscribeEvent
	 public void OnRenderPlayer(RenderPlayerEvent.Specials.Post event) {
	  for(int i = 0; i < 4; i++) {
	   Item stuff = Player.getStuff(i);
	   if(stuff != null) {
	    RenderStuff render = RenderMap.getStuffRenderFor(stuff); 
	    render.doRender(event.entityPlayer, event.partialRenderTick);
	   }
	 }
	}*/
	
}
