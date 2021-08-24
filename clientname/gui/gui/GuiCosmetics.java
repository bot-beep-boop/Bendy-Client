package clientname.gui.gui;

import clientname.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.realms.*;
import net.minecraft.client.gui.achievement.*;
import net.minecraft.client.gui.*;
import java.io.*;

public class GuiCosmetics extends GuiScreen
{
    private final GuiScreen field_146598_a;
    private static String Cape;
    private static String Wings;
    private static String ToggleSprint;
    private static String Halo;
    private static String FPS;
    private static String Keystrokes;
    private static String Ping;
    private static String ArmorStatus;
    private static String Time;
    private static String PotionStatus;
    private static String ModPosition;
    private GuiButton field_146596_f;
    private GuiButton field_146597_g;
    private String field_146599_h;
    private boolean field_146600_i;
    
    static {
        GuiCosmetics.Cape = "Cape";
        GuiCosmetics.Wings = "Wings";
        GuiCosmetics.ToggleSprint = "Toggle Sprint";
        GuiCosmetics.Halo = "Halo";
        GuiCosmetics.FPS = "FPS";
        GuiCosmetics.Keystrokes = "Keystrokes";
        GuiCosmetics.Ping = "Ping";
        GuiCosmetics.ArmorStatus = "Armor Status";
        GuiCosmetics.Time = "Time";
        GuiCosmetics.PotionStatus = "Potion Status";
        GuiCosmetics.ModPosition = "ModPosition";
    }
    
    public GuiCosmetics(final GuiScreen p_i1055_1_) {
        this.field_146599_h = "survival";
        this.field_146598_a = p_i1055_1_;
    }
    
    @Override
    public void initGui() {
        if (Client.CosmeticHalo) {
            this.buttonList.add(new GuiButton(1004, this.width / 2 - 61, this.height / 2 - 90, 120, 20, I18n.format("Halo: ON", new Object[0])));
        }
        else {
            this.buttonList.add(new GuiButton(1004, this.width / 2 - 61, this.height / 2 - 90, 120, 20, I18n.format("Halo: OFF", new Object[0])));
        }
        if (Client.DiamondHead) {
            this.buttonList.add(new GuiButton(1014, this.width / 2 - 61, this.height / 2 - 66, 120, 20, I18n.format("DiamondHead: ON", new Object[0])));
        }
        else {
            this.buttonList.add(new GuiButton(1014, this.width / 2 - 61, this.height / 2 - 66, 120, 20, I18n.format("DiamondHead: OFF", new Object[0])));
        }
        if (Client.CosmeticWitchHat) {
            this.buttonList.add(new GuiButton(1016, this.width / 2 - 61, this.height / 2 - 42, 120, 20, I18n.format("WitchHat: ON", new Object[0])));
        }
        else {
            this.buttonList.add(new GuiButton(1016, this.width / 2 - 61, this.height / 2 - 42, 120, 20, I18n.format("WitchHat: OFF", new Object[0])));
        }
        if (Client.CosmeticCape) {
            this.buttonList.add(new GuiButton(1003, this.width / 2 - 61, this.height / 2 - 18, 120, 20, I18n.format("Cape: ON", new Object[0])));
        }
        else {
            this.buttonList.add(new GuiButton(1003, this.width / 2 - 61, this.height / 2 - 18, 120, 20, I18n.format("Cape: OFF", new Object[0])));
        }
        if (Client.CosmeticWings) {
            this.buttonList.add(new GuiButton(1001, this.width / 2 - 61, this.height / 2 + 6, 120, 20, I18n.format("Wings: ON", new Object[0])));
        }
        else {
            this.buttonList.add(new GuiButton(1001, this.width / 2 - 61, this.height / 2 + 6, 120, 20, I18n.format("Wings: OFF", new Object[0])));
        }
        if (Client.CosmeticGhostWings) {
            this.buttonList.add(new GuiButton(1002, this.width / 2 - 61, this.height / 2 + 30, 120, 20, I18n.format("Ghost Wings: ON", new Object[0])));
        }
        else {
            this.buttonList.add(new GuiButton(1002, this.width / 2 - 61, this.height / 2 + 30, 120, 20, I18n.format("Ghost Wings: OFF", new Object[0])));
        }
        if (Client.CosmeticCap) {
            this.buttonList.add(new GuiButton(1005, this.width / 2 - 61, this.height / 2 + 54, 120, 20, I18n.format("Cap: ON", new Object[0])));
        }
        else {
            this.buttonList.add(new GuiButton(1005, this.width / 2 - 61, this.height / 2 + 54, 120, 20, I18n.format("Cap: OFF", new Object[0])));
        }
        if (Client.CosmeticHat) {
            this.buttonList.add(new GuiButton(1006, this.width / 2 - 61, this.height / 2 + 78, 120, 20, I18n.format("Hat: ON", new Object[0])));
        }
        else {
            this.buttonList.add(new GuiButton(1006, this.width / 2 - 61, this.height / 2 + 78, 120, 20, I18n.format("Hat: OFF", new Object[0])));
        }
        this.buttonList.add(new GuiButton(8, this.width / 2 - 91, this.height / 2 + 102, 180, 20, I18n.format("Back", new Object[0])));
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
            case 1001: {
                Client.CosmeticWings = !Client.CosmeticWings;
                if (Client.CosmeticWings) {
                    this.buttonList.set(4, new GuiButton(1001, this.width / 2 - 61, this.height / 2 + 6, 120, 20, I18n.format("Wings: ON", new Object[0])));
                    break;
                }
                this.buttonList.set(4, new GuiButton(1001, this.width / 2 - 61, this.height / 2 + 6, 120, 20, I18n.format("Wings: OFF", new Object[0])));
                break;
            }
            case 1003: {
                Client.CosmeticCape = !Client.CosmeticCape;
                if (Client.CosmeticCape) {
                    this.buttonList.set(3, new GuiButton(1003, this.width / 2 - 61, this.height / 2 - 18, 120, 20, I18n.format("Cape: ON", new Object[0])));
                    break;
                }
                this.buttonList.set(3, new GuiButton(1003, this.width / 2 - 61, this.height / 2 - 18, 120, 20, I18n.format("Cape: OFF", new Object[0])));
                break;
            }
            case 1004: {
                Client.CosmeticHalo = !Client.CosmeticHalo;
                if (Client.CosmeticHalo) {
                    this.buttonList.set(0, new GuiButton(1004, this.width / 2 - 61, this.height / 2 - 90, 120, 20, I18n.format("Halo: ON", new Object[0])));
                    break;
                }
                this.buttonList.set(0, new GuiButton(1004, this.width / 2 - 61, this.height / 2 - 90, 120, 20, I18n.format("Halo: OFF", new Object[0])));
                break;
            }
            case 8: {
                this.mc.displayGuiScreen(new GUIToggle(this));
                break;
            }
            case 1014: {
                Client.DiamondHead = !Client.DiamondHead;
                if (Client.DiamondHead) {
                    this.buttonList.set(1, new GuiButton(1014, this.width / 2 - 61, this.height / 2 - 66, 120, 20, I18n.format("DiamondHead: ON", new Object[0])));
                    break;
                }
                this.buttonList.set(1, new GuiButton(1014, this.width / 2 - 61, this.height / 2 - 66, 120, 20, I18n.format("DiamondHead: OFF", new Object[0])));
                break;
            }
            case 1016: {
                Client.CosmeticWitchHat = !Client.CosmeticWitchHat;
                if (Client.CosmeticWitchHat) {
                    this.buttonList.set(2, new GuiButton(1016, this.width / 2 - 61, this.height / 2 - 42, 120, 20, I18n.format("WitchHat: ON", new Object[0])));
                    break;
                }
                this.buttonList.set(2, new GuiButton(1016, this.width / 2 - 61, this.height / 2 - 42, 120, 20, I18n.format("WitchHat: OFF", new Object[0])));
                break;
            }
            case 1002: {
                Client.CosmeticGhostWings = !Client.CosmeticGhostWings;
                if (Client.CosmeticGhostWings) {
                    this.buttonList.set(5, new GuiButton(1002, this.width / 2 - 61, this.height / 2 + 30, 120, 20, I18n.format("Ghost Wings: ON", new Object[0])));
                    break;
                }
                this.buttonList.set(5, new GuiButton(1002, this.width / 2 - 61, this.height / 2 + 30, 120, 20, I18n.format("Ghost Wings: OFF", new Object[0])));
                break;
            }
            case 1005: {
                Client.CosmeticCap = !Client.CosmeticCap;
                if (Client.CosmeticCap) {
                    this.buttonList.set(6, new GuiButton(1005, this.width / 2 - 61, this.height / 2 + 54, 120, 20, I18n.format("Cap: ON", new Object[0])));
                    break;
                }
                this.buttonList.set(6, new GuiButton(1005, this.width / 2 - 61, this.height / 2 + 54, 120, 20, I18n.format("Cap: OFF", new Object[0])));
                break;
            }
            case 1006: {
                Client.CosmeticHat = !Client.CosmeticHat;
                if (Client.CosmeticHat) {
                    this.buttonList.set(7, new GuiButton(1006, this.width / 2 - 61, this.height / 2 + 78, 120, 20, I18n.format("Hat: ON", new Object[0])));
                    break;
                }
                this.buttonList.set(7, new GuiButton(1006, this.width / 2 - 61, this.height / 2 + 78, 120, 20, I18n.format("Hat: OFF", new Object[0])));
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
        this.drawString(this.fontRendererObj, String.valueOf(Client.ModFarbe) + "Cosmetics", this.width / 2 - 23, this.height / 2 - 120, -1);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
