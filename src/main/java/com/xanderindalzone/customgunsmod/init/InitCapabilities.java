package com.xanderindalzone.customgunsmod.init;

import com.xanderindalzone.customgunsmod.capabilities.entity.GunActions;
import com.xanderindalzone.customgunsmod.capabilities.entity.IGunActions;
import com.xanderindalzone.customgunsmod.capabilities.entity.StorageGunActions;

import net.minecraftforge.common.capabilities.CapabilityManager;

public class InitCapabilities 
{
	public static void registerCapabilities() 
	{
		CapabilityManager.INSTANCE.register(IGunActions.class, new StorageGunActions(), GunActions::new);
	}
}
