package com.xanderindalzone.customgunsmod.init;

import com.xanderindalzone.customgunsmod.capabilities.entity.GunAim;
import com.xanderindalzone.customgunsmod.capabilities.entity.GunFOV;
import com.xanderindalzone.customgunsmod.capabilities.entity.GunSensitivity;
import com.xanderindalzone.customgunsmod.capabilities.entity.IGunAim;
import com.xanderindalzone.customgunsmod.capabilities.entity.IGunFOV;
import com.xanderindalzone.customgunsmod.capabilities.entity.IGunSensitivity;
import com.xanderindalzone.customgunsmod.capabilities.entity.StorageGunAim;
import com.xanderindalzone.customgunsmod.capabilities.entity.StorageGunFOV;
import com.xanderindalzone.customgunsmod.capabilities.entity.StorageGunSensitivity;

import net.minecraftforge.common.capabilities.CapabilityManager;

public class InitCapabilities 
{
	public static void registerCapabilities() 
	{
		CapabilityManager.INSTANCE.register(IGunAim.class, new StorageGunAim(), GunAim::new);
		CapabilityManager.INSTANCE.register(IGunFOV.class, new StorageGunFOV(), GunFOV::new);
		CapabilityManager.INSTANCE.register(IGunSensitivity.class, new StorageGunSensitivity(), GunSensitivity::new);
	}
}
