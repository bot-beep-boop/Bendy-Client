package clientname.cosmetics;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.client.entity.*;
import clientname.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class CosmeticCap extends Cosmetic
{
    ModelRenderer Cap1;
    ModelRenderer Cap2;
    ModelRenderer Cap3;
    ModelRenderer Cap4;
    ModelRenderer Cap5;
    ModelRenderer Cap6;
    ModelRenderer cap7;
    
    public CosmeticCap(final RenderPlayer player) {
        super(player);
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Cap1 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 1, 11);
        this.Cap1.setRotationPoint(-4.0f, -9.0f, -7.0f);
        this.Cap1.setTextureSize(64, 32);
        this.Cap1.mirror = true;
        (this.Cap2 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 1, 1);
        this.Cap2.setRotationPoint(-4.0f, -9.0f, -8.0f);
        this.Cap2.setTextureSize(64, 32);
        this.Cap2.mirror = true;
        (this.Cap3 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 3, 1);
        this.Cap3.setRotationPoint(-4.0f, -12.0f, -4.0f);
        this.Cap3.setTextureSize(64, 32);
        this.Cap3.mirror = true;
        (this.Cap4 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 3, 1);
        this.Cap4.setRotationPoint(-4.0f, -12.0f, 3.0f);
        this.Cap4.setTextureSize(64, 32);
        this.Cap4.mirror = true;
        (this.Cap5 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 6);
        this.Cap5.setRotationPoint(-4.0f, -12.0f, -3.0f);
        this.Cap5.setTextureSize(64, 32);
        this.Cap5.mirror = true;
        (this.Cap6 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 6);
        this.Cap6.setRotationPoint(3.0f, -12.0f, -3.0f);
        this.Cap6.setTextureSize(64, 32);
        this.Cap6.mirror = true;
        (this.cap7 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 6, 1, 6);
        this.cap7.setRotationPoint(-3.0f, -12.0f, -3.0f);
        this.cap7.setTextureSize(64, 32);
        this.cap7.mirror = true;
    }
    
    @Override
    public void render(final AbstractClientPlayer player, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float headYaw, final float headPitch, final float scale) {
        if (Client.CosmeticCap) {
            GlStateManager.pushMatrix();
            final float f = partialTicks;
            final float f2 = this.getFirstRotationX(player, f);
            final float f3 = this.getSecondRotationX(player, f);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.setRotationAngles(limbSwing, limbSwingAmount, partialTicks, ageInTicks, headYaw, headPitch, player);
            Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("cap.png"));
            GlStateManager.rotate(f2, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(f3, 1.0f, 0.0f, 0.0f);
            GlStateManager.disableLighting();
            if (player.isSneaking()) {
                GlStateManager.translate(0.0, 0.26, -0.047);
            }
            this.Cap1.render(scale);
            this.Cap2.render(scale);
            this.Cap3.render(scale);
            this.Cap4.render(scale);
            this.Cap5.render(scale);
            this.Cap6.render(scale);
            this.cap7.render(scale);
            GlStateManager.popMatrix();
        }
    }
    
    private float getFirstRotationX(final AbstractClientPlayer Player, final float partialTicks) {
        float f = this.interpolateRotation(Player.prevRenderYawOffset, Player.renderYawOffset, partialTicks);
        final float f2 = this.interpolateRotation(Player.prevRotationYawHead, Player.rotationYawHead, partialTicks);
        float f3 = f2 - f;
        if (Player.isRiding() && Player.ridingEntity instanceof EntityLivingBase) {
            final EntityLivingBase entitylivingbase = (EntityLivingBase)Player.ridingEntity;
            f = this.interpolateRotation(entitylivingbase.prevRenderYawOffset, entitylivingbase.renderYawOffset, partialTicks);
            f3 = f2 - f;
            float f4 = MathHelper.wrapAngleTo180_float(f3);
            if (f4 < -85.0f) {
                f4 = -85.0f;
            }
            if (f4 >= 85.0f) {
                f4 = 85.0f;
            }
            f = f2 - f4;
            if (f4 * f4 > 2500.0f) {}
        }
        return f3;
    }
    
    private float getSecondRotationX(final AbstractClientPlayer Player, final float partialTicks) {
        return Player.prevRotationPitch + (Player.rotationPitch - Player.prevRotationPitch) * partialTicks;
    }
    
    private float interpolateRotation(final float par1, final float par2, final float par3) {
        float f;
        for (f = par2 - par1; f < -180.0f; f += 360.0f) {}
        while (f >= 180.0f) {
            f -= 360.0f;
        }
        return par1 + par3 * f;
    }
    
    @Override
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
