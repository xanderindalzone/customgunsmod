package com.xanderindalzone.customgunsmod.capabilities.entity;

import com.xanderindalzone.customgunsmod.init.InitItems;
import com.xanderindalzone.customgunsmod.objects.items.guns.Gun;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class GunActions implements IGunActions
{

	private boolean is_aiming = false;
	private double fov = 90;
	private double previous_sensitivity = 0.6;
	
	@Override
	public void setAim(boolean is_aiming) 
	{
			this.is_aiming=is_aiming;
	}

	@Override
	public boolean isAiming() 
	{
		return this.is_aiming;
	}

	@Override
	public void setFOV(double fov) 
	{
		this.fov=fov;
	}

	@Override
	public double getFOV() 
	{
		return this.fov;
	}
	
	@Override
	public void setSensitivity(double sensitivity) 
	{
		this.previous_sensitivity=sensitivity;
	}

	@Override
	public double getSensitivity() 
	{
		return this.previous_sensitivity;
	}

}
