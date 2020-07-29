package com.xanderindalzone.customgunsmod.packets.messages;

import java.util.function.Supplier;

import com.xanderindalzone.customgunsmod.events.client.ClientGunEvents;
import com.xanderindalzone.customgunsmod.objects.items.guns.Gun;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

//MESSAGE TO CLIENT
public class HitMarkerMessage 
{
	boolean kill;
	
	public HitMarkerMessage(boolean kill) 
	{
		
	}
	  
	  public static void encode(HitMarkerMessage msg, PacketBuffer buffer) 
	  {
		  buffer.writeBoolean(msg.kill);
	  }
	  
	  public static HitMarkerMessage decode(PacketBuffer buffer) {
	    return new HitMarkerMessage(buffer.readBoolean()); //Remember to read in the same order you wrote!
	  }
	  
	  public static void handle(HitMarkerMessage msg, Supplier<NetworkEvent.Context> ctx) {
		  System.out.println("DEBUG1 MESSAGE");
	    if (ctx.get().getDirection() == NetworkDirection.PLAY_TO_CLIENT) { //Checks if the packet's direction is to the client
	    	System.out.println("DEBUG2 MESSAGE");
	    	ctx.get().enqueueWork(() -> {
	    	  
	       		//Your code goes here
	    	  ClientGunEvents.DisplayHitMarker(msg.kill);
	    	  
	      });
	    }
	    ctx.get().setPacketHandled(true);
	  }
}
