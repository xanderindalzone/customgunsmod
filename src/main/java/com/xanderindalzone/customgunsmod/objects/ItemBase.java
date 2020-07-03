package com.xanderindalzone.customgunsmod.objects;

import net.minecraft.item.Item;
import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.init.Init;

public class ItemBase extends Item
{

	public ItemBase(Properties properties) {
		super(properties);
		Init.ModItems.add(this);
	}

	
	
}
