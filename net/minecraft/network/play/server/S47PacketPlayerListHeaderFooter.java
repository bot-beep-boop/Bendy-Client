package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.util.*;
import java.io.*;
import net.minecraft.network.*;

public class S47PacketPlayerListHeaderFooter implements Packet<INetHandlerPlayClient>
{
    private IChatComponent header;
    private IChatComponent footer;
    
    public S47PacketPlayerListHeaderFooter() {
    }
    
    public S47PacketPlayerListHeaderFooter(final IChatComponent headerIn) {
        this.header = headerIn;
    }
    
    @Override
    public void readPacketData(final PacketBuffer buf) throws IOException {
        this.header = buf.readChatComponent();
        this.footer = buf.readChatComponent();
    }
    
    @Override
    public void writePacketData(final PacketBuffer buf) throws IOException {
        buf.writeChatComponent(this.header);
        buf.writeChatComponent(this.footer);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient handler) {
        handler.handlePlayerListHeaderFooter(this);
    }
    
    public IChatComponent getHeader() {
        return this.header;
    }
    
    public IChatComponent getFooter() {
        return this.footer;
    }
}
