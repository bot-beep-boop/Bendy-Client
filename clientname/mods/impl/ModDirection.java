package clientname.mods.impl;

import clientname.mods.*;
import clientname.gui.hud.*;
import net.minecraft.util.*;
import net.minecraft.client.gui.*;

public class ModDirection extends ModDraggable
{
    protected static ScaledResolution scaledResolution;
    public static String markerColor;
    public static int compassIndex;
    
    static {
        ModDirection.markerColor = "c";
        ModDirection.compassIndex = 0;
    }
    
    @Override
    public int getWidth() {
        return 102;
    }
    
    @Override
    public int getHeight() {
        return 15;
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        final int direction = MathHelper.floor_double(this.mc.thePlayer.rotationYaw * 256.0f / 360.0f + 0.5) & 0xFF;
        final int yBase = getY(1, 12);
        final int xBase = getX(65);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("Direction.png"));
        if (direction < 128) {
            Gui.drawTexturedModalRect(pos.getAbsoluteX() + xBase - 64, pos.getAbsoluteY() + yBase - 10, direction, ModDirection.compassIndex * 24, 100, 13);
        }
        else {
            Gui.drawTexturedModalRect(pos.getAbsoluteX() + xBase - 64, pos.getAbsoluteY() + yBase - 10, direction - 128, ModDirection.compassIndex * 24 + 12, 100, 13);
        }
        this.mc.fontRendererObj.drawString("§" + ModDirection.markerColor.toLowerCase() + "|§r", pos.getAbsoluteX() + xBase - 16, pos.getAbsoluteY() + yBase - 7, 16777215);
    }
    
    @Override
    public void renderDummy(final ScreenPosition pos) {
        final int direction = MathHelper.floor_double(this.mc.thePlayer.rotationYaw * 256.0f / 360.0f + 0.5) & 0xFF;
        final int yBase = getY(1, 12);
        final int xBase = getX(65);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("Direction.png"));
        if (direction < 128) {
            Gui.drawTexturedModalRect(pos.getAbsoluteX() + xBase - 64, pos.getAbsoluteY() + yBase - 10, direction, ModDirection.compassIndex * 24, 100, 13);
        }
        else {
            Gui.drawTexturedModalRect(pos.getAbsoluteX() + xBase - 64, pos.getAbsoluteY() + yBase - 10, direction - 128, ModDirection.compassIndex * 24 + 12, 100, 13);
        }
        this.mc.fontRendererObj.drawString("§" + ModDirection.markerColor.toLowerCase() + "|§r", pos.getAbsoluteX() + xBase - 16, pos.getAbsoluteY() + yBase - 7, 16777215);
    }
    
    private static int getX(final int width) {
        return width;
    }
    
    private static int getY(final int rowCount, final int height) {
        return height;
    }
    
    public enum Direction
    {
        S("S", 0), 
        SW("SW", 1), 
        W("W", 2), 
        NW("NW", 3), 
        N("N", 4), 
        NE("NE", 5), 
        E("E", 6), 
        SE("SE", 7);
        
        private Direction(final String s, final int n) {
        }
    }
}
