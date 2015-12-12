package fr.ironcraft.nowel.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import fr.ironcraft.nowel.entity.fx.EntityNowelSnowShovelFX;

public class Particles
{
	
	@SideOnly(Side.CLIENT)
	public static EntityNowelSnowShovelFX spawnNowelSnowShovel(World world, double x, double y, double z, double speedX, double speedY, double speedZ)
	{
		EntityNowelSnowShovelFX entity = new EntityNowelSnowShovelFX(world, x, y, z, speedX, speedY, speedZ);
		
		Minecraft.getMinecraft().effectRenderer.addEffect(entity);
		
		return entity;
	}
}
