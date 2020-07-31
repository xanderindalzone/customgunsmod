package com.xanderindalzone.customgunsmod.capabilities.entity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class StorageGunActions implements IStorage<IGunActions>
{

	@Override
	public INBT writeNBT(Capability<IGunActions> capability, IGunActions instance, Direction side) 
	{
		CompoundNBT tag = new CompoundNBT();
		
		tag.putBoolean("is_aiming", instance.isAiming());
        tag.putDouble("fov", instance.getFOV());
        tag.putDouble("sensitivity", instance.getSensitivity());

		return tag;
	}

	
	
	@Override
	public void readNBT(Capability<IGunActions> capability, IGunActions instance, Direction side, INBT nbt) 
	{
		CompoundNBT tag = (CompoundNBT) nbt;

		instance.setAim(tag.getBoolean("is_aiming"));
		instance.setFOV(tag.getDouble("fov"));
		instance.setSensitivity(tag.getDouble("sensitivity"));

	}

}
