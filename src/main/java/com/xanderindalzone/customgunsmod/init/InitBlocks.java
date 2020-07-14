package com.xanderindalzone.customgunsmod.init;

import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.objects.blocks.ArmoredGlassBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitBlocks 
{

	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<Block>(ForgeRegistries.BLOCKS, CustomGunsMod.MOD_ID);
	//================================================================================================
	//================================================================================================
	//================================================================================================
	//================================================================================================
	
	public static final String ARMORED_GLASS_ITEM_BLOCK_ID = "armored_glass_block";
	public static final RegistryObject<Block> ARMORED_GLASS_BLOCK = 
			BLOCKS.register(ARMORED_GLASS_ITEM_BLOCK_ID, () -> new ArmoredGlassBlock(Block.Properties.create(Material.IRON)
					.sound(SoundType.GLASS)
					.hardnessAndResistance(15.0F, 6000.0F)
					.harvestLevel(3)
					.harvestTool(ToolType.PICKAXE)
					.notSolid()));
	

}
