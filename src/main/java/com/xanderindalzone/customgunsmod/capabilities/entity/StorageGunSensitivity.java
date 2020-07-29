package com.xanderindalzone.customgunsmod.capabilities.entity;

import net.minecraft.nbt.DoubleNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class StorageGunSensitivity implements IStorage<IGunSensitivity>
{

	@Override
	public INBT writeNBT(Capability<IGunSensitivity> capability, IGunSensitivity instance, Direction side) 
	{
		return DoubleNBT.valueOf(instance.getSensitivity());
	}

	@Override
	public void readNBT(Capability<IGunSensitivity> capability, IGunSensitivity instance, Direction side, INBT nbt) 
	{
		instance.setSensitivity(((DoubleNBT)nbt).getDouble());
	}

}
