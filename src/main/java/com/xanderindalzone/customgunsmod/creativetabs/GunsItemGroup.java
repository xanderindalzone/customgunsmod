package com.xanderindalzone.customgunsmod.creativetabs;

import com.xanderindalzone.customgunsmod.init.InitItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

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

}
