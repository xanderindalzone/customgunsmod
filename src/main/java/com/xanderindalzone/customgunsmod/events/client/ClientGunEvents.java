package com.xanderindalzone.customgunsmod.events.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.init.InitKeys;
import com.xanderindalzone.customgunsmod.objects.items.guns.Gun;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.entity.model.BipedModel.ArmPose;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

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
