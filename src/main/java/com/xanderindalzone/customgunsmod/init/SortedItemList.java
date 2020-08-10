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
				InitItems.BULLET_CAL_9.get(),
				InitItems.BULLET_CAL_5_56.get(),
				InitItems.BULLET_CAL_7_62.get(),
				InitItems.BULLET_CAL_338.get(),
				InitItems.BULLET_CAL_50.get(),
				InitItems.BULLET_CAL_12.get(),
				
				//GunParts
				InitItems.PROTOTYPE_CAL_45_PISTOL_BASIC.get(),
				InitItems.BARREL_CAL_45_LIGHT.get(), 
				InitItems.BARREL_CAL_45_MEDIUM.get(), 
				InitItems.BARREL_CAL_45_HEAVY.get(),
				InitItems.BARREL_CAL_9_LIGHT.get(), 
				InitItems.BARREL_CAL_9_MEDIUM.get(), 
				InitItems.BARREL_CAL_9_HEAVY.get(),
				InitItems.BARREL_CAL_5_56_LIGHT.get(), 
				InitItems.BARREL_CAL_5_56_MEDIUM.get(), 
				InitItems.BARREL_CAL_5_56_HEAVY.get(),
				InitItems.BARREL_CAL_7_62_LIGHT.get(), 
				InitItems.BARREL_CAL_7_62_MEDIUM.get(), 
				InitItems.BARREL_CAL_7_62_HEAVY.get(),
				InitItems.BARREL_CAL_338_LIGHT.get(), 
				InitItems.BARREL_CAL_338_MEDIUM.get(), 
				InitItems.BARREL_CAL_338_HEAVY.get(),
				InitItems.BARREL_CAL_50_LIGHT.get(), 
				InitItems.BARREL_CAL_50_MEDIUM.get(), 
				InitItems.BARREL_CAL_50_HEAVY.get(),
				InitItems.BARREL_CAL_12_LIGHT.get(), 
				InitItems.BARREL_CAL_12_MEDIUM.get(), 
				InitItems.BARREL_CAL_12_HEAVY.get(),
				InitItems.MAG_CAL_45_SMALL.get(),
				InitItems.MAG_CAL_45_BIG.get(),
				InitItems.MAG_CAL_45_DRUM.get(),
				InitItems.MAG_CAL_45_BOX.get(),
				InitItems.MAG_CAL_9_SMALL.get(),
				InitItems.MAG_CAL_9_BIG.get(),
				InitItems.MAG_CAL_9_DRUM.get(),
				InitItems.MAG_CAL_9_BOX.get(),
				InitItems.MAG_CAL_5_56_SMALL.get(),
				InitItems.MAG_CAL_5_56_BIG.get(),
				InitItems.MAG_CAL_5_56_DRUM.get(),
				InitItems.MAG_CAL_5_56_BOX.get(),
				InitItems.MAG_CAL_7_62_SMALL.get(),
				InitItems.MAG_CAL_7_62_BIG.get(),
				InitItems.MAG_CAL_7_62_DRUM.get(),
				InitItems.MAG_CAL_7_62_BOX.get(),
				InitItems.MAG_CAL_338_SMALL.get(),
				InitItems.MAG_CAL_338_BIG.get(),
				InitItems.MAG_CAL_338_DRUM.get(),
				InitItems.MAG_CAL_338_BOX.get(),
				InitItems.MAG_CAL_50_SMALL.get(),
				InitItems.MAG_CAL_50_BIG.get(),
				InitItems.MAG_CAL_50_DRUM.get(),
				InitItems.MAG_CAL_50_BOX.get(),
				InitItems.MAG_CAL_12_SMALL.get(),
				InitItems.MAG_CAL_12_BIG.get(),
				InitItems.MAG_CAL_12_DRUM.get(),
				InitItems.MAG_CAL_12_BOX.get(),
				InitItems.GUN_BODY_LIGHT.get(),
				InitItems.GUN_BODY_MEDIUM.get(),
				InitItems.GUN_BODY_HEAVY.get(),
				InitItems.PIPE_CAL_45.get(),
				InitItems.PIPE_CAL_9.get(),
				InitItems.PIPE_CAL_5_56.get(),
				InitItems.PIPE_CAL_7_62.get(),
				InitItems.PIPE_CAL_338.get(),
				InitItems.PIPE_CAL_50.get(),
				InitItems.PIPE_CAL_12.get(),
				InitItems.GUN_GRIP.get(),
				InitItems.GUN_BUTT.get(),
				
				//Blocks
				InitItems.ARMORED_GLASS_ITEM_BLOCK.get()
				);
	}
		
}
