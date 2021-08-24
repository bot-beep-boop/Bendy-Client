package client;

import java.awt.*;
import net.minecraft.client.*;
import java.io.*;
import net.minecraft.client.gui.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;

public class ButtonToggle extends GuiButton
{
    Color off;
    Color on;
    Color c;
    
    public ButtonToggle(final int i, final int j, final int k, final String s) {
        this(i, j, k, 120, 20, s);
    }
    
    public ButtonToggle(final int i, final int j, final int k, final int l, final int i1, final String s) {
        super(i, j, k, l, i1, s);
        this.off = new Color(-4342339);
        this.on = new Color(-16711936);
        this.c = new Color(-1);
        this.enabled = true;
        this.visible = true;
    }
    
    @Override
    protected int getHoverState(final boolean flag) {
        byte byte0 = 1;
        if (!this.enabled) {
            byte0 = 0;
        }
        else if (flag) {
            byte0 = 2;
        }
        return byte0;
    }
    
    @Override
    public void drawButton(final Minecraft mc, final int mx, final int my) {
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        if (load(this.displayString)) {
            this.drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, this.height / 2, this.on);
            this.drawCircle(this.xPosition + this.width - this.height + 1, this.yPosition + 1, this.height - 2, this.height - 2, this.c);
        }
        else {
            this.drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, this.height / 2, this.off);
            this.drawCircle(this.xPosition + 1, this.yPosition + 1, this.height - 2, this.height - 2, this.c);
        }
    }
    
    public static File getFolder(final String toggle) {
        final File file = new File(FileManagerButton.TOGGLE_DIR, toggle);
        file.mkdirs();
        return file;
    }
    
    public static void save(final String toggle, final Boolean b) {
        FileManagerButton.writeJsonToFile(new File(getFolder(toggle), "Toggle.json"), b);
    }
    
    public static Boolean load(final String toggle) {
        Boolean b = FileManagerButton.readFromJson(new File(getFolder(toggle), "Toggle.json"), Boolean.class);
        if (b == null) {
            b = false;
            save(toggle, b);
        }
        return b;
    }
    
    private void drawRoundedRect(final int x, final int y, final int width, final int height, final int cornerRadius, final Color color) {
        Gui.drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
        Gui.drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
        Gui.drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());
        this.drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
        this.drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
        this.drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
        this.drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
    }
    
    private void drawArc(final int x, final int y, final int radius, final int startAngle, final int endAngle, final Color color) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f);
        final WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
        worldRenderer.begin(6, DefaultVertexFormats.POSITION);
        worldRenderer.pos(x, y, 0.0).endVertex();
        for (int i = (int)(startAngle / 360.0 * 100.0); i <= (int)(endAngle / 360.0 * 100.0); ++i) {
            final double angle = 6.283185307179586 * i / 100.0 + Math.toRadians(180.0);
            worldRenderer.pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0.0).endVertex();
        }
        Tessellator.getInstance().draw();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    private void drawCircle(final int x, final int y, final int width, final int height, final Color color) {
        this.drawArc(x + width / 2, y + height / 2, width / 2, 0, 360, color);
    }
}
