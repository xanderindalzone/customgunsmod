package com.xanderindalzone.customgunsmod.events;

import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.init.Init;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = CustomGunsMod.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class ClientBlockEvents 
{
	
	/*
	 * Renders the Glass Blocks as transparent
	 */
	@SubscribeEvent
	public static void renderTransparentGlass(RenderGameOverlayEvent event)
	{
		//Renderiza este bloque con textura trasnparente
    	RenderTypeLookup.setRenderLayer(Init.ARMORED_GLASS_BLOCK, RenderType.getCutoutMipped());
	}

}
