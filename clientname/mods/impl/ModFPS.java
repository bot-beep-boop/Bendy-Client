package clientname.mods.impl;

import clientname.mods.*;
import clientname.gui.hud.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import clientname.*;

public class ModFPS extends ModDraggable
{
    @Override
    public int getWidth() {
        return 50;
    }
    
    @Override
    public int getHeight() {
        return ModFPS.font.FONT_HEIGHT;
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        if (Client.ModFPS) {
            if (!Client.ChromaText) {
                GlStateManager.pushMatrix();
                Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(String.valueOf(Client.KlammerFarbe)) + "[" + Client.ModFarbe + "FPS" + Client.KlammerFarbe + "] " + Minecraft.getDebugFPS(), (float)pos.getAbsoluteX(), (float)pos.getAbsoluteY(), -1);
                GlStateManager.popMatrix();
            }
            else {
                ChromaText.drawChromaString("[FPS] " + Minecraft.getDebugFPS(), pos.getAbsoluteX(), pos.getAbsoluteY(), true);
            }
        }
    }
}
