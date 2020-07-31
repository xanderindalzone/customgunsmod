package com.xanderindalzone.customgunsmod.events;

import java.awt.event.ItemEvent;
import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.builder.ReflectionDiffBuilder;
import org.apache.logging.log4j.core.appender.rewrite.MapRewritePolicy.Mode;
import org.codehaus.plexus.util.ReflectionUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL46;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.capabilities.providers.ProviderGunActions;
import com.xanderindalzone.customgunsmod.objects.items.guns.Gun;

import io.netty.util.internal.ReflectionUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.management.PlayerInteractionManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.ForgeConfig.Server;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = CustomGunsMod.MOD_ID, bus = Bus.FORGE)
public class GunCapabilityHandler 
{
	 
	 @SubscribeEvent
	 public static void attachCapability(AttachCapabilitiesEvent<Entity> event)
	 {
		 if (event.getObject().getEntity() instanceof PlayerEntity) 
		 {
			 ResourceLocation GUN_ACTIONS_CAP = new ResourceLocation(CustomGunsMod.MOD_ID, "gun_actions");
			 event.addCapability(GUN_ACTIONS_CAP, new ProviderGunActions());
		 }
	 }
	

}
