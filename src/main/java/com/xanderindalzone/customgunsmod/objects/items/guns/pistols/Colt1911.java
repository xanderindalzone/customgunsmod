package com.xanderindalzone.customgunsmod.objects.items.guns.pistols;

import com.xanderindalzone.customgunsmod.init.InitItems;
import com.xanderindalzone.customgunsmod.objects.items.guns.Gun;
import com.xanderindalzone.customgunsmod.objects.items.guns.GunCaliberTypes;
import com.xanderindalzone.customgunsmod.objects.items.guns.GunFireTypes;
import com.xanderindalzone.customgunsmod.objects.items.guns.GunTypes;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class Colt1911 extends Gun
{
	
	public static int gun_ammo_capacity=8;

	public Colt1911(Properties properties) {
		super(properties);
		
		gun_type=GunTypes.PISTOL;
		gun_fire_type=GunFireTypes.SEMI_AUTOMATIC;
		gun_caliber_type=GunCaliberTypes.CAL_45;
		this.gun_mag=gun_ammo_capacity;
		this.ammo_used=InitItems.BULLET_CAL_45.get(); //Init.BULLET_CAL_45 OLD
		this.gun_damage=4;
		this.gun_base_accuracy=0.9F;	//1 is max accuracy, shot will go directly where you are aiming
		this.gun_recoil=1;
		this.gun_bullet_speed=4; 	//1 = 7 mtrs
		this.gun_firing_rate=4; //TICKS - 20 TICKS = 1 seg
		this.gun_reload_cooldown=20;
		this.gun_reload_cooldown_cock=30;
		
//		this.gun_is_full_auto=false;
		this.zoom_fov=60;
		this.aim_sensitivity=0.3D;	//normal sensitivity is 0.5D
	}

}
