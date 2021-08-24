package clientname.gui.gui;

import net.minecraft.client.gui.*;
import java.io.*;
import net.minecraft.client.multiplayer.*;

public class GuiServerSwitch extends GuiMultiplayer
{
    public GuiServerSwitch(final GuiScreen parentScreen) {
        super(null);
    }
    
    @Override
    protected void actionPerformed(final GuiButton button) throws IOException {
        if (button.id == 1 || button.id == 4) {
            this.disconnect();
        }
        super.actionPerformed(button);
    }
    
    @Override
    public void connectToSelected() {
        this.disconnect();
        super.connectToSelected();
    }
    
    private void disconnect() {
        if (this.mc.theWorld != null) {
            this.mc.theWorld.sendQuittingDisconnectingPacket();
            this.mc.loadWorld(null);
            this.mc.displayGuiScreen(null);
            this.parentScreen = null;
        }
    }
}
