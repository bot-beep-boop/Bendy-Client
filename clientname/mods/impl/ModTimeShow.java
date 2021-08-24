package clientname.mods.impl;

import clientname.mods.*;
import clientname.gui.hud.*;
import java.text.*;
import java.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import clientname.*;

public class ModTimeShow extends ModDraggable
{
    @Override
    public int getWidth() {
        return ModTimeShow.font.getStringWidth("Time: AA:AA:AA AA ");
    }
    
    @Override
    public int getHeight() {
        return ModTimeShow.font.FONT_HEIGHT;
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        if (Client.ModTimeShow) {
            if (!Client.ChromaText) {
                final String pattern = "hh:mm:ss a ";
                final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                final String time = simpleDateFormat.format(new Date());
                GlStateManager.pushMatrix();
                Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(String.valueOf(Client.KlammerFarbe)) + "[" + Client.ModFarbe + "Time" + Client.KlammerFarbe + "] " + time, (float)pos.getAbsoluteX(), (float)pos.getAbsoluteY(), -1);
                GlStateManager.popMatrix();
            }
            else {
                final String pattern = "hh:mm:ss a ";
                final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                final String time = simpleDateFormat.format(new Date());
                ChromaText.drawChromaString("[Time] " + time, pos.getAbsoluteX(), pos.getAbsoluteY(), true);
            }
        }
    }
}
