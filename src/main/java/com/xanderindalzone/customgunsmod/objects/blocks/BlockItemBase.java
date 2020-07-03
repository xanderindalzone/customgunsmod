package com.xanderindalzone.customgunsmod.objects.blocks;

import com.xanderindalzone.customgunsmod.init.Init;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemBase extends BlockItem{

	public BlockItemBase(Block blockIn, Properties builder) 
	{
		super(blockIn, builder);
		Init.ModBlockItems.add(this);
	}

}
