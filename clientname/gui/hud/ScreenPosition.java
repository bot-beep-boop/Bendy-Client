package clientname.gui.hud;

import net.minecraft.client.*;
import net.minecraft.client.gui.*;

public class ScreenPosition
{
    private static final Minecraft mc;
    private int x;
    private int y;
    
    static {
        mc = Minecraft.getMinecraft();
    }
    
    public ScreenPosition(final double x, final double y) {
        this.setRelative(x, y);
    }
    
    public ScreenPosition(final int x, final int y) {
        this.setAbsolute(x, y);
    }
    
    public static ScreenPosition fromRelativePosition(final double x, final double y) {
        return new ScreenPosition(x, y);
    }
    
    public static ScreenPosition fromAbsolute(final int x, final int y) {
        return new ScreenPosition(x, y);
    }
    
    public int getAbsoluteX() {
        return this.x;
    }
    
    public int getAbsoluteY() {
        return this.y;
    }
    
    public double getRelativeX() {
        final ScaledResolution sr = new ScaledResolution(ScreenPosition.mc);
        return this.x / sr.getScaledWidth_double();
    }
    
    public double getRelativeY() {
        final ScaledResolution sr = new ScaledResolution(ScreenPosition.mc);
        return this.y / sr.getScaledHeight_double();
    }
    
    public void setAbsolute(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setRelative(final double x, final double y) {
        final ScaledResolution sr = new ScaledResolution(ScreenPosition.mc);
        this.x = (int)(sr.getScaledWidth() / x);
        this.y = (int)(sr.getScaledHeight() / y);
    }
}
