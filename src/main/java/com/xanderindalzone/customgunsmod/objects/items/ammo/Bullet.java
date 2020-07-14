package com.xanderindalzone.customgunsmod.objects.items.ammo;

import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.entities.projectiles.PistolBulletEntity;
import com.xanderindalzone.customgunsmod.init.InitEntities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Bullet extends ArrowItem
{

	public Bullet(Properties builder) 
	{
		super(builder);
	}
	
	
	@Override
	public PistolBulletEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
		PistolBulletEntity bullet = new PistolBulletEntity(InitEntities.PISTOL_BULLET_ENTITY.get(), shooter, worldIn);
        return bullet;
	}

}
