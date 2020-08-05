package com.xanderindalzone.customgunsmod.creativetabs;

import com.xanderindalzone.customgunsmod.init.InitBlocks;
import com.xanderindalzone.customgunsmod.init.InitItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

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
}
