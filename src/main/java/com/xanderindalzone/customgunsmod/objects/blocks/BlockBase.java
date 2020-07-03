package com.xanderindalzone.customgunsmod.objects.blocks;


import com.xanderindalzone.customgunsmod.init.Init;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class BlockBase extends Block
{

	public BlockBase(Properties properties) 
	{
		super(properties);
		Init.ModBlocks.add(this);
	}


	
}
