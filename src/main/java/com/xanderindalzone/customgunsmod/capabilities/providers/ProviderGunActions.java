package com.xanderindalzone.customgunsmod.capabilities.providers;

import com.xanderindalzone.customgunsmod.capabilities.entity.IGunActions;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class ProviderGunActions implements ICapabilitySerializable<INBT>
{

	@CapabilityInject(IGunActions.class)
	public static final Capability<IGunActions> GUN_ACTIONS_CAP = null;

	private LazyOptional<IGunActions> instance = LazyOptional.of(GUN_ACTIONS_CAP::getDefaultInstance);
	
	
	
	
	
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) 
	{
		return GUN_ACTIONS_CAP.orEmpty(cap, instance);
	}

	@Override
	public INBT serializeNBT() 
	{
		return GUN_ACTIONS_CAP.getStorage().writeNBT(GUN_ACTIONS_CAP, instance.orElseThrow(
				() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null);
	}

	@Override
	public void deserializeNBT(INBT nbt) 
	{
		GUN_ACTIONS_CAP.getStorage().readNBT(GUN_ACTIONS_CAP, instance.orElseThrow(
				() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null, nbt);
	}

}
