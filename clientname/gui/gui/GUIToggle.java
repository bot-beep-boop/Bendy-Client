package clientname.gui.gui;

import net.minecraft.client.resources.*;
import net.minecraft.client.gui.*;
import clientname.*;
import java.io.*;

public class GUIToggle extends GuiScreen
{
    private GuiScreen guiscreen;
    private boolean clear;
    private final GuiScreen field_146598_a;
    private GuiButton field_146596_f;
    private GuiButton field_146597_g;
    private String field_146599_h;
    private boolean field_146600_i;
    
    public GUIToggle(final GuiScreen p_i1055_1_) {
        this.field_146599_h = "survival";
        this.field_146598_a = p_i1055_1_;
    }
    
    public void openConfigScreen() {
        this.mc.displayGuiScreen(new GUIToggle(this));
    }
    
    @Override
    public void initGui() {
        this.buttonList.add(new GuiButton(2001, this.width / 2 - 125, this.height / 2 - 90, 250, 20, I18n.format("Ingame Mods", new Object[0])));
        this.buttonList.add(new GuiButton(2002, this.width / 2 - 125, this.height / 2 - 65, 250, 20, I18n.format("Cosmetics", new Object[0])));
        this.buttonList.add(new GuiButton(2004, this.width / 2 - 125, this.height / 2 - 40, 250, 20, I18n.format("Other Mods", new Object[0])));
        this.buttonList.add(new GuiButton(2003, this.width / 2 - 75, this.height / 2 - 15, 150, 20, I18n.format("Customize Modposition", new Object[0])));
    }
    
    private void func_146595_g() {
        this.field_146597_g.displayString = String.valueOf(I18n.format("selectWorld.gameMode", new Object[0])) + " " + I18n.format("selectWorld.gameMode." + this.field_146599_h, new Object[0]);
        this.field_146596_f.displayString = String.valueOf(I18n.format("selectWorld.allowCommands", new Object[0])) + " ";
        if (this.field_146600_i) {
            this.field_146596_f.displayString = String.valueOf(this.field_146596_f.displayString) + I18n.format("options.on", new Object[0]);
        }
        else {
            this.field_146596_f.displayString = String.valueOf(this.field_146596_f.displayString) + I18n.format("options.off", new Object[0]);
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton button) throws IOException {
        switch (button.id) {
            case 2001: {
                this.mc.displayGuiScreen(new GuiIngameMods(this));
                break;
            }
            case 2002: {
                this.mc.displayGuiScreen(new GuiCosmetics(this));
                break;
            }
            case 2004: {
                this.mc.displayGuiScreen(new GuiOtherMods(this));
                break;
            }
            case 2003: {
                if (this.guiscreen instanceof GuiMainMenu) {
                    Client.getInstance().getHudManager().openConfigScreenPaused();
                    break;
                }
                Client.getInstance().getHudManager().openConfigScreen();
                break;
            }
            case 2005: {
                this.mc.displayGuiScreen(new GuiAppearance(this));
                break;
            }
        }
    }
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        this.drawDefaultBackground();
        this.drawString(this.fontRendererObj, String.valueOf(Client.ModFarbe) + Client.ClientName + " Settings", this.width / 2 - Client.guiToggleClientName, this.height / 2 - 130, -1);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
