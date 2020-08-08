package com.xanderindalzone.customgunsmod.events;

import com.xanderindalzone.customgunsmod.CustomGunsMod;

import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = CustomGunsMod.MOD_ID, bus = Bus.FORGE)
public class GunCraftingEvents 
{
	@SubscribeEvent
	public static void emptyGunMagWhenCrafter(PlayerEvent.ItemCraftedEvent event)
	{
	
	}
}
