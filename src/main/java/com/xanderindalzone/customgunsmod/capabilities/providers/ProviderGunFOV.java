package com.xanderindalzone.customgunsmod.capabilities.providers;


import com.xanderindalzone.customgunsmod.capabilities.entity.IGunFOV;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class ProviderGunFOV implements ICapabilitySerializable<INBT>
{
	
	@CapabilityInject(IGunFOV.class)
	 public static final Capability<IGunFOV> GUN_FOV_CAP = null;

	private LazyOptional<IGunFOV> instance = LazyOptional.of(GUN_FOV_CAP::getDefaultInstance);

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) 
	{
		 return GUN_FOV_CAP.orEmpty(cap, instance);
	}

	@Override
	public INBT serializeNBT() 
	{
		return GUN_FOV_CAP.getStorage().writeNBT(GUN_FOV_CAP, instance.orElseThrow(
				() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null);
	}

	@Override
	public void deserializeNBT(INBT nbt) 
	{
		GUN_FOV_CAP.getStorage().readNBT(GUN_FOV_CAP, instance.orElseThrow(
				() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null, nbt);
	}
}
