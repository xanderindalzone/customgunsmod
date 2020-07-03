package com.xanderindalzone.customgunsmod.objects.items.ammo;

import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.entities.projectiles.PistolBulletEntity;
import com.xanderindalzone.customgunsmod.init.Init;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BulletBase extends ArrowItem
{

	public BulletBase(Properties builder) 
	{
		super(builder);
		Init.ModItems.add(this);
	}
	
	
	@Override
	public PistolBulletEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
		PistolBulletEntity bullet = new PistolBulletEntity(Init.PISTOL_BULLET_ENTITY, shooter, worldIn);
        return bullet;
	}

}
