package com.xanderindalzone.customgunsmod.creativetabs;

import com.xanderindalzone.customgunsmod.init.Init;

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
		return new ItemStack(Init.ARMORED_GLASS_BLOCK);
	}
	
	
	

}
