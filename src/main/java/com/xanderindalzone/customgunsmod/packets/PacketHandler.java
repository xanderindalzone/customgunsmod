package com.xanderindalzone.customgunsmod.packets;

import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.packets.messages.ReloadGunMessage;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketHandler 
{

	private static int MESSAGE_ID = 0;

	private static final String PROTOCOL_VERSION = "1";
	
	public static SimpleChannel channel =
			NetworkRegistry.newSimpleChannel(
					new ResourceLocation(CustomGunsMod.MOD_ID, "cgmchannel"), //"main"
					() -> PROTOCOL_VERSION,
					PROTOCOL_VERSION::equals,
					PROTOCOL_VERSION::equals
	);
	
	public static void registerPackets() {
		int id = 0;
		
		channel.registerMessage(id++, ReloadGunMessage.class, ReloadGunMessage::encode, ReloadGunMessage::decode, ReloadGunMessage::handle); id++;
		
	}
	
}
