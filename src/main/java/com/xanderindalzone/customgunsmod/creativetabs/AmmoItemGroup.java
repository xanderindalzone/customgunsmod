package com.xanderindalzone.customgunsmod.creativetabs;

import com.xanderindalzone.customgunsmod.init.Init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class AmmoItemGroup extends ItemGroup
{

	public AmmoItemGroup(String label) 
	{
		super(label);
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(Init.BULLET_CAL_45);
	}

}
