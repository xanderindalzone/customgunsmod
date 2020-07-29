package com.xanderindalzone.customgunsmod.packets.messages;

import java.util.function.Supplier;

import com.xanderindalzone.customgunsmod.objects.items.guns.Gun;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

public class AimGunMessage 
{
	
	boolean isAiming;
	  
	  public AimGunMessage(boolean isAiming) {
		  this.isAiming=isAiming;
	  }
	  
	  public static void encode(AimGunMessage msg, PacketBuffer buffer) {//buffer.writeBoolean(msg.key_pressed);
		  buffer.writeBoolean(msg.isAiming);
	  }
	  
	  public static AimGunMessage decode(PacketBuffer buffer) {
	    return new AimGunMessage(buffer.readBoolean()); //Remember to read in the same order you wrote!
	  }
	  
	  public static void handle(AimGunMessage msg, Supplier<NetworkEvent.Context> ctx) {
	    if (ctx.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) { //Checks if the packet's direction is to the server
	      ctx.get().enqueueWork(() -> {
	    	  
	       		//Your code goes here
	    	  ServerPlayerEntity player = ctx.get().getSender(); // the client that sent this packet
	    	  
	    	  if(player.getHeldItemMainhand().getItem() instanceof Gun)
	    	  {
	    		  Gun gun = (Gun) player.getHeldItemMainhand().getItem();
	    		  gun.setAiming(player, player.getHeldItemMainhand(), msg.isAiming);
	    	  }
	    	  
	      });
	    }
	    ctx.get().setPacketHandled(true);
	  }
	
}
