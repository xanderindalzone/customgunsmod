package com.xanderindalzone.customgunsmod.events.client;

import java.awt.event.KeyEvent;

import javax.swing.text.JTextComponent.KeyBinding;

import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.capabilities.providers.ProviderGunActions;
import com.xanderindalzone.customgunsmod.init.InitKeys;
import com.xanderindalzone.customgunsmod.objects.items.guns.Gun;
import com.xanderindalzone.customgunsmod.packets.PacketHandler;
import com.xanderindalzone.customgunsmod.packets.messages.AimGunMessage;
import com.xanderindalzone.customgunsmod.packets.messages.ReloadGunMessage;

import cpw.mods.modlauncher.api.IEnvironment.Keys;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = CustomGunsMod.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class ClientKeyEvents 
{
	
	/**
	 * Displays the Gun Ammo in the gun held by the player
	 * @param event
	 */
	@SubscribeEvent
	public static void displayGunStatus(RenderGameOverlayEvent.Text event) {
		PlayerEntity player = Minecraft.getInstance().player;
		int yd = event.getWindow().getScaledHeight();
		int xd = event.getWindow().getScaledWidth();
		int x=(int) (xd*0.01);
		int y=(int) (yd*0.65);
		int x2=(int) (xd*0.42);
		int y2=(int) (yd*0.7);
		if(Minecraft.getInstance().player.getHeldItemMainhand().getItem() instanceof Gun)
		{
			Gun gun = (Gun) player.getHeldItemMainhand().getItem();
			FontRenderer TextRenderer = Minecraft.getInstance().fontRenderer;
			String text = "Gun AMMO: ";
			String textAmmo = "["+(gun.gun_mag-player.getHeldItemMainhand().getDamage())+"/"+gun.gun_mag+"]";
			if(!player.isCreative()) 
			{
				if(!((gun.gun_mag-player.getHeldItemMainhand().getDamage())>0))
				{
					String text1="No AMMO!";
					String text2="Press "+InitKeys.KEY_RELOAD_GUN.getLocalizedName().toUpperCase()+" to reload!";
					TextRenderer.drawStringWithShadow(text1, x+10, y+20, 16730698);
					TextRenderer.drawStringWithShadow(text2, x+10, y+30, 16777215);		
				}
//				if(player.getCooldownTracker().hasCooldown(gun)) 
//				{
//					
//					String text3="Reloading!";
//					//System.out.println(text3);
//					TextRenderer.drawStringWithShadow(text3, x2+10, y2, 61256);
//				}
			}
			else 
			{
				textAmmo = "[oo/"+gun.gun_mag+"]";
			}
			TextRenderer.drawStringWithShadow(text, x+10, y, 16777215);
			TextRenderer.drawStringWithShadow(textAmmo, x+10, y+10, 16245549);
		}
	}
	
	
	@SubscribeEvent
	public static void AimGun(PlayerTickEvent event)
	{
		if(event.player==null) {return;}
		
		event.player.getCapability(ProviderGunActions.GUN_ACTIONS_CAP)
		.ifPresent(cap -> {
			
			if(Minecraft.getInstance().gameSettings.keyBindAttack.isKeyDown()&&event.player.getHeldItemMainhand().getItem() instanceof Gun)
			{
				Gun gun = (Gun) event.player.getHeldItemMainhand().getItem();
				
				if(!cap.isAiming()&&event.player.world.isRemote) {

					cap.setFOV(Minecraft.getInstance().gameSettings.fov);
					cap.setSensitivity(Minecraft.getInstance().gameSettings.mouseSensitivity);
					cap.setAim(true);
					
					Minecraft.getInstance().gameSettings.fov=gun.zoom_fov;
					Minecraft.getInstance().gameSettings.mouseSensitivity=gun.aim_sensitivity;
					
					PacketHandler.channel.sendToServer(new AimGunMessage(true));
				}
			}
			else
			{
				if((cap.isAiming()&&event.player.world.isRemote)||(event.player.world.isRemote&&!(event.player.getHeldItemMainhand().getItem() instanceof Gun))) 
				{
					cap.setAim(false);
					Minecraft.getInstance().gameSettings.fov=cap.getFOV();
					Minecraft.getInstance().gameSettings.mouseSensitivity=cap.getSensitivity();
					
					if(event.player.getHeldItemMainhand().getItem() instanceof Gun) {
						PacketHandler.channel.sendToServer(new AimGunMessage(false));
					}
				}
				if(!cap.isAiming()&&event.player.world.isRemote) 
				{
					if(event.player.getHeldItemMainhand().getItem() instanceof Gun) {
						PacketHandler.channel.sendToServer(new AimGunMessage(false));
					}
				}
			}
			
		});
	
	}
	
	
//====================================================================
//CLIENT EVENTS TO SERVER
//====================================================================	
	
	@SubscribeEvent
	public static void ReloadGunPacketToServer(InputEvent event) 
	{
		if(InitKeys.KEY_RELOAD_GUN.isPressed())
		{
			//SEND PACKET TO SERVER
			PacketHandler.channel.sendToServer(new ReloadGunMessage());
		}
	}
	
	
	
	
}
