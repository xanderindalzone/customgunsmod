package com.xanderindalzone.customgunsmod.init;

import com.xanderindalzone.customgunsmod.CustomGunsMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;



public class InitSounds 
{
	
	public static final DeferredRegister<SoundEvent> SOUNDS = 
			new DeferredRegister<SoundEvent>(ForgeRegistries.SOUND_EVENTS, CustomGunsMod.MOD_ID);
	//================================================================================================
	//================================================================================================
	//================================================================================================
	//================================================================================================
	
	
	
	public static final RegistryObject<SoundEvent> SOUND_no_ammo_click =
			SOUNDS.register("no_ammo_click",
					() -> new SoundEvent(new ResourceLocation(CustomGunsMod.MOD_ID, "no_ammo_click")));
	public static final RegistryObject<SoundEvent> SOUND_hit_marker =
			SOUNDS.register("hit_marker",
					() -> new SoundEvent(new ResourceLocation(CustomGunsMod.MOD_ID, "hit_marker")));
	public static final RegistryObject<SoundEvent> SOUND_kill =
			SOUNDS.register("kill",
					() -> new SoundEvent(new ResourceLocation(CustomGunsMod.MOD_ID, "kill")));
	public static final RegistryObject<SoundEvent> SOUND_bullet_ground_impact =
			SOUNDS.register("bullet_ground_impact",
					() -> new SoundEvent(new ResourceLocation(CustomGunsMod.MOD_ID, "bullet_ground_impact")));
	public static final RegistryObject<SoundEvent> SOUND_bullet_glass_impact =
			SOUNDS.register("bullet_glass_impact",
					() -> new SoundEvent(new ResourceLocation(CustomGunsMod.MOD_ID, "bullet_glass_impact")));
	
	
	
	/*================*/
	/*COLT 1911 SOUNDS*/
	/*================*/
	public static final RegistryObject<SoundEvent> SOUND_shot_Colt1911 =
			SOUNDS.register("shot_colt1911",
					() -> new SoundEvent(new ResourceLocation(CustomGunsMod.MOD_ID, "shot_colt1911")));
	
	public static final RegistryObject<SoundEvent> SOUND_reload_Colt1911 =
			SOUNDS.register("reload_colt1911",
					() -> new SoundEvent(new ResourceLocation(CustomGunsMod.MOD_ID, "reload_colt1911")));

	public static final RegistryObject<SoundEvent> SOUND_reload_Colt1911_cock =
			SOUNDS.register("reload_colt1911_cock",
					() -> new SoundEvent(new ResourceLocation(CustomGunsMod.MOD_ID, "reload_colt1911_cock")));


	
}
