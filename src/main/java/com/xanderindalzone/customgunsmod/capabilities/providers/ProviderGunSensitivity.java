package com.xanderindalzone.customgunsmod.capabilities.providers;


import com.xanderindalzone.customgunsmod.capabilities.entity.IGunSensitivity;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class ProviderGunSensitivity implements ICapabilitySerializable<INBT>
{
	
	@CapabilityInject(IGunSensitivity.class)
	 public static final Capability<IGunSensitivity> GUN_SENSITIVITY_CAP = null;

	private LazyOptional<IGunSensitivity> instance = LazyOptional.of(GUN_SENSITIVITY_CAP::getDefaultInstance);

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) 
	{
		 return GUN_SENSITIVITY_CAP.orEmpty(cap, instance);
	}

	@Override
	public INBT serializeNBT() 
	{
		return GUN_SENSITIVITY_CAP.getStorage().writeNBT(GUN_SENSITIVITY_CAP, instance.orElseThrow(
				() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null);
	}

	@Override
	public void deserializeNBT(INBT nbt) 
	{
		GUN_SENSITIVITY_CAP.getStorage().readNBT(GUN_SENSITIVITY_CAP, instance.orElseThrow(
				() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null, nbt);
	}
}
