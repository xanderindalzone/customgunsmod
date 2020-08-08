package com.xanderindalzone.customgunsmod.creativetabs;

import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.init.InitItems;
import com.xanderindalzone.customgunsmod.init.SortedItemList;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class AmmoItemGroup extends ItemGroup
{

	public AmmoItemGroup(String label) 
	{
		super(label);
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(InitItems.BULLET_CAL_45.get()); //Init.BULLET_CAL_45 OLD
	}

	@Override
	public void fill(NonNullList<ItemStack> items) {
		super.fill(items);
		items.sort(CustomGunsMod.instance.tabSorter);
	}
	
}
