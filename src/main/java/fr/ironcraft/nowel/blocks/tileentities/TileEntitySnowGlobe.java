package fr.ironcraft.nowel.blocks.tileentities;


import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import fr.ironcraft.nowel.utils.Particles;


public class TileEntitySnowGlobe extends TileEntity implements ITickable
{
	private boolean isSnowing;

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);

		isSnowing = compound.getBoolean("IsSnowing");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);

		compound.setBoolean("IsSnowing", isSnowing);
	}

	public boolean isSnowing()
	{
		return isSnowing;
	}

	public void update()
	{
		isSnowing = true;
		
		if (this.worldObj.getTotalWorldTime() % 2l == 0l)
		{
			if (isSnowing())
			{
				double x = this.pos.getX() + Math.random() * 0.6 + 0.2;
				double y = this.pos.getY() + 0.85;
				double z = this.pos.getZ() + Math.random() * 0.6 + 0.2;

				Particles.spawnNowelSnowShovel(worldObj, x, y, z, 0.0, -0.0f, 0.0);
			}
		}
	}
}
