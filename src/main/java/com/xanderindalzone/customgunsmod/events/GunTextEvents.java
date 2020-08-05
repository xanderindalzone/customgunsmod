package com.xanderindalzone.customgunsmod.events;

import java.awt.event.ItemEvent;

import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.objects.items.guns.Gun;
import com.xanderindalzone.customgunsmod.objects.items.guns.GunFireTypes;
import com.xanderindalzone.customgunsmod.objects.items.guns.GunTypes;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = CustomGunsMod.MOD_ID, bus = Bus.FORGE)
public class GunTextEvents 
{

	
	
	
	/**
	 * Displays all gun stats when the mouse hovers on the gun item
	 * @param event
	 */
	@SubscribeEvent
	public static void setGunDescription(ItemTooltipEvent event)
	{
		if(event.getItemStack().getItem() instanceof Gun)
		{
			Gun gun = (Gun) event.getItemStack().getItem();
			event.getToolTip().clear();
			event.getToolTip().add(event.getItemStack().getDisplayName().applyTextStyle(TextFormatting.GOLD).applyTextStyle(TextFormatting.ITALIC).applyTextStyle(TextFormatting.UNDERLINE));
			event.getToolTip().add(new StringTextComponent(""));
			event.getToolTip().add(new StringTextComponent("======================").applyTextStyle(TextFormatting.DARK_PURPLE).applyTextStyle(TextFormatting.ITALIC));
			event.getToolTip().add(new StringTextComponent("Category: "+gunTypeToString(gun.gun_type)).applyTextStyle(TextFormatting.GRAY).applyTextStyle(TextFormatting.ITALIC));
			event.getToolTip().add(new StringTextComponent("Fire Type: "+gunFireTypeToString(gun, gun.gun_fire_type)).applyTextStyle(TextFormatting.GRAY).applyTextStyle(TextFormatting.ITALIC));
			event.getToolTip().add(new StringTextComponent("Firing Rate: "+1200/gun.gun_firing_rate+"rpm").applyTextStyle(TextFormatting.GRAY).applyTextStyle(TextFormatting.ITALIC));
			event.getToolTip().add(new StringTextComponent("Damage: -"+gun.gun_damage/2+" hearts").applyTextStyle(TextFormatting.GRAY).applyTextStyle(TextFormatting.ITALIC));
			event.getToolTip().add(new StringTextComponent("Accuracy: "+gun.gun_base_accuracy*100+"%").applyTextStyle(TextFormatting.GRAY).applyTextStyle(TextFormatting.ITALIC));
			event.getToolTip().add(new StringTextComponent("Recoil: "+gun.gun_recoil).applyTextStyle(TextFormatting.GRAY).applyTextStyle(TextFormatting.ITALIC));
			event.getToolTip().add(new StringTextComponent("======================").applyTextStyle(TextFormatting.DARK_PURPLE).applyTextStyle(TextFormatting.ITALIC));
		}
	}
	
	public static String gunTypeToString(GunTypes gun)
	{
		String text="";
		
		switch(gun)
		{
		case ASSAULT_RIFLE:
			text="Assault Rifle";
			break;
		case EXPLOSIVE_LAUNCHER:
			text="Explosive Launcher";
			break;
		case LMG:
			text="Light Machine Gun [LMG]";
			break;
		case MELEE:
			text="Melee Weapon";
			break;
		case PISTOL:
			text="Pistol";
			break;
		case SHOTGUN:
			text="Shotgun";
			break;
		case SMG:
			text="Small Machine Gun [SMG]";
			break;
		case SNIPER:
			text="Sniper";
			break;
		case TACTICAL_RIFLE:
			text="Tactical Rifle";
			break;
		case WONDER_WEAPON:
			text="Wonder Weapon";
			break;
		default:
			text="?";
			break;
		}
		
		return text;
	}
	public static String gunFireTypeToString(Gun gunO, GunFireTypes gun)
	{
		String text="";
		
		switch(gun)
		{
		case AUTOMATIC:
			text="Automatic";
			break;
		case BOLT_ACTION:
			text="Bolt Action";
			break;
		case BURST:
			text=gunO.gun_burst_shots+" Burst Shot";
			break;
		case SEMI_AUTOMATIC:
			text="Semi-Automatic";
			break;
		default:
			text="?";
			break;
		}
		
		return text;
	}
}
