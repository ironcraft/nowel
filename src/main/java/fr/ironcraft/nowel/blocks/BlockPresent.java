package fr.ironcraft.nowel.blocks;


import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;


public class BlockPresent extends BlockContainer
{
	public BlockPresent()
	{
		super(Material.ice);
		setCreativeTab(CreativeTabs.tabDecorations);
	}

	@Override
	public int getRenderType()
	{
		return 3;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityPresent();
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (worldIn.isRemote)
		{
			return true;
		}

		boolean somethingHappened = false;

		TileEntity tileEntity = worldIn.getTileEntity(pos);

		if (tileEntity != null && tileEntity instanceof TileEntityPresent)
		{
			TileEntityPresent present = (TileEntityPresent) tileEntity;
			somethingHappened = present.onPlayerClicked(playerIn, pos, state, side);
		}

		return somethingHappened;
	}
}
