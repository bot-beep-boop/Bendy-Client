package net.minecraft.client.gui;

import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;

public class GuiButtonLanguage extends GuiButton
{
    public GuiButtonLanguage(final int buttonID, final int xPos, final int yPos) {
        super(buttonID, xPos, yPos, 20, 20, "");
    }
    
    @Override
    public void drawButton(final Minecraft mc, final int mouseX, final int mouseY) {
        if (this.visible) {
            mc.getTextureManager().bindTexture(new ResourceLocation("language.png"));
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final boolean flag = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
            int i = 106;
            if (flag) {
                i += this.height;
            }
            Gui.drawTexturedModalRect(this.xPosition, this.yPosition, 0, i, this.width, this.height);
        }
    }
}
