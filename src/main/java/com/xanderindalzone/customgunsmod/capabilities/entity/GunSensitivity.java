package com.xanderindalzone.customgunsmod.capabilities.entity;

public class GunSensitivity implements IGunSensitivity
{
	private double previous_sensitivity = 90;
	
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
