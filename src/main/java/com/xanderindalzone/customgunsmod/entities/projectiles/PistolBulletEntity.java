package com.xanderindalzone.customgunsmod.entities.projectiles;

import java.util.function.Supplier;

import com.xanderindalzone.customgunsmod.init.InitItems;
import com.xanderindalzone.customgunsmod.init.InitSounds;
import com.xanderindalzone.customgunsmod.packets.PacketHandler;
import com.xanderindalzone.customgunsmod.packets.messages.HitMarkerMessage;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
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
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
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
	public double dirX;
	public double dirY;
	public double dirZ;
	public PlayerEntity shooter;
	public float speed;
	
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
	public PistolBulletEntity(EntityType<? extends AbstractArrowEntity> type, double x, double y, double z, World worldIn, PlayerEntity shooter, float damage, float speed) 
	{
		super(type, x, y, z, worldIn);
		this.bullet_damage=damage;
		this.shooter=shooter;
		setNoGravity(true);
		this.speed=speed;
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
		
		double hitx;
		double hity;
		double hitz;
		
		if(result.getType() == RayTraceResult.Type.ENTITY)
		{
			EntityRayTraceResult entityResult = (EntityRayTraceResult) result;
			if(entityResult.getEntity() instanceof LivingEntity) {
				LivingEntity entityHit = (LivingEntity) entityResult.getEntity();
				entityHit.attackEntityFrom(DamageSource.causeArrowDamage(this, entityHit), this.bullet_damage);
				
//				hitx = entityHit.getPosX();
//				hity = entityHit.getPosY();
//				hitz = entityHit.getPosZ();;
//				
//				this.setRawPosition(hitx, hity, hitz);
				
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
				spawnBloodParticles(this.getPosX(), this.getPosY()+1, this.getPosZ());
				this.remove();
			}
		}
		else if(result.getType() == RayTraceResult.Type.BLOCK)
		{
			BlockRayTraceResult blockResult = (BlockRayTraceResult)result;
			hitx = blockResult.getPos().getX();
			hity = blockResult.getPos().getY();
			hitz = blockResult.getPos().getZ();
			this.setRawPosition(hitx, hity, hitz);
			checkAdditionalImpact();
			if(!GLASS_HIT&&!IRON_HIT) {
				spawnGroundParticles(this.getPosX(), this.getPosY(), this.getPosZ());
				this.world.playSound(null, this.getPosition(), InitSounds.SOUND_bullet_ground_impact.get(), SoundCategory.PLAYERS, 1.0F, 1.0F);
			}
			this.remove();
		}
		else
		{
			//DO STUFF
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
			dirX=this.getMotion().x;
			dirY=this.getMotion().y;
			dirZ=this.getMotion().z;
			//System.out.println("\nDir X: "+dirX+"\nDir Y: "+dirY+"\nDir Z: "+dirZ);
		}
		
		if(this.getMotion().x==0&&this.getMotion().y==0&&this.getMotion().z==0) {this.remove();}
		
		
		if(this.world.isRemote)
		{
			if(!this.inGround)
			{
				this.world.addParticle(ParticleTypes.FLAME, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D);
			}
			else
			{
				this.remove();
			}
		}
	}
	

	
	private void checkAdditionalImpact() {
		for(int x=-2; x<=2; x++) 
		{
			for(int y=-2; y<=2; y++) 
			{
				for(int z=-2; z<=2; z++) 
				{
					if(this.world.getBlockState(new BlockPos(this.getPosX()+x, this.getPosY()+y, this.getPosZ()+z)).getMaterial() == Material.GLASS)
					{
						this.world.playSound(null, this.getPosition(), SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.PLAYERS, 1.0F, 1.0F);
						GLASS_HIT=true;
						BlockPos hitPos = new BlockPos(new BlockPos(this.getPosX()+x, this.getPosY()+y, this.getPosZ()+z));
						ItemEntity droppedItem = new ItemEntity(this.world, this.getPosX()+x, this.getPosY()+y, this.getPosZ()+z, new ItemStack(Blocks.GLASS_PANE));
						if(!this.world.isRemote) {
							this.world.addEntity(droppedItem);
						}
						this.world.removeBlock(hitPos, false);
						spawnSparkParticles(this.getPosX()+x, this.getPosY()+y, this.getPosZ()+z);
					}
					if(this.world.getBlockState(new BlockPos(this.getPosX()+x, this.getPosY()+y, this.getPosZ()+z)).getMaterial() == Material.IRON)
					{
						spawnSparkParticles(this.getPosX(), this.getPosY(), this.getPosZ());
						this.world.playSound(null, this.getPosition(), SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.PLAYERS, 1.0F, 1.0F);
						IRON_HIT=true;
					}
				}
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
