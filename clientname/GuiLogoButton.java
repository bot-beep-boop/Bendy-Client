package clientname;

import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.gui.*;

public class GuiLogoButton extends GuiButtonScope
{
    ScaledResolution scaledResolution;
    ResourceLocation location;
    boolean isHead;
    
    public GuiLogoButton(final int buttonId, final ScaledResolution scaledResolution, final int x, final int y, final int widthIn, final int heightIn, final ResourceLocation location, final boolean isHead) {
        super(buttonId, x, y, widthIn, heightIn, "");
        this.scaledResolution = scaledResolution;
        this.location = location;
        this.isHead = isHead;
    }
    
    @Override
    public void drawButton(final Minecraft mc, final int mouseX, final int mouseY) {
        if (this.visible) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final boolean flag = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
            int i = 106;
            if (flag) {
                i += this.height;
            }
            mc.getTextureManager().bindTexture(this.location);
            if (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height) {
                if (this.isHead) {
                    GL11.glPushMatrix();
                    GL11.glScissor(0, (int)(575.0 / this.scaledResolution.getScale()) * this.scaledResolution.getScaleFactor(), (int)(62.0 / this.scaledResolution.getScale()) * this.scaledResolution.getScaleFactor() + 2, 100);
                    GL11.glEnable(3089);
                }
                Gui.drawScaledCustomSizeModalRect(this.xPosition - 10, this.yPosition - 10, -5.0f, -5.0f, this.width + 10, this.height + 10, this.width + 10, this.height + 10, (float)(this.width + 10), (float)(this.height + 10));
            }
            else {
                if (this.isHead) {
                    GL11.glPushMatrix();
                    GL11.glScissor(0, (int)(580.0 / this.scaledResolution.getScale()) * this.scaledResolution.getScaleFactor(), (int)(60.0 / this.scaledResolution.getScale()) * this.scaledResolution.getScaleFactor() + 2, 100);
                    GL11.glEnable(3089);
                }
                Gui.drawScaledCustomSizeModalRect(this.xPosition, this.yPosition, 0.0f, 0.0f, this.width, this.height, this.width, this.height, (float)this.width, (float)this.height);
            }
            if (this.isHead) {
                GL11.glDisable(3089);
                GL11.glPopMatrix();
            }
        }
    }
}
