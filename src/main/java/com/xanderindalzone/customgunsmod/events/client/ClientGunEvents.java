package com.xanderindalzone.customgunsmod.events.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sun.jna.platform.unix.X11.Window;
import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.entities.projectiles.PistolBulletEntity;
import com.xanderindalzone.customgunsmod.init.InitKeys;
import com.xanderindalzone.customgunsmod.init.InitSounds;
import com.xanderindalzone.customgunsmod.objects.items.guns.Gun;
import com.xanderindalzone.customgunsmod.packets.PacketHandler;
import com.xanderindalzone.customgunsmod.packets.messages.HitMarkerMessage;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.entity.model.BipedModel.ArmPose;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.network.NetworkDirection;

@Mod.EventBusSubscriber(modid = CustomGunsMod.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class ClientGunEvents 
{
	
	
	
	/**
	 * Makes the player model render as it was 
	 * aiming with a Bow whenever the player is holding a Gun Item
	 * @param event
	 */
	@SubscribeEvent		
	public static void renderHeldGun(RenderPlayerEvent.Pre event)
	{

		
		PlayerEntity player = event.getPlayer();
		PlayerRenderer render = event.getRenderer();
		PlayerModel<AbstractClientPlayerEntity> model = render.getEntityModel();
		

	    if(player != null&&player.getHeldItemMainhand().getItem() instanceof Gun){
	    	event.getRenderer().getEntityModel().rightArmPose=ArmPose.BOW_AND_ARROW;
	    }
	}
	

	
	
	
	
	/**
	   * Draw the custom crosshairs if reqd
	   * Otherwise, cancel the event so that the normal crosshair is drawn.
	   * @param event
	   */
	  @SubscribeEvent
	public static void AimMarker(RenderGameOverlayEvent.Pre event) {
		PlayerEntity player = Minecraft.getInstance().player;
		
		
		int width = event.getWindow().getScaledWidth();
	    int height = event.getWindow().getScaledHeight();
	    
	    if (event.getType() == RenderGameOverlayEvent.ElementType.CROSSHAIRS 
				&& player.getHeldItemMainhand().getItem() instanceof Gun) {event.setCanceled(true);}
		
		if (event.getType() == RenderGameOverlayEvent.ElementType.CROSSHAIRS 
				&& player.getHeldItemMainhand().getItem() instanceof Gun 
				&& !(Minecraft.getInstance().gameSettings.keyBindAttack.isKeyDown())) 
		{
			
			
		
//			int yd = event.getWindow().getScaledHeight();
//			int xd = event.getWindow().getScaledWidth();
//			
//			int xRightMarker=(int) (xd*0.54);
//			int yRightMarker=(int) (yd*0.492);
//			
//			int xLeftMarker=(int) (xd*0.453);
//			int yLeftMarker=(int) (yd*0.492);
//			
//			int xUpMarker=(int) (xd*0.50);
//			int yUpMarker=(int) (yd*0.415);
//			
//			int xDownMarker=(int) (xd*0.5);
//			int yDownMarker=(int) (yd*0.561);
//			
//			int xHitMarker=(int) (xd*0.497);
//			int yHitMarker=(int) (yd*0.488);
//
//			
//			Gun gun = (Gun) player.getHeldItemMainhand().getItem();
//			FontRenderer TextRenderer = Minecraft.getInstance().fontRenderer;
//			
//			float modifier = (1-gun.gun_accuracy)*2;
//			
//			
//			
//			
//			TextRenderer.drawString("-", (xRightMarker)+modifier, yRightMarker, 16777215);
//			TextRenderer.drawString("-", (xLeftMarker)-modifier, yLeftMarker, 16777215);
//			TextRenderer.drawString("|", xUpMarker, (yUpMarker)-modifier, 16777215);
//			TextRenderer.drawString("|", xDownMarker, (yDownMarker)+modifier, 16777215);
		} 
	}
	
	
	  
	  
	  
	  
	
	
	
	public static void DisplayHitMarker(boolean kill) 
	{
		System.out.println("DEBUG HITMARKER");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//===================================================================
	//UNUSED CODE 
	//(just keeping this here just in case I need it in the future)
	//===================================================================
		
	
	
	//==================
	//NOT NEEDED FOR NOW
	//==================
//	@SubscribeEvent
//	public static void renderPistolInHand(RenderHandEvent event)
//	{
//		
//		GunBase gun = null;
//		PlayerEntity player = Minecraft.getInstance().player;
//		if(player.getHeldItemMainhand().getItem() instanceof GunBase) 
//		{ 
//			gun = (GunBase) player.getHeldItemMainhand().getItem();
//		}
//		
//		if(player != null&&player.getHeldItemMainhand().getItem() instanceof GunBase)
//		{
////			if(gun.isAiming())
////			{
////				event.setCanceled(true);
////			}
//		}
//	}
		
//		private static void renderLeftArmModelIdleHoldingPistol(PlayerModel<AbstractClientPlayerEntity> model, PlayerEntity player, RenderPlayerEvent event)
//		{
//			
//
//	    	
//			model.bipedLeftArm.rotationPointX = -MathHelper.cos((float) Math.toRadians(player.renderYawOffset)) * -5.5F;
//	    	model.bipedLeftArm.rotationPointY = player.isCrouching() ? 17.5F : 20.5F;
//	    	model.bipedLeftArm.rotationPointZ = -MathHelper.sin((float) Math.toRadians(player.renderYawOffset)) * -5.5F;
//	    	model.bipedLeftArm.rotateAngleX = -1.7F - (player.rotationPitch/90)*1.2F; //-3.0F > -1.65F > -0.0F;	
//	    	model.bipedLeftArm.rotateAngleY =  (float) -Math.toRadians(-model.bipedRightArm.rotationPointY);
//	    	model.bipedLeftArm.rotateAngleZ = 0.0F;
//	    	
//
//	    	MatrixStack matrix = event.getMatrixStack();
//	    	IVertexBuilder buffer = event.getBuffers().getBuffer(model.getRenderType(((AbstractClientPlayerEntity) player).getLocationSkin()));
//	    	int light = event.getLight();
//	    	int texture = OverlayTexture.NO_OVERLAY;
//	    	
//	    	model.bipedLeftArm.showModel=true;	
//	    	model.bipedLeftArm.render(matrix, buffer, light, texture);
//	    	
//
//		}
//		
//		private static void renderArmModelIdleHoldingPistolAiming(PlayerModel<AbstractClientPlayerEntity> model, PlayerEntity player, RenderPlayerEvent event)
//		{
//			MatrixStack matrix = event.getMatrixStack();
//	    	IVertexBuilder buffer = event.getBuffers().getBuffer(model.getRenderType(((AbstractClientPlayerEntity) player).getLocationSkin()));
//	    	int light = event.getLight();
//	    	int texture = OverlayTexture.NO_OVERLAY;
//			
//	    	model.bipedRightArm.rotationPointX = -MathHelper.cos((float) Math.toRadians(player.renderYawOffset)) * 5.5F;
//	    	model.bipedRightArm.rotationPointY = player.isCrouching() ? 17.5F : 20.5F;
//	    	model.bipedRightArm.rotationPointZ = -MathHelper.sin((float) Math.toRadians(player.renderYawOffset)) * 5.5F;
//	    	model.bipedRightArm.rotateAngleX = -1.6F - (player.rotationPitch/90)*1.2F; //-3.0F > -1.65F > -0.0F;	
//	    	model.bipedRightArm.rotateAngleY =  (float) -Math.toRadians(player.renderYawOffset) + 3.5F + -Math.abs((player.rotationPitch/90))*-0.6F;
//	    	model.bipedRightArm.rotateAngleZ = 0.0F;
//	    	
//	    	model.bipedLeftArm.rotationPointX = -MathHelper.cos((float) Math.toRadians(player.renderYawOffset)) * -5.5F;
//	    	model.bipedLeftArm.rotationPointY = player.isCrouching() ? 17.5F : 20.5F;
//	    	model.bipedLeftArm.rotationPointZ = -MathHelper.sin((float) Math.toRadians(player.renderYawOffset)) * -5.5F;
//	    	model.bipedLeftArm.rotateAngleX = -1.7F - (player.rotationPitch/90)*1.2F; //-3.0F > -1.65F > -0.0F;	
//	    	model.bipedLeftArm.rotateAngleY =  (float) -Math.toRadians(player.renderYawOffset) - 3.5F + -Math.abs((player.rotationPitch/90))*0.6F;
//	    	model.bipedLeftArm.rotateAngleZ = 0.0F;
//
//	    	
//	    	model.bipedRightArm.showModel=true;	
//	    	model.bipedLeftArm.showModel=true;	
//	    	model.bipedRightArm.render(matrix, buffer, light, texture);
//	    	model.bipedLeftArm.render(matrix, buffer, light, texture);
//		}
	
	
}
