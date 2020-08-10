package com.xanderindalzone.customgunsmod.creativetabs;

import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.init.InitItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class GunPrototypesItemGroup extends ItemGroup
{

	public GunPrototypesItemGroup(String label) 
	{
		super(label);
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(InitItems.PROTOTYPE_CAL_45_PISTOL_BASIC.get());	//Init.PISTOL_COLT_1911 OLD
	}

	@Override
	public void fill(NonNullList<ItemStack> items) {
		super.fill(items);
		items.sort(CustomGunsMod.instance.tabSorter);
	}
	
}
