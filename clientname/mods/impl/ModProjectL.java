package clientname.mods.impl;

import clientname.mods.*;
import clientname.event.impl.*;
import net.minecraft.client.*;
import net.minecraft.client.entity.*;
import clientname.event.*;
import clientname.gui.hud.*;

public class ModProjectL extends ModDraggable
{
    @Override
    public int getWidth() {
        return ModProjectL.font.getStringWidth("");
    }
    
    @Override
    public int getHeight() {
        return ModProjectL.font.FONT_HEIGHT;
    }
    
    @EventTarget
    public void onMouse(final MouseEvent event) {
        if (this.isEnabled() && (event.dx != 0 || event.dy != 0)) {
            final EntityPlayerSP entity = Minecraft.getMinecraft().thePlayer;
            if (entity != null) {
                entity.prevRenderYawOffset = entity.renderYawOffset;
                entity.prevRotationYawHead = entity.rotationYawHead;
                entity.prevRotationYaw = entity.rotationYaw;
                entity.prevRotationPitch = entity.rotationPitch;
            }
        }
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        ModProjectL.font.drawString("", pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
    }
}
