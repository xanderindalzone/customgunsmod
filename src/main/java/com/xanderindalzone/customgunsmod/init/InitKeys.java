package com.xanderindalzone.customgunsmod.init;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


public class InitKeys 
{
	
	public static final KeyBinding KEY_RELOAD_GUN = 
			new KeyBinding("key.reload", GLFW.GLFW_KEY_R, "key.categories.customgunsmod");
	
}
