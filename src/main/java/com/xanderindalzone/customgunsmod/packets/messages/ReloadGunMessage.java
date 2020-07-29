package com.xanderindalzone.customgunsmod.packets.messages;


import java.util.function.Supplier;

import com.xanderindalzone.customgunsmod.objects.items.guns.Gun;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;


//MESSAGE TO SERVER
public class ReloadGunMessage
{
	  
	  public ReloadGunMessage() {}
	  
	  public static void encode(ReloadGunMessage msg, PacketBuffer buffer) {//buffer.writeBoolean(msg.key_pressed);
	  }
	  
	  public static ReloadGunMessage decode(PacketBuffer buffer) {
	    return new ReloadGunMessage(); //Remember to read in the same order you wrote!
	  }
	  
	  public static void handle(ReloadGunMessage msg, Supplier<NetworkEvent.Context> ctx) {
	    if (ctx.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) { //Checks if the packet's direction is to the server
	      ctx.get().enqueueWork(() -> {
	    	  
	       		//Your code goes here
	    	  ServerPlayerEntity player = ctx.get().getSender(); // the client that sent this packet
	    	  World world = player.world;
	    	  if(player.getHeldItemMainhand().getItem() instanceof Gun)
	    	  {
	    		  Gun gun = (Gun) player.getHeldItemMainhand().getItem();
	    		  gun.ReloadGun(world, player);
	    	  }
	    	  
	      });
	    }
	    ctx.get().setPacketHandled(true);
	  }
	
}
