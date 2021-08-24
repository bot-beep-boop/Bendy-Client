package clientname.mods.impl;

import clientname.mods.*;
import clientname.gui.hud.*;
import java.text.*;
import java.util.*;
import clientname.*;
import net.minecraft.entity.*;
import net.minecraft.client.*;

public class ModDamageIndicator extends ModDraggable
{
    private ScreenPosition pos;
    private static final NavigableMap<Double, String> suffixes;
    private static DecimalFormat df2;
    DecimalFormat df;
    
    static {
        (suffixes = new TreeMap<Double, String>()).put(1000.0, "k");
        ModDamageIndicator.suffixes.put(1000000.0, "M");
        ModDamageIndicator.suffixes.put(1.0E9, "B");
        ModDamageIndicator.suffixes.put(1.0E12, "T");
        ModDamageIndicator.suffixes.put(1.0E15, "Q");
        ModDamageIndicator.suffixes.put(1.0E18, "QT");
        ModDamageIndicator.suffixes.put(1.0E21, "ST");
        ModDamageIndicator.suffixes.put(1.0E24, "SP");
        ModDamageIndicator.suffixes.put(1.0E27, "OT");
        ModDamageIndicator.df2 = new DecimalFormat("#.##");
    }
    
    public ModDamageIndicator() {
        this.df = new DecimalFormat("#.00");
    }
    
    public static String format(final double d) {
        if (d == -9.223372036854776E18) {
            return format(-9.223372036854776E18);
        }
        if (d < 0.0) {
            return "-" + format(-d);
        }
        if (d < 1000.0) {
            return Double.toString(d);
        }
        final Map.Entry<Double, String> e = ModDamageIndicator.suffixes.floorEntry(d);
        final Double divideBy = e.getKey();
        final String suffix = e.getValue();
        final double truncated = d / (divideBy / 10.0);
        final boolean hasDecimal = truncated < 100.0 && truncated / 10.0 != truncated / 10.0;
        return String.valueOf(ModDamageIndicator.df2.format(hasDecimal ? new StringBuilder(String.valueOf(truncated / 10.0)).append(suffix).toString() : Double.valueOf(truncated / 10.0))) + suffix;
    }
    
    @Override
    public int getWidth() {
        return ModDamageIndicator.font.getStringWidth(String.valueOf(Client.KlammerFarbe) + "[" + Client.ModFarbe + "Entity" + Client.KlammerFarbe + "] ");
    }
    
    @Override
    public int getHeight() {
        return 20;
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        if (this.mc.pointedEntity != null && this.mc.pointedEntity instanceof EntityLiving) {
            final EntityLiving entityWantHealth = (EntityLiving)this.mc.pointedEntity;
            Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(Client.KlammerFarbe) + "[" + Client.ModFarbe + entityWantHealth.getName() + Client.KlammerFarbe + "] ", (float)(pos.getAbsoluteX() + 1), (float)(pos.getAbsoluteY() + 1), -1);
            Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(Client.KlammerFarbe) + "HP: " + format(Double.parseDouble(this.df.format(entityWantHealth.getHealth()).replaceAll(",", "."))) + "§4\u2764", (float)(pos.getAbsoluteX() + 1), (float)(pos.getAbsoluteY() + 10), -1);
        }
    }
    
    @Override
    public void renderDummy(final ScreenPosition pos) {
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(Client.KlammerFarbe) + "[" + Client.ModFarbe + "Entity" + Client.KlammerFarbe + "] ", (float)(pos.getAbsoluteX() + 1), (float)(pos.getAbsoluteY() + 1), -1);
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(Client.KlammerFarbe) + "HP: " + "20" + "§4\u2764", (float)(pos.getAbsoluteX() + 1), (float)(pos.getAbsoluteY() + 10), -1);
    }
}
