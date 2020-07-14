package com.xanderindalzone.customgunsmod.init;

import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.objects.items.ammo.Bullet;
import com.xanderindalzone.customgunsmod.objects.items.guns.Gun;
import com.xanderindalzone.customgunsmod.objects.items.guns.pistols.Colt1911;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class InitItems 
{
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<Item>(ForgeRegistries.ITEMS, CustomGunsMod.MOD_ID);
	//================================================================================================
	//================================================================================================
	//================================================================================================
	//================================================================================================
	
	
	/*=============*/
	/*ITEMS BULLETS*/
	/*=============*/
	public static final RegistryObject<Item> BULLET_CAL_45 = 
			ITEMS.register("bullet_cal_45", () -> new Item(new Item.Properties().group(CustomGunsMod.AMMO_TAB)));

	
	/*==========*/
	/*ITEMS GUNS*/
	/*==========*/
	public static final RegistryObject<Colt1911> PISTOL_COLT_1911 = 
			ITEMS.register("pistol_colt_1911", () -> new Colt1911(new Item.Properties().group(CustomGunsMod.GUNS_TAB)
					.maxStackSize(1)
					.maxDamage(Colt1911.gun_ammo_capacity+1)));	
	//================================================================================================
	//================================================================================================
	//================================================================================================
	//================================================================================================	
	
	
	/*===========*/
	/*BLOCK ITEMS*/
	/*===========*/
	public static final RegistryObject<BlockItem> ARMORED_GLASS_ITEM_BLOCK = 
			ITEMS.register(InitBlocks.ARMORED_GLASS_ITEM_BLOCK_ID, 
					() -> new BlockItem(InitBlocks.ARMORED_GLASS_BLOCK.get(), 
							new Item.Properties().group(CustomGunsMod.CUSTOM_BLOCKS_TAB)));
	
	
	
}
