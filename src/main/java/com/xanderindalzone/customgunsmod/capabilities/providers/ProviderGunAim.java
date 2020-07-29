package com.xanderindalzone.customgunsmod.capabilities.providers;

import com.xanderindalzone.customgunsmod.capabilities.entity.IGunAim;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class ProviderGunAim implements ICapabilitySerializable<INBT>
{
	
	@CapabilityInject(IGunAim.class)
	 public static final Capability<IGunAim> GUN_AIM_CAP = null;

	private LazyOptional<IGunAim> instance = LazyOptional.of(GUN_AIM_CAP::getDefaultInstance);

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) 
	{
		 return GUN_AIM_CAP.orEmpty(cap, instance);
	}

	@Override
	public INBT serializeNBT() 
	{
		return GUN_AIM_CAP.getStorage().writeNBT(GUN_AIM_CAP, instance.orElseThrow(
				() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null);
	}

	@Override
	public void deserializeNBT(INBT nbt) 
	{
		GUN_AIM_CAP.getStorage().readNBT(GUN_AIM_CAP, instance.orElseThrow(
				() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null, nbt);
	}

}
