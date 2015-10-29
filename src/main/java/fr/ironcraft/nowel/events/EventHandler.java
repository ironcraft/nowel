package fr.ironcraft.nowel.events;

import org.lwjgl.opengl.GL11;

import fr.ironcraft.nowel.entity.model.stuff.ModelSombrero;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {

	//ModelSombrero sombrero = new ModelSombrero();
	
	@SubscribeEvent
	public void OnRenderPlayer(RenderPlayerEvent.Post e) {
		
		ModelSombrero sombrero = new ModelSombrero();
		
		//System.out.println(e.renderer.getPlayerModel().bipedHead.rotateAngleY);
		
		
		GL11.glPushMatrix();
        GL11.glTranslatef((float)e.x, (float)e.y + 1.7F, (float)e.z);
        //GL11.glRotated(180, 1, 0, 0);
        
        //sombrero.render(e.renderer.getPlayerModel(), 0.0625F);
        
        sombrero.render((float) Math.toRadians(((EntityPlayer)e.entity).rotationPitch), (float) Math.toRadians(((EntityPlayer)e.entity).rotationYawHead), 0.0625F);
        //MODEL_HAT.render(((EntitySheep)e.entity).rotationPitch,
                //((EntitySheep)e.entity).rotationYawHead, .0625f);
        GL11.glPopMatrix();
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
