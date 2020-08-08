package com.xanderindalzone.customgunsmod.creativetabs;

import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.init.InitItems;
import com.xanderindalzone.customgunsmod.init.SortedItemList;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class GunsItemGroup extends ItemGroup
{

	public GunsItemGroup(String label) 
	{
		super(label);
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(InitItems.PISTOL_COLT_1911.get());	//Init.PISTOL_COLT_1911 OLD
	}

	@Override
	public void fill(NonNullList<ItemStack> items) {
		super.fill(items);
		items.sort(CustomGunsMod.instance.tabSorter);
	}
	
}
