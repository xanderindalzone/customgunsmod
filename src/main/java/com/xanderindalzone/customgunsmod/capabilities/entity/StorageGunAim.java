package com.xanderindalzone.customgunsmod.capabilities.entity;

import net.minecraft.command.arguments.NBTTagArgument;
import net.minecraft.nbt.DoubleNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.nbt.NBTTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.text.NBTTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class StorageGunAim implements IStorage<IGunAim>
{
	@Override
	public INBT writeNBT(Capability<IGunAim> capability, IGunAim instance, Direction side) 
	{
		// TODO Auto-generated method stub
		return IntNBT.valueOf(instance.isAiming());
	}

	@Override
	public void readNBT(Capability<IGunAim> capability, IGunAim instance, Direction side, INBT nbt) 
	{
		instance.setAim(((IntNBT)nbt).getInt());
	}
}
