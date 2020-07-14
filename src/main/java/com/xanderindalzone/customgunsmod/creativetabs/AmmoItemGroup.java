package com.xanderindalzone.customgunsmod.creativetabs;

import com.xanderindalzone.customgunsmod.init.InitItems;

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
		return new ItemStack(InitItems.BULLET_CAL_45.get()); //Init.BULLET_CAL_45 OLD
	}

}
