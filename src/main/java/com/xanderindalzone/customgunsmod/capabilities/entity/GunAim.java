package com.xanderindalzone.customgunsmod.capabilities.entity;

public class GunAim implements IGunAim
{
	private int is_aiming = 0;

	@Override
	public void setAim(int is_aiming) 
	{
			this.is_aiming=is_aiming;
	}

	@Override
	public int isAiming() 
	{
		return 0;
	}


}
