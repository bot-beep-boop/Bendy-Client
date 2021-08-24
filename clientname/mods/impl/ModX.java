package clientname.mods.impl;

import clientname.mods.*;
import clientname.gui.hud.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import clientname.*;

public class ModX extends ModDraggable
{
    @Override
    public int getWidth() {
        return 38;
    }
    
    @Override
    public int getHeight() {
        return 10;
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        if (Client.ModPosition) {
            if (!Client.ChromaText) {
                GlStateManager.pushMatrix();
                Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(String.valueOf(Client.KlammerFarbe)) + "[" + Client.ModFarbe + "X" + Client.KlammerFarbe + "] " + Math.round(Minecraft.getMinecraft().thePlayer.posX * 1000.0) / 1000L, (float)pos.getAbsoluteX(), (float)pos.getAbsoluteY(), -1);
                GlStateManager.popMatrix();
            }
            else {
                ChromaText.drawChromaString("[X] " + Math.round(Minecraft.getMinecraft().thePlayer.posX * 1000.0) / 1000L, pos.getAbsoluteX(), pos.getAbsoluteY(), true);
            }
        }
    }
}
