package com.xanderindalzone.customgunsmod.events;

import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.objects.items.guns.Gun;

import net.minecraft.util.text.event.ClickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = CustomGunsMod.MOD_ID, bus = Bus.FORGE)
public class CommonGunEvents 
{
	
	@SubscribeEvent
	public static void preventGunBlockBreak(PlayerInteractEvent.LeftClickBlock event)
	{
		if(event.getPlayer().getHeldItemMainhand().getItem() instanceof Gun)
		{
			
		}
	}

}
