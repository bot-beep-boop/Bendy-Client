package clientname;

import java.awt.*;
import clientname.gui.hud.*;
import clientname.gui.*;
import clientname.mods.*;
import clientname.event.impl.*;
import net.minecraft.client.*;
import clientname.gui.gui.*;
import net.minecraft.client.gui.*;
import clientname.event.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;

public class Client
{
    private static final Client INSTANCE;
    public static boolean ChromaText;
    public static boolean LeftHand;
    public static boolean DynamicFOV;
    public static boolean CosmeticGhostWings;
    public static boolean CosmeticCap;
    public static String ClientName;
    public static ColorEnum mainColor;
    public static int FPSBoost;
    public static String DiscordID;
    public static boolean LogoButtons;
    public static boolean Particles;
    public static int guiToggleClientName;
    public static boolean BlockOverlay;
    public static int ConfigScreenColor;
    public static Color SplashColor;
    public static String ModFarbe;
    public static int ButtonHover;
    public static String KlammerFarbe;
    public static boolean CosmeticHat;
    public static boolean CosmeticWitchHat;
    public static boolean DiamondHead;
    public static boolean ChatBackground;
    public static boolean BetterAnimations;
    public static boolean ItemPhysics;
    public static boolean ToggleSprint;
    public static boolean CosmeticWings;
    public static boolean CosmeticHalo;
    public static boolean CosmeticCape;
    public static boolean CosmeticCape2;
    public static boolean CosmeticCape3;
    public static boolean CosmeticCape4;
    public static boolean ModBiom;
    public static boolean ModFPS;
    public static boolean ModPing;
    public static boolean ModPotionstatus;
    public static boolean ModTimeShow;
    public static boolean ModPosition;
    public static boolean ModArmorStatus;
    public static boolean ModKeystrokes;
    public static boolean ModItemViewer;
    public static boolean ModDamageIndicator;
    public static boolean red;
    public static boolean orange;
    public static boolean yellow;
    public static boolean green;
    public static boolean cyan;
    public static boolean blue;
    public static boolean pink;
    public static boolean purple;
    public static boolean TimeChanger;
    public static boolean dayTime;
    public static boolean nightTime;
    public static String Background;
    public static String Cape;
    public static String SplashScreen;
    public static String Logo;
    private DiscordRP discordRP;
    private HUDManager hudManager;
    int scrollTotal;
    private static boolean prevIsKeyDown;
    private static float savedFOV;
    
    static {
        INSTANCE = new Client();
        Client.ChromaText = false;
        Client.LeftHand = false;
        Client.DynamicFOV = false;
        Client.CosmeticGhostWings = false;
        Client.CosmeticCap = false;
        Client.ClientName = "Bendy Client";
        Client.mainColor = ColorEnum.orange;
        Client.FPSBoost = 1;
        Client.DiscordID = "878269258717610005";
        Client.LogoButtons = true;
        Client.Particles = false;
        Client.guiToggleClientName = 50;
        Client.BlockOverlay = false;
        Client.ConfigScreenColor = getConfigScreenColor();
        Client.SplashColor = getSplashColor();
        Client.ModFarbe = getModFarbe();
        Client.ButtonHover = getButtonHover();
        Client.KlammerFarbe = "§f";
        Client.ModBiom = true;
        Client.ModFPS = true;
        Client.ModPing = true;
        Client.ModPotionstatus = true;
        Client.ModTimeShow = true;
        Client.ModPosition = true;
        Client.ModArmorStatus = true;
        Client.ModKeystrokes = true;
        Client.ModItemViewer = true;
        Client.ModDamageIndicator = true;
        Client.TimeChanger = false;
        Client.Background = "background.png";
        Client.Cape = "cape.png";
        Client.SplashScreen = "splash.png";
        Client.Logo = "tollerzitronens-01.jpeg";
        Client.prevIsKeyDown = false;
        Client.savedFOV = 0.0f;
    }
    
    public Client() {
        this.discordRP = new DiscordRP();
        this.scrollTotal = 4;
    }
    
    public static final Client getInstance() {
        return Client.INSTANCE;
    }
    
    public HUDManager getHudManager() {
        return this.hudManager;
    }
    
    public static Color getSplashColor() {
        if (Client.mainColor == ColorEnum.pink) {
            return new Color(255, 85, 255);
        }
        if (Client.mainColor == ColorEnum.blue) {
            return new Color(85, 85, 255);
        }
        if (Client.mainColor == ColorEnum.red) {
            return new Color(255, 85, 85);
        }
        if (Client.mainColor == ColorEnum.pink) {
            return new Color(255, 85, 255);
        }
        if (Client.mainColor == ColorEnum.green) {
            return new Color(85, 255, 85);
        }
        if (Client.mainColor == ColorEnum.cyan) {
            return new Color(85, 255, 255);
        }
        if (Client.mainColor == ColorEnum.orange) {
            return new Color(255, 170, 0);
        }
        if (Client.mainColor == ColorEnum.gold) {
            return new Color(255, 170, 0);
        }
        if (Client.mainColor == ColorEnum.brown) {
            return new Color(255, 170, 0);
        }
        if (Client.mainColor == ColorEnum.white) {
            return new Color(255, 255, 255);
        }
        if (Client.mainColor == ColorEnum.yellow) {
            return new Color(255, 255, 85);
        }
        if (Client.mainColor == ColorEnum.darkpurple) {
            return new Color(170, 0, 170);
        }
        return new Color(0);
    }
    
    public static int getConfigScreenColor() {
        if (Client.mainColor == ColorEnum.pink) {
            return -43521;
        }
        if (Client.mainColor == ColorEnum.blue) {
            return -11184641;
        }
        if (Client.mainColor == ColorEnum.red) {
            return -43691;
        }
        if (Client.mainColor == ColorEnum.pink) {
            return -43521;
        }
        if (Client.mainColor == ColorEnum.green) {
            return -11141291;
        }
        if (Client.mainColor == ColorEnum.cyan) {
            return -11141121;
        }
        if (Client.mainColor == ColorEnum.orange) {
            return -22016;
        }
        if (Client.mainColor == ColorEnum.gold) {
            return -22016;
        }
        if (Client.mainColor == ColorEnum.brown) {
            return -22016;
        }
        if (Client.mainColor == ColorEnum.white) {
            return -1;
        }
        if (Client.mainColor == ColorEnum.yellow) {
            return -171;
        }
        if (Client.mainColor == ColorEnum.darkpurple) {
            return -5635926;
        }
        return 0;
    }
    
    public static String getModFarbe() {
        if (Client.mainColor == ColorEnum.pink) {
            return "§d";
        }
        if (Client.mainColor == ColorEnum.blue) {
            return "§9";
        }
        if (Client.mainColor == ColorEnum.red) {
            return "§c";
        }
        if (Client.mainColor == ColorEnum.pink) {
            return "§d";
        }
        if (Client.mainColor == ColorEnum.green) {
            return "§a";
        }
        if (Client.mainColor == ColorEnum.cyan) {
            return "§b";
        }
        if (Client.mainColor == ColorEnum.orange) {
            return "§6";
        }
        if (Client.mainColor == ColorEnum.gold) {
            return "§6";
        }
        if (Client.mainColor == ColorEnum.brown) {
            return "§6";
        }
        if (Client.mainColor == ColorEnum.white) {
            return "§f";
        }
        if (Client.mainColor == ColorEnum.yellow) {
            return "§e";
        }
        if (Client.mainColor == ColorEnum.darkpurple) {
            return "§5";
        }
        return "0000000000";
    }
    
    public static int getButtonHover() {
        if (Client.mainColor == ColorEnum.pink) {
            return 16733695;
        }
        if (Client.mainColor == ColorEnum.blue) {
            return 5592575;
        }
        if (Client.mainColor == ColorEnum.red) {
            return 16733525;
        }
        if (Client.mainColor == ColorEnum.pink) {
            return 16733695;
        }
        if (Client.mainColor == ColorEnum.green) {
            return 5635925;
        }
        if (Client.mainColor == ColorEnum.cyan) {
            return 5636095;
        }
        if (Client.mainColor == ColorEnum.orange) {
            return 16755200;
        }
        if (Client.mainColor == ColorEnum.gold) {
            return 16755200;
        }
        if (Client.mainColor == ColorEnum.brown) {
            return 16755200;
        }
        if (Client.mainColor == ColorEnum.white) {
            return 16777215;
        }
        if (Client.mainColor == ColorEnum.yellow) {
            return 16777045;
        }
        if (Client.mainColor == ColorEnum.darkpurple) {
            return 11141290;
        }
        return 0;
    }
    
    public void init() {
        SplashProgress.setProgress(1, String.valueOf(Client.ClientName) + " - Discord Initialisation");
        FileManager.init();
        this.discordRP.start();
        EventManager.register(this);
    }
    
    public void start() {
        ModInstances.register(this.hudManager = HUDManager.getInstance());
    }
    
    public void shutdown() {
        this.discordRP.shutdown();
    }
    
    public DiscordRP getDiscordRP() {
        return this.discordRP;
    }
    
    @EventTarget
    public void onTick(final ClientTickEvent e) {
        if (Minecraft.getMinecraft().gameSettings.CLIENT_GUI_MOD_POS.isPressed()) {
            this.hudManager.openConfigScreen();
        }
        if (Minecraft.getMinecraft().gameSettings.CLIENT_GUI_MOD_SETTINGS.isPressed()) {
            Minecraft.getMinecraft().displayGuiScreen(new GUIToggle(null));
        }
        final boolean isKeyDown = Minecraft.getMinecraft().gameSettings.ZOOM.isKeyDown();
        if (Client.prevIsKeyDown != isKeyDown) {
            if (isKeyDown) {
                Client.savedFOV = Minecraft.getMinecraft().gameSettings.fovSetting;
                Minecraft.getMinecraft().gameSettings.fovSetting = 30.0f;
                Minecraft.getMinecraft().gameSettings.smoothCamera = true;
            }
            else {
                Minecraft.getMinecraft().gameSettings.fovSetting = Client.savedFOV;
                Minecraft.getMinecraft().gameSettings.smoothCamera = false;
            }
        }
        Client.prevIsKeyDown = isKeyDown;
    }
    
    public static void drawColoredBlockOverlay(final AxisAlignedBB axisAlignedBBIn, final int red, final int green, final int blue, final int alpha) {
        final Tessellator tessellator = Tessellator.getInstance();
        final WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(5, DefaultVertexFormats.POSITION_COLOR);
        worldrenderer.pos(axisAlignedBBIn.minX, axisAlignedBBIn.minY, axisAlignedBBIn.minZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.maxX, axisAlignedBBIn.minY, axisAlignedBBIn.minZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.minX, axisAlignedBBIn.minY, axisAlignedBBIn.maxZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.maxX, axisAlignedBBIn.minY, axisAlignedBBIn.maxZ).color(red, green, blue, alpha).endVertex();
        tessellator.draw();
        worldrenderer.begin(5, DefaultVertexFormats.POSITION_COLOR);
        worldrenderer.pos(axisAlignedBBIn.minX, axisAlignedBBIn.maxY, axisAlignedBBIn.minZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.minX, axisAlignedBBIn.maxY, axisAlignedBBIn.maxZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.maxX, axisAlignedBBIn.maxY, axisAlignedBBIn.minZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.maxX, axisAlignedBBIn.maxY, axisAlignedBBIn.maxZ).color(red, green, blue, alpha).endVertex();
        tessellator.draw();
        worldrenderer.begin(5, DefaultVertexFormats.POSITION_COLOR);
        worldrenderer.pos(axisAlignedBBIn.minX, axisAlignedBBIn.minY, axisAlignedBBIn.minZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.minX, axisAlignedBBIn.maxY, axisAlignedBBIn.minZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.maxX, axisAlignedBBIn.minY, axisAlignedBBIn.minZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.maxX, axisAlignedBBIn.maxY, axisAlignedBBIn.minZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.maxX, axisAlignedBBIn.minY, axisAlignedBBIn.maxZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.maxX, axisAlignedBBIn.maxY, axisAlignedBBIn.maxZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.minX, axisAlignedBBIn.minY, axisAlignedBBIn.maxZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.minX, axisAlignedBBIn.maxY, axisAlignedBBIn.maxZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.minX, axisAlignedBBIn.minY, axisAlignedBBIn.minZ).color(red, green, blue, alpha).endVertex();
        worldrenderer.pos(axisAlignedBBIn.minX, axisAlignedBBIn.maxY, axisAlignedBBIn.minZ).color(red, green, blue, alpha).endVertex();
        tessellator.draw();
    }
}
