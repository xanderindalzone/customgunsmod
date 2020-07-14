package com.xanderindalzone.customgunsmod.init;

import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.entities.projectiles.PistolBulletEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitEntities 
{
	public static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<EntityType<?>>(ForgeRegistries.ENTITIES, CustomGunsMod.MOD_ID);
	//================================================================================================
	//================================================================================================
	//================================================================================================
	//================================================================================================
	
	
	/*===========*/
	/*PROJECTILES*/
	/*===========*/	
	
	public static final String PISTOL_BULLET_ENTITY_ID = "bullet_cal_45_entity";
	public static final RegistryObject<EntityType<PistolBulletEntity>> PISTOL_BULLET_ENTITY = 
			ENTITIES.register(PISTOL_BULLET_ENTITY_ID, 
					() -> EntityType.Builder.<PistolBulletEntity>create(PistolBulletEntity::new, EntityClassification.MISC)
					.setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64)
					.setUpdateInterval(1)
					.size(1, 1)
					.build(new ResourceLocation(CustomGunsMod.MOD_ID, PISTOL_BULLET_ENTITY_ID).toString()));

}
