package com.xanderindalzone.customgunsmod.creativetabs;

import com.xanderindalzone.customgunsmod.init.InitBlocks;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CustomBlocksItemGroup extends ItemGroup{

	public CustomBlocksItemGroup(String label) 
	{
		super(label);
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(InitBlocks.ARMORED_GLASS_BLOCK.get());
	}
	
	
	

}
