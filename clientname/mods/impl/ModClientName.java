package clientname.mods.impl;

import clientname.mods.*;
import clientname.gui.hud.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import clientname.*;

public class ModClientName extends ModDraggable
{
    @Override
    public int getWidth() {
        return ModClientName.font.getStringWidth(String.valueOf(String.valueOf(Client.ModFarbe)) + Client.ClientName);
    }
    
    @Override
    public int getHeight() {
        return ModClientName.font.FONT_HEIGHT;
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        if (!Client.ChromaText) {
            GlStateManager.pushMatrix();
            Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(String.valueOf(Client.ModFarbe)) + Client.ClientName, (float)pos.getAbsoluteX(), (float)pos.getAbsoluteY(), -1);
            GlStateManager.popMatrix();
        }
        else {
            ChromaText.drawChromaString(Client.ClientName, pos.getAbsoluteX(), pos.getAbsoluteY(), true);
        }
    }
}
