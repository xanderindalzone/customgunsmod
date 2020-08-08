package com.xanderindalzone.customgunsmod.init;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Ordering;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;

public class SortedItemList 
{
	
	public static List<Item> sortedList;
	
	public static void initSortedList()
	{
		sortedList = Arrays.asList(
				//Guns
				InitItems.PISTOL_COLT_1911.get(),
				
				//Bullets
				InitItems.BULLET_CAL_45.get(),
				
				//GunParts
				InitItems.PISTOL_CAL_45_PROTOTYPE_BASIC.get(),
				InitItems.BARREL_CAL_45_LIGHT.get(), 
				InitItems.BARREL_CAL_45_MEDIUM.get(), 
				InitItems.BARREL_CAL_45_HEAVY.get(),
				InitItems.MAG_CAL_45_SMALL.get(),
				InitItems.MAG_CAL_45_BIG.get(),
				InitItems.MAG_CAL_45_DRUM.get(),
				InitItems.MAG_CAL_45_BOX.get(),
				InitItems.GUN_BODY_LIGHT.get(),
				InitItems.GUN_BODY_MEDIUM.get(),
				InitItems.GUN_BODY_HEAVY.get(),
				InitItems.PIPE_CAL_45.get(),
				InitItems.GUN_GRIP.get(),
				InitItems.GUN_BUTT.get(),
				
				//Blocks
				InitItems.ARMORED_GLASS_ITEM_BLOCK.get()
				);
	}
		
}
