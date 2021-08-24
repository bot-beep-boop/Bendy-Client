package clientname.mods.impl;

import clientname.mods.*;
import net.minecraft.util.*;
import net.minecraft.world.chunk.*;
import clientname.gui.hud.*;
import net.minecraft.client.*;
import clientname.*;

public class ModBiom extends ModDraggable
{
    @Override
    public int getWidth() {
        final BlockPos blockpos = new BlockPos(this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().getEntityBoundingBox().minY, this.mc.getRenderViewEntity().posZ);
        final Chunk chunk = this.mc.theWorld.getChunkFromBlockCoords(blockpos);
        return ModBiom.font.getStringWidth("Biom" + chunk.getBiome(blockpos, this.mc.theWorld.getWorldChunkManager()).biomeName);
    }
    
    @Override
    public int getHeight() {
        return ModBiom.font.FONT_HEIGHT;
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        if (Client.ModBiom) {
            if (!Client.ChromaText) {
                final BlockPos blockpos = new BlockPos(this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().getEntityBoundingBox().minY, this.mc.getRenderViewEntity().posZ);
                final Chunk chunk = this.mc.theWorld.getChunkFromBlockCoords(blockpos);
                Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(Client.KlammerFarbe) + "[" + Client.ModFarbe + "Biome" + Client.KlammerFarbe + "] " + chunk.getBiome(blockpos, this.mc.theWorld.getWorldChunkManager()).biomeName, (float)pos.getAbsoluteX(), (float)pos.getAbsoluteY(), -1);
            }
            else {
                final BlockPos blockpos = new BlockPos(this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().getEntityBoundingBox().minY, this.mc.getRenderViewEntity().posZ);
                final Chunk chunk = this.mc.theWorld.getChunkFromBlockCoords(blockpos);
                ChromaText.drawChromaString("[Biome] " + chunk.getBiome(blockpos, this.mc.theWorld.getWorldChunkManager()).biomeName, pos.getAbsoluteX(), pos.getAbsoluteY(), true);
            }
        }
    }
}
