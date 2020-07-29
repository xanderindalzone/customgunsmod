package com.xanderindalzone.customgunsmod.capabilities.entity;

public class GunFOV implements IGunFOV
{
	private double fov = 90;

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

}
