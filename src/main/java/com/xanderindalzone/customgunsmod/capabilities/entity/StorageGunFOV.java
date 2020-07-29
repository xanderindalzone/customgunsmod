package com.xanderindalzone.customgunsmod.capabilities.entity;

import net.minecraft.nbt.DoubleNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class StorageGunFOV implements IStorage<IGunFOV>
{

	@Override
	public INBT writeNBT(Capability<IGunFOV> capability, IGunFOV instance, Direction side) 
	{
		return DoubleNBT.valueOf(instance.getFOV());
	}

	@Override
	public void readNBT(Capability<IGunFOV> capability, IGunFOV instance, Direction side, INBT nbt) 
	{
		instance.setFOV(((DoubleNBT)nbt).getDouble());
	}

}
