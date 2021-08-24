package clientname.mods.impl;

import clientname.mods.*;
import clientname.event.impl.*;
import org.lwjgl.input.*;
import clientname.event.*;
import org.lwjgl.opengl.*;
import clientname.gui.hud.*;

public class ModPerspective extends ModDraggable
{
    private boolean returnOnRelease;
    public static boolean perspectiveToggled;
    private float cameraYaw;
    private float cameraPitch;
    private int previousPerspective;
    
    static {
        ModPerspective.perspectiveToggled = false;
    }
    
    public ModPerspective() {
        this.returnOnRelease = true;
        this.cameraYaw = 0.0f;
        this.cameraPitch = 0.0f;
        this.previousPerspective = 0;
    }
    
    @EventTarget
    public void keyboardEvent(final KeyEvent e) {
        if (e.getKey() == this.mc.gameSettings.CLIENT_PERSPECTIVE.getKeyCode()) {
            if (Keyboard.getEventKeyState()) {
                ModPerspective.perspectiveToggled = !ModPerspective.perspectiveToggled;
                this.cameraYaw = this.mc.thePlayer.rotationYaw;
                this.cameraPitch = this.mc.thePlayer.rotationPitch;
                if (ModPerspective.perspectiveToggled) {
                    this.previousPerspective = this.mc.gameSettings.thirdPersonView;
                    this.mc.gameSettings.thirdPersonView = 1;
                }
                else {
                    this.mc.gameSettings.thirdPersonView = this.previousPerspective;
                }
            }
            else if (this.returnOnRelease) {
                ModPerspective.perspectiveToggled = false;
                this.mc.gameSettings.thirdPersonView = this.previousPerspective;
            }
        }
        if (Keyboard.getEventKey() == this.mc.gameSettings.keyBindTogglePerspective.getKeyCode()) {
            ModPerspective.perspectiveToggled = false;
        }
    }
    
    public float getCameraYaw() {
        return ModPerspective.perspectiveToggled ? this.cameraYaw : this.mc.thePlayer.rotationYaw;
    }
    
    public float getCameraPitch() {
        return ModPerspective.perspectiveToggled ? this.cameraPitch : this.mc.thePlayer.rotationPitch;
    }
    
    public boolean overrideMouse() {
        if (this.mc.inGameHasFocus && Display.isActive()) {
            if (!ModPerspective.perspectiveToggled) {
                return true;
            }
            this.mc.mouseHelper.mouseXYChange();
            final float f1 = this.mc.gameSettings.mouseSensitivity * 0.6f + 0.2f;
            final float f2 = f1 * f1 * f1 * 8.0f;
            final float f3 = this.mc.mouseHelper.deltaX * f2;
            final float f4 = this.mc.mouseHelper.deltaY * f2;
            this.cameraYaw += f3 * 0.15f;
            this.cameraPitch += f4 * 0.15f;
            if (this.cameraPitch > 90.0f) {
                this.cameraPitch = 90.0f;
            }
            if (this.cameraPitch < -90.0f) {
                this.cameraPitch = -90.0f;
            }
        }
        if (this.cameraYaw < -90.0f) {
            this.cameraYaw = -90.0f;
        }
        return false;
    }
    
    @Override
    public int getWidth() {
        return ModPerspective.font.getStringWidth("");
    }
    
    @Override
    public int getHeight() {
        return ModPerspective.font.FONT_HEIGHT;
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        if (ModPerspective.perspectiveToggled) {
            this.mc.fontRendererObj.drawStringWithShadow("", (float)pos.getAbsoluteX(), (float)pos.getAbsoluteY(), -1);
        }
    }
}
