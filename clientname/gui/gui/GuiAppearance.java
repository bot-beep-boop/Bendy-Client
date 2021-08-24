package clientname.gui.gui;

import clientname.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.realms.*;
import net.minecraft.client.gui.achievement.*;
import net.minecraft.client.gui.*;
import java.io.*;

public class GuiAppearance extends GuiScreen
{
    private final GuiScreen field_146598_a;
    private GuiButton field_146596_f;
    private GuiButton field_146597_g;
    private String field_146599_h;
    private boolean field_146600_i;
    
    public GuiAppearance(final GuiScreen p_i1055_1_) {
        this.field_146599_h = "survival";
        this.field_146598_a = p_i1055_1_;
    }
    
    @Override
    public void initGui() {
        if (Client.red) {
            this.buttonList.add(new GuiButton(1005, this.width / 2 - 61, this.height / 2 - 90, 120, 20, I18n.format("§cRed", new Object[0])));
        }
        else {
            this.buttonList.add(new GuiButton(1005, this.width / 2 - 61, this.height / 2 - 90, 120, 20, I18n.format("Red", new Object[0])));
        }
        if (Client.orange) {
            this.buttonList.add(new GuiButton(1006, this.width / 2 - 61, this.height / 2 - 66, 120, 20, I18n.format("§6Orange", new Object[0])));
        }
        else {
            this.buttonList.add(new GuiButton(1006, this.width / 2 - 61, this.height / 2 - 66, 120, 20, I18n.format("Orange", new Object[0])));
        }
        if (Client.yellow) {
            this.buttonList.add(new GuiButton(1007, this.width / 2 - 61, this.height / 2 - 42, 120, 20, I18n.format("§eYellow", new Object[0])));
        }
        else {
            this.buttonList.add(new GuiButton(1007, this.width / 2 - 61, this.height / 2 - 42, 120, 20, I18n.format("Yellow", new Object[0])));
        }
        if (Client.green) {
            this.buttonList.add(new GuiButton(1008, this.width / 2 - 61, this.height / 2 - 18, 120, 20, I18n.format("§aGreen", new Object[0])));
        }
        else {
            this.buttonList.add(new GuiButton(1008, this.width / 2 - 61, this.height / 2 - 18, 120, 20, I18n.format("Green", new Object[0])));
        }
        if (Client.cyan) {
            this.buttonList.add(new GuiButton(1009, this.width / 2 - 61, this.height / 2 + 6, 120, 20, I18n.format("§bCyan", new Object[0])));
        }
        else {
            this.buttonList.add(new GuiButton(1009, this.width / 2 - 61, this.height / 2 + 6, 120, 20, I18n.format("Cyan", new Object[0])));
        }
        if (Client.blue) {
            this.buttonList.add(new GuiButton(1010, this.width / 2 - 61, this.height / 2 + 30, 120, 20, I18n.format("§9Blue", new Object[0])));
        }
        else {
            this.buttonList.add(new GuiButton(1010, this.width / 2 - 61, this.height / 2 + 30, 120, 20, I18n.format("Blue", new Object[0])));
        }
        if (Client.pink) {
            this.buttonList.add(new GuiButton(1011, this.width / 2 - 61, this.height / 2 + 54, 120, 20, I18n.format("§dPink", new Object[0])));
        }
        else {
            this.buttonList.add(new GuiButton(1011, this.width / 2 - 61, this.height / 2 + 54, 120, 20, I18n.format("Pink", new Object[0])));
        }
        if (Client.purple) {
            this.buttonList.add(new GuiButton(1012, this.width / 2 - 61, this.height / 2 + 78, 120, 20, I18n.format("§5Purple", new Object[0])));
        }
        else {
            this.buttonList.add(new GuiButton(1012, this.width / 2 - 61, this.height / 2 + 78, 120, 20, I18n.format("Purple", new Object[0])));
        }
        this.buttonList.add(new GuiButton(1022, this.width / 2 - 91, this.height / 2 + 104, 180, 20, I18n.format("Back", new Object[0])));
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
            case 0: {
                this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
                break;
            }
            case 1: {
                final boolean flag = this.mc.isIntegratedServerRunning();
                final boolean flag2 = this.mc.func_181540_al();
                button.enabled = false;
                this.mc.theWorld.sendQuittingDisconnectingPacket();
                this.mc.loadWorld(null);
                if (flag) {
                    this.mc.displayGuiScreen(new GuiMainMenu());
                    break;
                }
                if (flag2) {
                    final RealmsBridge realmsbridge = new RealmsBridge();
                    realmsbridge.switchToRealms(new GuiMainMenu());
                    break;
                }
                this.mc.displayGuiScreen(new GuiMultiplayer(new GuiMainMenu()));
                break;
            }
            case 4: {
                this.mc.displayGuiScreen(null);
                this.mc.setIngameFocus();
                break;
            }
            case 5: {
                this.mc.displayGuiScreen(new GuiAchievements(this, this.mc.thePlayer.getStatFileWriter()));
                break;
            }
            case 6: {
                this.mc.displayGuiScreen(new GuiStats(this, this.mc.thePlayer.getStatFileWriter()));
                break;
            }
            case 7: {
                this.mc.displayGuiScreen(new GuiShareToLan(this));
                break;
            }
            case 8: {
                this.mc.displayGuiScreen(new GuiAppearance(this));
                break;
            }
            case 1005: {
                Client.red = !Client.red;
                if (Client.red) {
                    this.buttonList.set(0, new GuiButton(1005, this.width / 2 - 61, this.height / 2 - 90, 120, 20, I18n.format("§cRed", new Object[0])));
                    break;
                }
                this.buttonList.set(0, new GuiButton(1005, this.width / 2 - 61, this.height / 2 - 90, 120, 20, I18n.format("Red", new Object[0])));
                break;
            }
            case 1006: {
                Client.orange = !Client.orange;
                if (Client.orange) {
                    this.buttonList.set(1, new GuiButton(1006, this.width / 2 - 61, this.height / 2 - 66, 120, 20, I18n.format("§6Orange", new Object[0])));
                    break;
                }
                this.buttonList.set(1, new GuiButton(1006, this.width / 2 - 61, this.height / 2 - 66, 120, 20, I18n.format("Orange", new Object[0])));
                break;
            }
            case 1007: {
                Client.yellow = !Client.yellow;
                if (Client.yellow) {
                    this.buttonList.set(2, new GuiButton(1007, this.width / 2 - 61, this.height / 2 - 42, 120, 20, I18n.format("§eYellow", new Object[0])));
                    break;
                }
                this.buttonList.set(2, new GuiButton(1007, this.width / 2 - 61, this.height / 2 - 42, 120, 20, I18n.format("Yellow", new Object[0])));
                break;
            }
            case 1008: {
                Client.green = !Client.green;
                if (Client.green) {
                    this.buttonList.set(3, new GuiButton(1008, this.width / 2 - 61, this.height / 2 - 18, 120, 20, I18n.format("§aGreen", new Object[0])));
                    break;
                }
                this.buttonList.set(3, new GuiButton(1008, this.width / 2 - 61, this.height / 2 - 18, 120, 20, I18n.format("Green", new Object[0])));
                break;
            }
            case 1009: {
                Client.cyan = !Client.cyan;
                if (Client.cyan) {
                    this.buttonList.set(4, new GuiButton(1009, this.width / 2 - 61, this.height / 2 + 6, 120, 20, I18n.format("§bCyan", new Object[0])));
                    break;
                }
                this.buttonList.set(4, new GuiButton(1009, this.width / 2 - 61, this.height / 2 + 6, 120, 20, I18n.format("Cyan", new Object[0])));
                break;
            }
            case 1010: {
                Client.blue = !Client.blue;
                if (Client.blue) {
                    this.buttonList.set(5, new GuiButton(1010, this.width / 2 - 61, this.height / 2 + 30, 120, 20, I18n.format("§9Blue", new Object[0])));
                    break;
                }
                this.buttonList.set(5, new GuiButton(1010, this.width / 2 - 61, this.height / 2 + 30, 120, 20, I18n.format("Blue", new Object[0])));
                break;
            }
            case 1011: {
                Client.pink = !Client.pink;
                if (Client.pink) {
                    this.buttonList.set(6, new GuiButton(1011, this.width / 2 - 61, this.height / 2 + 54, 120, 20, I18n.format("§dPink", new Object[0])));
                    break;
                }
                this.buttonList.set(6, new GuiButton(1011, this.width / 2 - 61, this.height / 2 + 54, 120, 20, I18n.format("Pink", new Object[0])));
                break;
            }
            case 1012: {
                Client.purple = !Client.purple;
                if (Client.purple) {
                    this.buttonList.set(7, new GuiButton(1012, this.width / 2 - 61, this.height / 2 + 78, 120, 20, I18n.format("§5Purple", new Object[0])));
                    break;
                }
                this.buttonList.set(7, new GuiButton(1012, this.width / 2 - 61, this.height / 2 + 78, 120, 20, I18n.format("Purple", new Object[0])));
                break;
            }
            case 1022: {
                this.mc.displayGuiScreen(new GUIToggle(this));
                break;
            }
        }
    }
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        this.drawDefaultBackground();
        this.drawString(this.fontRendererObj, String.valueOf(Client.ModFarbe) + "Appearance", this.width / 2 - 32, this.height / 2 - 120, -1);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
