package com.xanderindalzone.customgunsmod.objects.items.guns;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.google.common.collect.Multimap;
import com.xanderindalzone.customgunsmod.CustomGunsMod;
import com.xanderindalzone.customgunsmod.entities.projectiles.PistolBulletEntity;
import com.xanderindalzone.customgunsmod.init.InitEntities;
import com.xanderindalzone.customgunsmod.init.InitItems;
import com.xanderindalzone.customgunsmod.init.InitSounds;
import com.xanderindalzone.customgunsmod.objects.items.guns.pistols.Colt1911;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.Sound;
import net.minecraft.client.audio.SoundEventAccessor;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.UseAction;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.profiler.ISnooperInfo;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.CooldownTracker;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.EntityPlaceEvent;

public class Gun extends Item
{
	
	public int gun_mag;
	
	public GunTypes gun_type;
	public GunFireTypes gun_fire_type;
	public GunCaliberTypes gun_caliber_type;
	public int gun_burst_shots=1;
	public Item ammo_used;
	public float gun_damage;
	public float gun_base_accuracy;
	public float gun_recoil;
	public float gun_bullet_speed;
	public int gun_firing_rate;
	public int gun_reload_cooldown;
	public int gun_reload_cooldown_cock;
//	public boolean gun_is_full_auto;

	public float zoom_fov;
	public double aim_sensitivity;

	private static final IItemPropertyGetter AIM_PROPERTY_GETTER = (stack, world, entity) -> {
	      return stack.hasTag()&&stack.getTag().getBoolean("gun_property_is_aiming") == true ? 1.0F : 0.0F;
	};
	private static final IItemPropertyGetter CROUCH_PROPERTY_GETTER = (stack, world, entity) -> {
		if(entity==null) {return 0.0F;}
	      return (stack.hasTag()&&(entity.isCrouching()||entity.isSneaking()))
	    		  &&(entity.getHeldItemMainhand()==stack||entity.getHeldItemOffhand()==stack)
	    		  &&stack.getTag().getBoolean("gun_property_is_aiming") == false ? 1.0F : 0.0F;
	};
	
	
	public Gun(Properties properties) {
		super(properties);
	    this.addPropertyOverride(new ResourceLocation("aiming"), AIM_PROPERTY_GETTER);
	    this.addPropertyOverride(new ResourceLocation("crouching"), CROUCH_PROPERTY_GETTER);
	}
	

	
//==========================================================================================================
//COMPORTAMIENTOS DEL ITEM
	
	//CANCELAR ANIMACION DE SWING DEL ITEM
	@Override
	public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {return true;}
	//CANCELA GOLPES A ENTITIES
	@Override
	public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity){return true;}
	//CANCELA PODER ROMPER BLOQUES CON ESTE ITEM
	@Override
	public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player){return false;}
	
	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
		Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
		multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", 20, Operation.ADDITION));
		return multimap;
	}
	
	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.NONE;
	}
	
	@Override
	public int getUseDuration(ItemStack stack) 
	{
		if(this.gun_fire_type == GunFireTypes.AUTOMATIC) {return 0;}
		else {return 72000;}
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) 
	{
		stack.damageItem(this.gun_mag, playerIn, null);
	}
	
	public void setAiming(PlayerEntity player, ItemStack gunStack, boolean value) //1 = AIMING 
	{
		if(value) 
		{
			gunStack.getTag().putBoolean("gun_property_is_aiming", true);
		}
		else 
		{
			gunStack.getTag().putBoolean("gun_property_is_aiming", false);
		}
	}
	
//==========================================================================================================	
	

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) 
	{
		super.onPlayerStoppedUsing(stack, worldIn, entityLiving, timeLeft);
		//DO STUFF
		if(entityLiving instanceof PlayerEntity) 
		{
			PlayerEntity playerIn = (PlayerEntity) entityLiving;
		}
	}
	
	@Override
	public void onUse(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) 
	{
		super.onUse(worldIn, livingEntityIn, stack, count);
		//DO STUFF WHEN USING ITEM
		if(livingEntityIn instanceof PlayerEntity) 
		{
			PlayerEntity playerIn = (PlayerEntity) livingEntityIn;
		}
	}
	
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) 
	{
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
		//DO STUFF
		
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if(handIn!=Hand.MAIN_HAND) {return new ActionResult<ItemStack>(ActionResultType.FAIL, playerIn.getHeldItem(handIn));}
		playerIn.setActiveHand(handIn);
		
		if(playerIn.getHeldItemMainhand().getDamage()<this.gun_mag||playerIn.isCreative()) {
					
			shootGun(worldIn, playerIn); //DISPARAR ARMA
			playerIn.getHeldItemMainhand().damageItem(1, playerIn, null);
			if(!(playerIn.getHeldItemMainhand().getDamage()<this.gun_mag||playerIn.isCreative())) 
			{			
				worldIn.playSound(null, playerIn.getPosition(), SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.PLAYERS, 1.0F, 3.0F);
			}
		}
		else 
		{
			worldIn.playSound(null, playerIn.getPosition(), InitSounds.SOUND_no_ammo_click.get(), SoundCategory.PLAYERS, 1.0F, 1.0F);
		}	
		return new ActionResult<ItemStack>(ActionResultType.FAIL, playerIn.getHeldItemMainhand());
	}
	
	

//===========================================================================================
//PRIVATE METHOD
//===========================================================================================
	private void shootGun(World worldIn, PlayerEntity playerIn) 
	{
		double posX = playerIn.getPosX();
		double posY = playerIn.getPosY();
		double posZ = playerIn.getPosZ();
		Vec3d look = playerIn.getLookVec();
		World world = playerIn.getEntityWorld();
			
		//=======================================================
		//PROPIEDADES DEL DISPARO
		//=======================================================
		PistolBulletEntity bullet = new PistolBulletEntity(InitEntities.PISTOL_BULLET_ENTITY.get(), 1.0D, 1.0D, 1.0D, world, playerIn, this.gun_damage, this.gun_bullet_speed);
		
//		double sneaking_accuracy=1;
//		double walking_accuracy=1;
//		double aiming_accuracy=1;

		double accuracy=this.gun_base_accuracy*0.75;
		
		//CASO 1: APUNTANDO SIN CORRER
		if((playerIn.getHeldItemMainhand().getTag().getBoolean("gun_property_is_aiming") == true)
				&&!playerIn.isSprinting()) 
		{
			accuracy=1;
		}
		//CASO 2: AGACHADO SIN APUNTAR
		if((playerIn.isSneaking()||playerIn.isCrouching())&&(playerIn.getHeldItemMainhand().getTag().getBoolean("gun_property_is_aiming") == false)) 
		{
			accuracy=this.gun_base_accuracy;
		}	
		//CASO 3: SIN APUNTAR Y SIN AGACHARSE, PERO SIN CORRER
		if((!playerIn.isSneaking()&&!playerIn.isCrouching())&&(playerIn.getHeldItemMainhand().getTag().getBoolean("gun_property_is_aiming") == false)
				&&!playerIn.isSprinting()) 
		{
			accuracy=this.gun_base_accuracy*0.9;
		}	
		
		double desv = (1-accuracy);
		
		double desvX = (desv-Math.random()*(desv*2));
		double desvY = (desv-Math.random()*(desv*2));
		double desvZ = (desv-Math.random()*(desv*2));
				
		//ESTABLECE EL ALCANCE DE LA BALA Y LA DESVIACION
		bullet.setVelocity(look.x*this.gun_bullet_speed+(desvX), look.y*this.gun_bullet_speed+(desvY), look.z*this.gun_bullet_speed+(desvZ));
				
		//ESTABLECE LA CADENCIA DEL ARMA
		playerIn.getCooldownTracker().setCooldown(this, this.gun_firing_rate); //TICKS - 30 TICKS = 1 seg
				
		//ESTABLECE EL RETROCESO MAXIMO DEL DISPARO
		float recoil_pitch = (float) -(((gun_recoil)*Math.random()));	//ES SIEMPRE NEGATIVO, SIEMPRE TENDRA RETROCESO HACIA ARRIBA
		float recoil_yaw = (float) ((float) gun_recoil-((gun_recoil*2)*Math.random()));
		playerIn.rotationPitch=playerIn.rotationPitch+recoil_pitch;
		playerIn.rotationYaw=playerIn.rotationYaw+recoil_yaw;
		
		
		
		double sneakModifier = 0;
		if(playerIn.isSneaking()||playerIn.isCrouching()) {sneakModifier=0.37;}
		double bulletXPos = posX+(look.x*1.3D);
		double bulletYPos = posY+(look.y*1.5D)+1.6D-sneakModifier;
		double bulletZPos = posZ+(look.z*1.3D);
		
		//CONFIGURA LA ALTURA DE SALIDA DE LA BALA
		if(playerIn.rotationPitch>60) //SI ESTA MIRANDO HACIA ABAJO
		{
			bulletYPos = posY+(look.y*1.5D)+1.0D-sneakModifier;
		}
		if(playerIn.rotationPitch<-60) //SI ESTA MIRANDO HACIA ARRIBA
		{
			bulletYPos = posY+(look.y*1.5D)+1.3D-sneakModifier;
		}
		
		

		//SPAWNEAR FOGONAZO
		worldIn.addParticle(ParticleTypes.FLAME, bulletXPos, bulletYPos+0.1, bulletZPos, 0.0D, 0.0D, 0.0D);
		worldIn.addParticle(ParticleTypes.CLOUD, bulletXPos, bulletYPos+0.1, bulletZPos, 0.0D, 0.5D, 0.0D);
		worldIn.addParticle(ParticleTypes.SWEEP_ATTACK, bulletXPos, bulletYPos+0.1, bulletZPos, 0.0D, 0.0D, 0.0D);
		
		//ESTABLECER POSICION INICIAL DE LA BALA
		bullet.setPosition(bulletXPos, bulletYPos, bulletZPos);

		if(!world.isRemote)
		{
			world.addEntity(bullet);
			shootingGunSound(worldIn, playerIn, this);
		}
		
		
	}




	private void shootingGunSound(World worldIn, PlayerEntity playerIn, Gun gun) 
	{
		if(gun instanceof Colt1911) 
		{
			worldIn.playSound(null, playerIn.getPosition(), InitSounds.SOUND_shot_Colt1911.get(), SoundCategory.PLAYERS, 1.0F, 1.0F);
		}
	}
	
	private void reloadingGunSound(World worldIn, PlayerEntity playerIn, Gun gun, boolean cock_reload) 
	{
		if(gun instanceof Colt1911) 
		{
			if(cock_reload)
			{
				worldIn.playSound(null, playerIn.getPosition(), InitSounds.SOUND_reload_Colt1911_cock.get(), SoundCategory.PLAYERS, 1.0F, 1.0F);
				playerIn.getCooldownTracker().setCooldown(InitItems.PISTOL_COLT_1911.get(), this.gun_reload_cooldown_cock); //TICKS - 30 TICKS = 1 seg
			}
			else
			{
				worldIn.playSound(null, playerIn.getPosition(), InitSounds.SOUND_reload_Colt1911.get(), SoundCategory.PLAYERS, 1.0F, 1.0F);
				playerIn.getCooldownTracker().setCooldown(InitItems.PISTOL_COLT_1911.get(), this.gun_reload_cooldown); //TICKS - 30 TICKS = 1 seg
			}
		}
	}
	
	
	
	
	
	//===========================================================================================
	//CALLED FROM CLIENT TO SERVER METHOD
	//===========================================================================================
	
	public boolean ReloadGun(World worldIn, PlayerEntity player) {
		int ammo_left = (this.gun_mag-player.getHeldItemMainhand().getDamage());	
		boolean cock_reload = false;
		
				
		//COMPRUEBA SI EL CARGADOR SE PUEDE RECARGAR
		if(ammo_left!=this.gun_mag&&!player.isCreative())	
		{
			if(ammo_left==0) {cock_reload=true;}
					
					
			//COMPRUEBA SI EL JUGADOR TIENE MUNICION EN EL INVENTARIO
			if(player.inventory.hasItemStack(new ItemStack(this.ammo_used))) 
			{
				for(int slotIndex=0; slotIndex<player.inventory.mainInventory.size(); slotIndex++) 
				{
					int ammo_needed = this.gun_mag-ammo_left;
					ItemStack item = player.inventory.getStackInSlot(slotIndex).copy();
					if(item.getItem() == this.ammo_used)
					{
						if(!worldIn.isRemote) 
						{
							ammo_left=removeAmmo(player, ammo_needed, ammo_left, item, slotIndex);
						}
						else
						{
							ammo_left=removeAmmo(player, ammo_needed, ammo_left, item, slotIndex);
						}
						reloadingGunSound(worldIn, player, this, cock_reload);
					}
				}
				return true;
			}
		}
		return false;
	}
		
	//DEVUELVE LA MUNICION QUE FALTA
	private int removeAmmo(PlayerEntity player, int ammo_needed, int ammo_left, ItemStack item, int slotIndex)
	{
		if(ammo_needed<item.getCount())
		{
			item.shrink(ammo_needed);
			player.inventory.setInventorySlotContents(slotIndex, item);
			player.getHeldItemMainhand().damageItem(-ammo_needed, player, null);
			ammo_left=this.gun_mag;
		}
		else
		{
			player.inventory.setInventorySlotContents(slotIndex, new ItemStack(Blocks.AIR));
			player.getHeldItemMainhand().damageItem(-item.getCount(), player, null);
			ammo_left=ammo_left+item.getCount();
		}
		return ammo_left;
	}

	
}
