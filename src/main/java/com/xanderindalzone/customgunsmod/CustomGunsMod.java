package com.xanderindalzone.customgunsmod;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

import com.xanderindalzone.customgunsmod.creativetabs.AmmoItemGroup;
import com.xanderindalzone.customgunsmod.creativetabs.CustomBlocksItemGroup;
import com.xanderindalzone.customgunsmod.creativetabs.GunsItemGroup;
import com.xanderindalzone.customgunsmod.entities.projectiles.PistolBulletEntity;
import com.xanderindalzone.customgunsmod.init.Init;
import com.xanderindalzone.customgunsmod.renderers.BulletRender;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("customgunsmod")
public class CustomGunsMod
{
	
	public static final String MOD_ID = "customgunsmod";
	public static CustomGunsMod instance;
	
	
	/*=============*/
	/*CREATIVE TABS*/
	/*=============*/
	public static final GunsItemGroup GUNS_TAB = new GunsItemGroup("guns");
	public static final AmmoItemGroup AMMO_TAB = new AmmoItemGroup("ammo");
	public static final CustomBlocksItemGroup CUSTOM_BLOCKS_TAB = new CustomBlocksItemGroup("custom_blocks");
	
	
	/*============*/
	/*KEY BINDINGS*/   //("key.test", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_J, "key.categories.test");
	/*============*/	
	public static final KeyBinding KEY_GUN_RELOAD = new KeyBinding("key.reload", GLFW.GLFW_KEY_R, "key.categories.customgunsmod");
	
	
	
	

	
	
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public CustomGunsMod() {
    	
    	
    	
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        
        instance = this;
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	
    	
    	
    }
    


    private void doClientStuff(final FMLClientSetupEvent event) 
    {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
        //==================================================================================

        RenderingRegistry.registerEntityRenderingHandler(Init.PISTOL_BULLET_ENTITY, BulletRender::new);
        ClientRegistry.registerKeyBinding(KEY_GUN_RELOAD);
    }

    

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
    	LOGGER.info("====================================");
        LOGGER.info("Loading CustomGunsMod on the server!");
    	LOGGER.info("====================================");
    	
    	
    	
    }
}
