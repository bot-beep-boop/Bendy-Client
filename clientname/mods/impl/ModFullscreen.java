package clientname.mods.impl;

import clientname.mods.*;
import clientname.gui.hud.*;
import org.lwjgl.opengl.*;
import org.lwjgl.*;

public class ModFullscreen extends ModDraggable
{
    @Override
    public int getWidth() {
        return 0;
    }
    
    @Override
    public int getHeight() {
        return 0;
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
        Display.setLocation(0, 0);
        try {
            Display.setFullscreen(false);
        }
        catch (LWJGLException e) {
            e.printStackTrace();
        }
        Display.setResizable(false);
    }
}
