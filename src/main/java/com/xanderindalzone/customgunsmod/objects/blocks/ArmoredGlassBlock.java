package com.xanderindalzone.customgunsmod.objects.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class ArmoredGlassBlock extends BlockBase
{

	public ArmoredGlassBlock(Properties properties) 
	{
		super(properties);
	}
	
	@Override
	public boolean canHarvestBlock(BlockState state, IBlockReader world, BlockPos pos, PlayerEntity player) {
		if(player.getHeldItemMainhand().getItem().equals(Items.DIAMOND_PICKAXE))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	


}
