package com.xanderindalzone.customgunsmod.renderers;


import java.rmi.registry.RegistryHandler;

import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.entities.projectiles.PistolBulletEntity;
import com.xanderindalzone.customgunsmod.init.InitEntities;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityType.Builder;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryManager;

public class BulletRender extends ArrowRenderer<PistolBulletEntity>{
	
    public final static ResourceLocation BULLET_TEXTURE_PATH = 
    		new ResourceLocation(CustomGunsMod.MOD_ID, "textures/entity/arrows/"+InitEntities.PISTOL_BULLET_ENTITY_ID+".png");

    public BulletRender(EntityRendererManager renderManagerIn) 
    {
        super(renderManagerIn);

    }
    
    @Override
    public ResourceLocation getEntityTexture(PistolBulletEntity entity) 
    {
        return BULLET_TEXTURE_PATH;
    }
}
