package com.xanderindalzone.customgunsmod.entities.projectiles;

import java.util.function.Supplier;

import com.xanderindalzone.customgunsmod.init.InitItems;
import com.xanderindalzone.customgunsmod.init.InitSounds;
import com.xanderindalzone.customgunsmod.packets.PacketHandler;
import com.xanderindalzone.customgunsmod.packets.messages.HitMarkerMessage;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.network.NetworkManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.PacketDistributor;

public class PistolBulletEntity extends AbstractArrowEntity 
{
	
	
	//HIT BOOLEANS
	public boolean IRON_HIT=false;
	public boolean GLASS_HIT=false;
	
	//PROJECTILE PROPERTIES
	public float bullet_damage=0;
	private boolean hasFirstUpdated=false;
	public double initPosX;
	public double initPosY;
	public double initPosZ;
	public PlayerEntity shooter;
	
	public PistolBulletEntity(EntityType<? extends AbstractArrowEntity> type, World worldIn) 
	{
		super(type, worldIn);
		setNoGravity(true);
	}
	public PistolBulletEntity(EntityType<? extends AbstractArrowEntity> type, LivingEntity shooter, World worldIn) 
	{
		super(type, shooter, worldIn);
		setNoGravity(true);
	}
	public PistolBulletEntity(EntityType<? extends AbstractArrowEntity> type, double x, double y, double z, World worldIn) 
	{
		super(type, x, y, z, worldIn);
		setNoGravity(true);
	}
	public PistolBulletEntity(EntityType<? extends AbstractArrowEntity> type, double x, double y, double z, World worldIn, PlayerEntity shooter, float damage) 
	{
		super(type, x, y, z, worldIn);
		this.bullet_damage=damage;
		this.shooter=shooter;
		setNoGravity(true);
	}
	

	

	
	@Override
	public IPacket<?> createSpawnPacket() 
	{
		return NetworkHooks.getEntitySpawningPacket(this);
	}
	
	@Override
	protected ItemStack getArrowStack() 
	{
		return new ItemStack(InitItems.BULLET_CAL_45.get()); //Init.BULLET_CAL_45 OLD
	}
	
//==========================================================================================================
//==========================================================================================================	
	public void setBulletDamage(float damage)
	{
		this.bullet_damage=damage;
	}
	
	@Override
	public Entity getShooter() 
	{
		return this.shooter;
	}
	
	@Override
	protected void onHit(RayTraceResult result) {
		if(result.getType() == RayTraceResult.Type.ENTITY)
		{
			EntityRayTraceResult entityResult = (EntityRayTraceResult) result;
			if(entityResult.getEntity() instanceof LivingEntity) {
				LivingEntity entityHit = (LivingEntity) entityResult.getEntity();
				entityHit.attackEntityFrom(DamageSource.causeArrowDamage(this, entityHit), this.bullet_damage);
				
				if(entityHit.getHealth()<=0)
				{
					if(this.shooter != null)
					{
						this.shooter.playSound(InitSounds.SOUND_hit_marker.get(), SoundCategory.PLAYERS, 1.0F, 1.0F);
						this.shooter.playSound(InitSounds.SOUND_kill.get(), SoundCategory.PLAYERS, 1.0F, 1.0F);
					}
				}
				else
				{
					if(this.shooter != null)
					{
						this.shooter.playSound(InitSounds.SOUND_hit_marker.get(), SoundCategory.PLAYERS, 1.0F, 1.0F);
					}
				}
				spawnBloodParticles(this.getPosX(), this.getPosY(), this.getPosZ());
				this.remove();
			}
		}
		if(result.getType() == RayTraceResult.Type.BLOCK)
		{
			spawnGroundParticles(this.getPosX(), this.getPosY(), this.getPosZ());
			this.world.playSound(null, this.getPosition(), InitSounds.SOUND_bullet_ground_impact.get(), SoundCategory.PLAYERS, 1.0F, 1.0F);
			this.remove();
		}
	}
	
	
	@Override
	public void tick() {
		super.tick();
		if(hasFirstUpdated==false) 
		{
			initPosX=this.getPosX();
			initPosY=this.getPosY();
			initPosZ=this.getPosZ();
			hasFirstUpdated=true;
		}
		
		if(this.world.isRemote)
		{
			if(!this.inGround)
			{
				this.world.addParticle(ParticleTypes.FLAME, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D);
			}
		}
	}
	
	
	private void spawnGroundParticles(double x, double y, double z)
	{
		for(int i=0; i<5; i++) {
			this.world.addParticle(ParticleTypes.CLOUD, x, y, z, (0.25-Math.random()*0.5)*0.3, (0.25-Math.random()*0.5)*0.3, (0.25-Math.random()*0.5)*0.3);
		}
	}
	
	private void spawnSparkParticles(double x, double y, double z)
	{
		for(int i=0; i<5; i++) {
			this.world.addParticle(ParticleTypes.CRIT, x+Math.random()*1, y+Math.random()*1, z+Math.random()*1, 1-Math.random()*2, 1-Math.random()*2, 1-Math.random()*2);
		}
	}
	
	private void spawnBloodParticles(double x, double y, double z)
	{
		for(int i=0; i<10; i++) {
			this.world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, x, y, z, (1-Math.random()*2)*0.5, (1-Math.random()*2)*0.5, (1-Math.random()*2)*0.5);
		}
	}
	

}
