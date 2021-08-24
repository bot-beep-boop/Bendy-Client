package net.minecraft.entity.monster;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntityGiantZombie extends EntityMob
{
    public EntityGiantZombie(final World worldIn) {
        super(worldIn);
        this.setSize(this.width * 6.0f, this.height * 6.0f);
    }
    
    @Override
    public float getEyeHeight() {
        return 10.440001f;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(50.0);
    }
    
    @Override
    public float getBlockPathWeight(final BlockPos pos) {
        return this.worldObj.getLightBrightness(pos) - 0.5f;
    }
}
