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
	//TODO
	public static final RegistryObject<Item> BULLET_CAL_9 = 
			ITEMS.register("bullet_cal_9", () -> new Item(new Item.Properties().group(CustomGunsMod.AMMO_TAB)));
	//TODO
	public static final RegistryObject<Item> BULLET_CAL_5_56 = 
			ITEMS.register("bullet_cal_5_56", () -> new Item(new Item.Properties().group(CustomGunsMod.AMMO_TAB)));
	//TODO
	public static final RegistryObject<Item> BULLET_CAL_7_62 = 
			ITEMS.register("bullet_cal_7_62", () -> new Item(new Item.Properties().group(CustomGunsMod.AMMO_TAB)));
	//TODO
	public static final RegistryObject<Item> BULLET_CAL_338 = 
			ITEMS.register("bullet_cal_338", () -> new Item(new Item.Properties().group(CustomGunsMod.AMMO_TAB)));
	//TODO
	public static final RegistryObject<Item> BULLET_CAL_50 = 
			ITEMS.register("bullet_cal_50", () -> new Item(new Item.Properties().group(CustomGunsMod.AMMO_TAB)));
	//TODO
	public static final RegistryObject<Item> BULLET_CAL_12 = 
			ITEMS.register("bullet_cal_12", () -> new Item(new Item.Properties().group(CustomGunsMod.AMMO_TAB)));
	
	
	
	/*===============*/
	/*ITEMS GUN PARTS*/
	/*===============*/
//==============================================================================================================
	//--------------------
	//Barrels
	//--------------------
	public static final RegistryObject<Item> BARREL_CAL_45_LIGHT = 
			ITEMS.register("barrel_cal_45_light", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	public static final RegistryObject<Item> BARREL_CAL_45_MEDIUM = 
			ITEMS.register("barrel_cal_45_medium", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	public static final RegistryObject<Item> BARREL_CAL_45_HEAVY = 
			ITEMS.register("barrel_cal_45_heavy", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> BARREL_CAL_9_LIGHT = 
			ITEMS.register("barrel_cal_9_light", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> BARREL_CAL_9_MEDIUM = 
			ITEMS.register("barrel_cal_9_medium", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> BARREL_CAL_9_HEAVY = 
			ITEMS.register("barrel_cal_9_heavy", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> BARREL_CAL_5_56_LIGHT = 
			ITEMS.register("barrel_cal_5_56_light", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> BARREL_CAL_5_56_MEDIUM = 
			ITEMS.register("barrel_cal_5_56_medium", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> BARREL_CAL_5_56_HEAVY = 
			ITEMS.register("barrel_cal_5_56_heavy", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> BARREL_CAL_7_62_LIGHT = 
			ITEMS.register("barrel_cal_7_62_light", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> BARREL_CAL_7_62_MEDIUM = 
			ITEMS.register("barrel_cal_7_62_medium", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> BARREL_CAL_7_62_HEAVY = 
			ITEMS.register("barrel_cal_7_62_heavy", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> BARREL_CAL_338_LIGHT = 
			ITEMS.register("barrel_cal_338_light", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> BARREL_CAL_338_MEDIUM = 
			ITEMS.register("barrel_cal_338_medium", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> BARREL_CAL_338_HEAVY = 
			ITEMS.register("barrel_cal_338_heavy", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> BARREL_CAL_50_LIGHT = 
			ITEMS.register("barrel_cal_50_light", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> BARREL_CAL_50_MEDIUM = 
			ITEMS.register("barrel_cal_50_medium", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> BARREL_CAL_50_HEAVY = 
			ITEMS.register("barrel_cal_50_heavy", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> BARREL_CAL_12_LIGHT = 
			ITEMS.register("barrel_cal_12_light", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> BARREL_CAL_12_MEDIUM = 
			ITEMS.register("barrel_cal_12_medium", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> BARREL_CAL_12_HEAVY = 
			ITEMS.register("barrel_cal_12_heavy", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
//==============================================================================================================
	//--------------------
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
	//TODO
	public static final RegistryObject<Item> MAG_CAL_9_SMALL = 
			ITEMS.register("mag_cal_9_small", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_9_BIG = 
			ITEMS.register("mag_cal_9_big", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_9_DRUM = 
			ITEMS.register("mag_cal_9_drum", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_9_BOX = 
			ITEMS.register("mag_cal_9_box", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_5_56_SMALL = 
			ITEMS.register("mag_cal_5_56_small", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_5_56_BIG = 
			ITEMS.register("mag_cal_5_56_big", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_5_56_DRUM = 
			ITEMS.register("mag_cal_5_56_drum", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_5_56_BOX = 
			ITEMS.register("mag_cal_5_56_box", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_7_62_SMALL = 
			ITEMS.register("mag_cal_7_62_small", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_7_62_BIG = 
			ITEMS.register("mag_cal_7_62_big", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_7_62_DRUM = 
			ITEMS.register("mag_cal_7_62_drum", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_7_62_BOX = 
			ITEMS.register("mag_cal_7_62_box", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_338_SMALL = 
			ITEMS.register("mag_cal_338_small", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_338_BIG = 
			ITEMS.register("mag_cal_338_big", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_338_DRUM = 
			ITEMS.register("mag_cal_338_drum", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_338_BOX = 
			ITEMS.register("mag_cal_338_box", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_50_SMALL = 
			ITEMS.register("mag_cal_50_small", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_50_BIG = 
			ITEMS.register("mag_cal_50_big", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_50_DRUM = 
			ITEMS.register("mag_cal_50_drum", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_50_BOX = 
			ITEMS.register("mag_cal_50_box", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_12_SMALL = 
			ITEMS.register("mag_cal_12_small", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_12_BIG = 
			ITEMS.register("mag_cal_12_big", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_12_DRUM = 
			ITEMS.register("mag_cal_12_drum", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	//TODO
	public static final RegistryObject<Item> MAG_CAL_12_BOX = 
			ITEMS.register("mag_cal_12_box", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
//==============================================================================================================
	//--------------------
	//Pipes
	//--------------------
	public static final RegistryObject<Item> PIPE_CAL_45 = 
			ITEMS.register("pipe_cal_45", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	public static final RegistryObject<Item> PIPE_CAL_9 = 
			ITEMS.register("pipe_cal_9", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	public static final RegistryObject<Item> PIPE_CAL_5_56 = 
			ITEMS.register("pipe_cal_5_56", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	public static final RegistryObject<Item> PIPE_CAL_7_62 = 
			ITEMS.register("pipe_cal_7_62", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	public static final RegistryObject<Item> PIPE_CAL_338 = 
			ITEMS.register("pipe_cal_338", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	public static final RegistryObject<Item> PIPE_CAL_50 = 
			ITEMS.register("pipe_cal_50", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	public static final RegistryObject<Item> PIPE_CAL_12 = 
			ITEMS.register("pipe_cal_12", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
//==============================================================================================================
	//--------------------
	//Gun Bodies
	//--------------------
	public static final RegistryObject<Item> GUN_BODY_LIGHT = 
			ITEMS.register("gun_body_light", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	public static final RegistryObject<Item> GUN_BODY_MEDIUM = 
			ITEMS.register("gun_body_medium", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
	public static final RegistryObject<Item> GUN_BODY_HEAVY = 
			ITEMS.register("gun_body_heavy", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
//==============================================================================================================
	//--------------------
	//Grips
	//--------------------
	public static final RegistryObject<Item> GUN_GRIP = 
			ITEMS.register("gun_grip", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
//==============================================================================================================
	//--------------------
	//Gun Butts
	//--------------------
	public static final RegistryObject<Item> GUN_BUTT = 
			ITEMS.register("gun_butt", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PARTS_TAB)));
//==============================================================================================================	
	
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
	public static final RegistryObject<Item> PROTOTYPE_CAL_45_PISTOL_BASIC = 
			ITEMS.register("prototype_cal_45_pistol_basic", () -> new Item(new Item.Properties().group(CustomGunsMod.GUN_PROTOTYPES_TAB)));
	
	
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
