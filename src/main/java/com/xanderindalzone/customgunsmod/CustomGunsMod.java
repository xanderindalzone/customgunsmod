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
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
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

import com.xanderindalzone.customgunsmod.capabilities.entity.GunAim;
import com.xanderindalzone.customgunsmod.capabilities.entity.IGunAim;
import com.xanderindalzone.customgunsmod.capabilities.entity.StorageGunAim;
import com.xanderindalzone.customgunsmod.creativetabs.AmmoItemGroup;
import com.xanderindalzone.customgunsmod.creativetabs.CustomBlocksItemGroup;
import com.xanderindalzone.customgunsmod.creativetabs.GunsItemGroup;
import com.xanderindalzone.customgunsmod.entities.projectiles.PistolBulletEntity;
import com.xanderindalzone.customgunsmod.init.InitBlocks;
import com.xanderindalzone.customgunsmod.init.InitCapabilities;
import com.xanderindalzone.customgunsmod.init.InitEntities;
import com.xanderindalzone.customgunsmod.init.InitItems;
import com.xanderindalzone.customgunsmod.init.InitKeys;
import com.xanderindalzone.customgunsmod.init.InitSounds;
import com.xanderindalzone.customgunsmod.packets.PacketHandler;
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
	
	
	
	

	
	
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public CustomGunsMod() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);
		
    	InitItems.ITEMS.register(modEventBus);
    	InitBlocks.BLOCKS.register(modEventBus);
    	InitEntities.ENTITIES.register(modEventBus);
    	InitSounds.SOUNDS.register(modEventBus);

    	
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        //Mod Instance
        instance = this;
    }


    
    
    
    
    
    
    
    
    
    private void setup(final FMLCommonSetupEvent event)
    {
    	PacketHandler.registerPackets();
    	InitCapabilities.registerCapabilities();
    }
    

    
    

    private void doClientStuff(final FMLClientSetupEvent event) 
    {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
        //==================================================================================
        
		//Renderiza este bloque con textura trasnparente
    	RenderTypeLookup.setRenderLayer(InitBlocks.ARMORED_GLASS_BLOCK.get(), RenderType.getCutoutMipped());
    	
    	//Registra el Render de las balas
        RenderingRegistry.registerEntityRenderingHandler(InitEntities.PISTOL_BULLET_ENTITY.get(), BulletRender::new);
        
        //Registra nuevos controles
        ClientRegistry.registerKeyBinding(InitKeys.KEY_RELOAD_GUN);
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
