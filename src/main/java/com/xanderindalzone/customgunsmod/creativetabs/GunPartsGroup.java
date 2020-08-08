package com.xanderindalzone.customgunsmod.creativetabs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.init.InitBlocks;
import com.xanderindalzone.customgunsmod.init.InitItems;
import com.xanderindalzone.customgunsmod.init.SortedItemList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class GunPartsGroup extends ItemGroup
{

	public GunPartsGroup(String label) 
	{
		super(label);
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(InitItems.BARREL_CAL_45_LIGHT.get());
	}
	
	@Override
	public void fill(NonNullList<ItemStack> items) {
		super.fill(items);
		items.sort(CustomGunsMod.instance.tabSorter);
	}
	
	
}
