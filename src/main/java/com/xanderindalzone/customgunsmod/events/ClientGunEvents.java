package com.xanderindalzone.customgunsmod.events;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.objects.items.guns.GunBase;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.entity.model.BipedModel.ArmPose;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = CustomGunsMod.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class ClientGunEvents 
{
	
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
		

	    if(player != null&&player.getHeldItemMainhand().getItem() instanceof GunBase){
	    	event.getRenderer().getEntityModel().rightArmPose=ArmPose.BOW_AND_ARROW;
	    }
	}
	
	
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
		if(Minecraft.getInstance().player.getHeldItemMainhand().getItem() instanceof GunBase)
		{
			GunBase gun = (GunBase) player.getHeldItemMainhand().getItem();
			FontRenderer TextRenderer = Minecraft.getInstance().fontRenderer;
			String text = "Gun AMMO: ";
			String textAmmo = "["+(gun.gun_mag-player.getHeldItemMainhand().getDamage())+"/"+gun.gun_mag+"]";
			TextRenderer.drawStringWithShadow(text, x+10, y, 16777215);
			TextRenderer.drawStringWithShadow(textAmmo, x+10, y+10, 16245549);
			if(!((gun.gun_mag-player.getHeldItemMainhand().getDamage())>0))
			{
				String text1="No AMMO!";
				String text2="Press "+CustomGunsMod.KEY_GUN_RELOAD.getLocalizedName().toUpperCase()+" to reload!";
				TextRenderer.drawStringWithShadow(text1, x+10, y+20, 16730698);
				TextRenderer.drawStringWithShadow(text2, x+10, y+30, 16777215);		
			}
			if(player.getCooldownTracker().hasCooldown(gun)) 
			{
				
				String text3="Reloading!";
				System.out.println(text3);
				TextRenderer.drawStringWithShadow(text3, x2+10, y2, 61256);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//===================================================================
	//UNUSED CODE 
	//(just keeping this here just in case I need it in the future)
	//===================================================================
		
		
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
