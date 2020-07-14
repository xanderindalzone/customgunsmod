package com.xanderindalzone.customgunsmod.entities.projectiles;

import com.xanderindalzone.customgunsmod.init.InitItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class PistolBulletEntity extends AbstractArrowEntity 
{
	
	
	//HIT BOOLEANS
	public boolean IRON_HIT=false;
	public boolean GLASS_HIT=false;
	
	//PROJECTILE PROPERTIES
	public float bullet_damage=0;
	public double DISTANCE_NO_GRAVITY=10;
	private boolean hasFirstUpdated=false;
	public double initPosX;
	public double initPosY;
	public double initPosZ;
	
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

	@Override
	public IPacket<?> createSpawnPacket() {
		// TODO Auto-generated method stub
		return NetworkHooks.getEntitySpawningPacket(this);
	}
	
	@Override
	protected ItemStack getArrowStack() {
		return new ItemStack(InitItems.BULLET_CAL_45.get()); //Init.BULLET_CAL_45 OLD
	}
	
//==========================================================================================================
//==========================================================================================================	
	
	
	
	
	
	public void setBulletDamage(float damage)
	{
		this.bullet_damage=damage;
	}
	

	
	
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
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
	
	
	
	

}
