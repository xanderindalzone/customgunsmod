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

	
	
	
	/*===============*/
	/*ITEMS GUN PARTS*/
	/*===============*/
	
	//Grips
	//--------------------
	public static final RegistryObject<Item> GUN_GRIP = 
			ITEMS.register("gun_grip", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//Gun Butts
	//--------------------
	public static final RegistryObject<Item> GUN_BUTT = 
			ITEMS.register("gun_butt", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//Pipes
	//--------------------
	public static final RegistryObject<Item> PIPE_CAL_45 = 
			ITEMS.register("pipe_cal_45", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//Gun Bodies
	//--------------------
	public static final RegistryObject<Item> GUN_BODY_LIGHT = 
			ITEMS.register("gun_body_light", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	public static final RegistryObject<Item> GUN_BODY_MEDIUM = 
			ITEMS.register("gun_body_medium", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	public static final RegistryObject<Item> GUN_BODY_HEAVY = 
			ITEMS.register("gun_body_heavy", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//Barrels
	//--------------------
	public static final RegistryObject<Item> BARREL_CAL_45_LIGHT = 
			ITEMS.register("barrel_cal_45_light", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	public static final RegistryObject<Item> BARREL_CAL_45_MEDIUM = 
			ITEMS.register("barrel_cal_45_medium", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	public static final RegistryObject<Item> BARREL_CAL_45_HEAVY = 
			ITEMS.register("barrel_cal_45_heavy", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//Mags
	//--------------------
	public static final RegistryObject<Item> MAG_CAL_45_SMALL = 
			ITEMS.register("mag_cal_45_small", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	public static final RegistryObject<Item> MAG_CAL_45_BIG = 
			ITEMS.register("mag_cal_45_big", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	public static final RegistryObject<Item> MAG_CAL_45_DRUM = 
			ITEMS.register("mag_cal_45_drum", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	public static final RegistryObject<Item> MAG_CAL_45_BOX = 
			ITEMS.register("mag_cal_45_box", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	
	
	
	/*==========*/
	/*ITEMS GUNS*/
	/*==========*/
	
	//Guns
	//--------------------
	public static final RegistryObject<Colt1911> PISTOL_COLT_1911 = 
			ITEMS.register("pistol_colt_1911", () -> new Colt1911(new Item.Properties().group(CustomGunsMod.GUNS_TAB)
					.maxStackSize(1)
					.maxDamage(Colt1911.gun_ammo_capacity+1)));	
	//Prototype Guns
	//--------------------
	public static final RegistryObject<Item> PISTOL_CAL_45_PROTOTYPE_BASIC = 
			ITEMS.register("pistol_cal_45_prototype_basic", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	
	
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
