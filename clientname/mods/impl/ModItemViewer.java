package clientname.mods.impl;

import clientname.mods.*;
import clientname.gui.hud.*;
import clientname.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;

public class ModItemViewer extends ModDraggable
{
    private ScreenPosition pos;
    
    @Override
    public int getWidth() {
        return 40;
    }
    
    @Override
    public int getHeight() {
        return 17;
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        if (Client.ModItemViewer) {
            this.renderItemStack(pos, 3, this.mc.thePlayer.getCurrentEquippedItem());
        }
    }
    
    @Override
    public void renderDummy(final ScreenPosition pos) {
        if (Client.ModItemViewer) {
            this.renderItemStack(pos, 3, new ItemStack(Items.golden_sword));
        }
    }
    
    private void renderItemStack(final ScreenPosition pos, final int i, final ItemStack is) {
        if (is == null) {
            return;
        }
        GL11.glPushMatrix();
        final int yAdd = -16 * i + 48;
        if (is.getItem().isDamageable()) {
            final double damage = (is.getMaxDamage() - is.getItemDamage()) / (double)is.getMaxDamage() * 100.0;
            ModItemViewer.font.drawString(String.format("%.2f%%", damage), pos.getAbsoluteX() + 20, pos.getAbsoluteY() + yAdd + 5, 16777215);
        }
        RenderHelper.enableGUIStandardItemLighting();
        this.mc.getRenderItem().renderItemAndEffectIntoGUI(is, pos.getAbsoluteX(), pos.getAbsoluteY() + yAdd);
        GL11.glPopMatrix();
    }
}
