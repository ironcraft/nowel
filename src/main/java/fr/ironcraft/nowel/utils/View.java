package fr.ironcraft.nowel.utils;

import net.minecraft.entity.Entity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class View
{
	public static MovingObjectPosition rayTrace(Entity entity, double blockReachDistance)
    {
        Vec3 vec3 = getPositionEyes(entity);
        Vec3 vec31 = entity.getLook(1.0f);
        Vec3 vec32 = vec3.addVector(vec31.xCoord * blockReachDistance, vec31.yCoord * blockReachDistance, vec31.zCoord * blockReachDistance);
        return entity.worldObj.rayTraceBlocks(vec3, vec32, false, false, true);
    }

	public static Vec3 getPositionEyes(Entity entity)
	{
		return new Vec3(entity.posX, entity.posY + entity.getEyeHeight(), entity.posZ);
	}
}
