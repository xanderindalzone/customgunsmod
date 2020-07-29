package com.xanderindalzone.customgunsmod.capabilities.entity;

public interface IGunActions 
{
	public void setAim(boolean is_aiming);
	public boolean isAiming();
	public void setFOV(double fov);
	public double getFOV();
	public void setSensitivity(double sensitivity);
	public double getSensitivity();
}
