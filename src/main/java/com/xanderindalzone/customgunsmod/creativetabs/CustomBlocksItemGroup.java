package com.xanderindalzone.customgunsmod.creativetabs;

import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.init.InitBlocks;
import com.xanderindalzone.customgunsmod.init.SortedItemList;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

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
	
	@Override
	public void fill(NonNullList<ItemStack> items) {
		super.fill(items);
		items.sort(CustomGunsMod.instance.tabSorter);
	}
	

}
