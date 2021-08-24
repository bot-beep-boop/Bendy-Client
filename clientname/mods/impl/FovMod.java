package clientname.mods.impl;

import clientname.mods.*;
import clientname.gui.hud.*;
import clientname.*;
import net.minecraft.client.*;

public class FovMod extends ModDraggable
{
    private static float savedFOV;
    
    static {
        FovMod.savedFOV = 0.0f;
    }
    
    @Override
    public int getWidth() {
        return FovMod.font.getStringWidth("[DynamicFov On]");
    }
    
    @Override
    public int getHeight() {
        return FovMod.font.FONT_HEIGHT;
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        if (Client.DynamicFOV) {
            if (!Client.ChromaText) {
                FovMod.font.drawStringWithShadow(String.valueOf(Client.KlammerFarbe) + "[" + Client.ModFarbe + "DynamicFov On" + Client.KlammerFarbe + "]", (float)pos.getAbsoluteX(), (float)pos.getAbsoluteY(), -1);
            }
            else {
                ChromaText.drawChromaString("DynamicFov On", pos.getAbsoluteX(), pos.getAbsoluteY(), true);
            }
            FovMod.savedFOV = Minecraft.getMinecraft().gameSettings.fovSetting;
            if (this.mc.thePlayer.isSprinting()) {
                Minecraft.getMinecraft().gameSettings.fovSetting = FovMod.savedFOV;
            }
            else if (this.mc.thePlayer.isPotionActive(1)) {
                Minecraft.getMinecraft().gameSettings.fovSetting = FovMod.savedFOV;
            }
            else if (this.mc.thePlayer.capabilities.isFlying) {
                Minecraft.getMinecraft().gameSettings.fovSetting = FovMod.savedFOV;
            }
        }
    }
}
