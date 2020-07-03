package com.xanderindalzone.customgunsmod.init;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Renderer;

import org.lwjgl.glfw.GLFW;

import com.ibm.icu.impl.ICUService.Key;
import com.sun.jna.platform.KeyboardUtils;
import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.creativetabs.AmmoItemGroup;
import com.xanderindalzone.customgunsmod.creativetabs.CustomBlocksItemGroup;
import com.xanderindalzone.customgunsmod.creativetabs.GunsItemGroup;
import com.xanderindalzone.customgunsmod.entities.projectiles.PistolBulletEntity;
import com.xanderindalzone.customgunsmod.objects.ItemBase;
import com.xanderindalzone.customgunsmod.objects.blocks.ArmoredGlassBlock;
import com.xanderindalzone.customgunsmod.objects.blocks.BlockBase;
import com.xanderindalzone.customgunsmod.objects.blocks.BlockItemBase;
import com.xanderindalzone.customgunsmod.objects.items.ammo.BulletBase;
import com.xanderindalzone.customgunsmod.objects.items.guns.GunBase;
import com.xanderindalzone.customgunsmod.objects.items.guns.pistols.Colt1911;
import com.xanderindalzone.customgunsmod.renderers.BulletRender;

import net.java.games.input.Keyboard;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.list.KeyBindingList;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.settings.KeyBindingMap;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = CustomGunsMod.MOD_ID, bus = Bus.MOD)
@ObjectHolder(CustomGunsMod.MOD_ID)
public class Init 
{
	
	public static List<Item> ModItems = new ArrayList<Item>();
	public static List<Block> ModBlocks = new ArrayList<Block>();
	public static List<BlockItem> ModBlockItems = new ArrayList<BlockItem>();
	
	
	
	
	
	
	
	
	
	/*=================*/
	/*BLOCKS PROPERTIES*/
	/*=================*/
	static Properties PROPERTIES_ARMORED_GLASS = Block.Properties.create(Material.IRON)
			.sound(SoundType.GLASS)
			.hardnessAndResistance(15.0F, 6000.0F)
			.harvestLevel(3)
			.harvestTool(ToolType.PICKAXE)
			.notSolid();

	/*======*/
	/*BLOCKS*/
	/*======*/
	public static final Block ARMORED_GLASS_BLOCK = 
			new ArmoredGlassBlock(PROPERTIES_ARMORED_GLASS).setRegistryName("armored_glass_block");
	public static final BlockItem ARMORED_GLASS_ITEM_BLOCK = 
			(BlockItem) new BlockItemBase(ARMORED_GLASS_BLOCK, new Item.Properties().group(CustomGunsMod.CUSTOM_BLOCKS_TAB)).setRegistryName(ARMORED_GLASS_BLOCK.getRegistryName());
	
	
	
	
	
	
	
	
	
	/*=============*/
	/*ITEMS BULLETS*/
	/*=============*/
	public static final Item BULLET_CAL_45 = 
			new BulletBase(new Item.Properties().group(CustomGunsMod.AMMO_TAB)).setRegistryName("bullet_cal_45");
	
	
	/*==========*/
	/*ITEMS GUNS*/
	/*==========*/
	public static final Item PISTOL_COLT_1911 = 
			new Colt1911(new Item.Properties().group(CustomGunsMod.GUNS_TAB)
					.maxStackSize(1)
					.maxDamage(Colt1911.gun_ammo_capacity+1))
			.setRegistryName("pistol_colt_1911");
	

	
	
	
	
	
	
	
	
	
	/*===========*/
	/*PROJECTILES*/
	/*===========*/	
	
	public static final EntityType<PistolBulletEntity> PISTOL_BULLET_ENTITY = 
			EntityType.Builder.<PistolBulletEntity>create(PistolBulletEntity::new, EntityClassification.MISC)
			.setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64)
			.setUpdateInterval(1)
			.size(1, 1)
			.build(new ResourceLocation(CustomGunsMod.MOD_ID, PistolBulletEntity.BULLET_ID).toString());

	
	
	
	
	
	

	
	
	
	
	
	/*======*/
	/*EVENTS*/
	/*======*/
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		
		for(Item item : ModItems)
		{
			event.getRegistry().register(item);
		}
		for(BlockItem blockitem : ModBlockItems)
		{
			event.getRegistry().register(blockitem);
		}
	}
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		for(Block block : ModBlocks)
		{
			event.getRegistry().register(block);
		}
	}

	@SubscribeEvent
	public static void registerProjectiles(RegistryEvent.Register<EntityType<?>> event)
	{
		event.getRegistry()
		.register(PISTOL_BULLET_ENTITY.setRegistryName(PistolBulletEntity.BULLET_ID));
		
	}
}
