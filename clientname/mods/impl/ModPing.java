package clientname.mods.impl;

import clientname.mods.*;
import net.minecraft.client.*;
import clientname.gui.hud.*;
import net.minecraft.client.renderer.*;
import clientname.*;

public class ModPing extends ModDraggable
{
    @Override
    public int getWidth() {
        return ModPing.font.getStringWidth("Ping: " + Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()).getResponseTime());
    }
    
    @Override
    public int getHeight() {
        return ModPing.font.FONT_HEIGHT;
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        if (Client.ModPing) {
            if (!Client.ChromaText) {
                GlStateManager.pushMatrix();
                Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(String.valueOf(Client.KlammerFarbe)) + "[" + Client.ModFarbe + "Ping" + Client.KlammerFarbe + "] " + Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()).getResponseTime(), (float)pos.getAbsoluteX(), (float)pos.getAbsoluteY(), -1);
                GlStateManager.popMatrix();
            }
            else {
                ChromaText.drawChromaString("[Ping] " + Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()).getResponseTime(), pos.getAbsoluteX(), pos.getAbsoluteY(), true);
            }
        }
    }
}
