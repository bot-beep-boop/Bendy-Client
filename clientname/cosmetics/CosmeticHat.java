package clientname.cosmetics;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.client.entity.*;
import clientname.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class CosmeticHat extends Cosmetic
{
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    
    public CosmeticHat(final RenderPlayer player) {
        super(player);
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Shape1 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 10, 1, 10);
        this.Shape1.setRotationPoint(-5.0f, -9.0f, -5.0f);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        (this.Shape2 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 5, 8);
        this.Shape2.setRotationPoint(-4.0f, -14.0f, -4.0f);
        this.Shape2.setTextureSize(64, 32);
        this.Shape2.mirror = true;
    }
    
    @Override
    public void render(final AbstractClientPlayer player, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float headYaw, final float headPitch, final float scale) {
        if (Client.CosmeticHat) {
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
            this.Shape1.render(scale);
            this.Shape2.render(scale);
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
