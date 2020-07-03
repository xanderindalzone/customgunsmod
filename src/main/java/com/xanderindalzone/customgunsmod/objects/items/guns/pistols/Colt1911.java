package com.xanderindalzone.customgunsmod.objects.items.guns.pistols;

import com.xanderindalzone.customgunsmod.init.Init;
import com.xanderindalzone.customgunsmod.objects.items.guns.GunBase;

public class Colt1911 extends GunBase
{
	
	public static int gun_ammo_capacity=8;

	public Colt1911(Properties properties) {
		super(properties);
		
		this.gun_mag=gun_ammo_capacity;
		this.ammo_used=Init.BULLET_CAL_45;
		this.gun_damage=4;
		this.gun_accuracy=1;
		this.gun_recoil=1;
		this.gun_bullet_speed=4; 	//1 = 7 mtrs
		this.gun_firing_rate=4; //TICKS - 30 TICKS = 1 seg
		this.gun_reload_cooldown=20;
		this.gun_reload_cooldown_cock=30;
		
		this.gun_is_full_auto=false;
		this.zoom_fov=40;
	}

}
