package com.xanderindalzone.customgunsmod.creativetabs;

import com.xanderindalzone.customgunsmod.init.Init;

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
		return new ItemStack(Init.PISTOL_COLT_1911);
	}

}
