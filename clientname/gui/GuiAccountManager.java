package clientname.gui;

import net.minecraft.client.gui.*;
import net.minecraft.util.*;
import java.io.*;
import clientname.*;

public class GuiAccountManager extends GuiScreen
{
    protected CustomTextField mailInput;
    protected CustomTextField passInput;
    
    @Override
    public void initGui() {
        final ScaledResolution sr = new ScaledResolution(this.mc);
        (this.mailInput = new CustomTextField(101, this.mc.fontRendererObj, sr.getScaledWidth() / 2 - 50 + 40 - 52, sr.getScaledHeight() / 2 - 35, 180, 15)).setMaxStringLength(100);
        this.passInput = new CustomTextField(101, this.mc.fontRendererObj, sr.getScaledWidth() / 2 - 50 + 40 - 52, sr.getScaledHeight() / 2 - 15, 180, 15);
        this.buttonList.add(new GuiButton(1, sr.getScaledWidth() / 2 - 39 - 36 - 50, sr.getScaledHeight() / 2 + 15 + 5, 251, 20, "Login"));
    }
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        this.drawDefaultBackground();
        final ScaledResolution sr = new ScaledResolution(this.mc);
        GuiUtils.drawRoundedRect(sr.getScaledWidth() / 2 - 80 - 48, sr.getScaledHeight() / 2 - 40, sr.getScaledWidth() / 2 + 80 + 50, sr.getScaledHeight() / 2 + 45, 1.0f, -116585203);
        this.mc.fontRendererObj.drawString("E-Mail:", sr.getScaledWidth() / 2 - 75 + 10 - 50, sr.getScaledHeight() / 2 - 39 + this.mc.fontRendererObj.FONT_HEIGHT, -1);
        this.mc.fontRendererObj.drawString("Password:", sr.getScaledWidth() / 2 - 75 + 10 - 50, sr.getScaledHeight() / 2 - 20 + this.mc.fontRendererObj.FONT_HEIGHT, -1);
        this.mc.fontRendererObj.drawString("Username: " + EnumChatFormatting.GREEN + this.mc.getSession().getUsername(), sr.getScaledWidth() / 2 - 75 + 10 - 50, sr.getScaledHeight() / 2 + this.mc.fontRendererObj.FONT_HEIGHT, -1);
        this.mailInput.drawTextBox();
        this.mailInput.drawTextBox();
        this.passInput.drawTextBox();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @Override
    protected void keyTyped(final char typedChar, final int keyCode) throws IOException {
        this.mailInput.textboxKeyTyped(typedChar, keyCode);
        this.passInput.textboxKeyTyped(typedChar, keyCode);
        super.keyTyped(typedChar, keyCode);
    }
    
    @Override
    protected void mouseClicked(final int mouseX, final int mouseY, final int mouseButton) throws IOException {
        final ScaledResolution sr = new ScaledResolution(this.mc);
        if (mouseY > sr.getScaledHeight() / 2 + 15 && mouseY < sr.getScaledHeight() / 2 + 30 + 10 && mouseX > sr.getScaledWidth() / 2 - 40 - 12 && mouseX < sr.getScaledWidth() / 2 - 40 - 12 + 100 && !this.mailInput.getText().isEmpty()) {
            SessionChanger.getInstance().setUser(this.mailInput.getText(), this.passInput.getText());
        }
        this.mailInput.mouseClicked(mouseX, mouseY, mouseButton);
        this.passInput.mouseClicked(mouseX, mouseY, mouseButton);
    }
    
    @Override
    public void updateScreen() {
        this.mailInput.updateCursorCounter();
        this.passInput.updateCursorCounter();
    }
}
