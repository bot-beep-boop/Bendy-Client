package net.minecraft.client.player.inventory;

import java.util.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;

public class ContainerLocalMenu extends InventoryBasic implements ILockableContainer
{
    private String guiID;
    private Map<Integer, Integer> field_174895_b;
    
    public ContainerLocalMenu(final String id, final IChatComponent title, final int slotCount) {
        super(title, slotCount);
        this.field_174895_b = (Map<Integer, Integer>)Maps.newHashMap();
        this.guiID = id;
    }
    
    @Override
    public int getField(final int id) {
        return this.field_174895_b.containsKey(id) ? this.field_174895_b.get(id) : 0;
    }
    
    @Override
    public void setField(final int id, final int value) {
        this.field_174895_b.put(id, value);
    }
    
    @Override
    public int getFieldCount() {
        return this.field_174895_b.size();
    }
    
    @Override
    public boolean isLocked() {
        return false;
    }
    
    @Override
    public void setLockCode(final LockCode code) {
    }
    
    @Override
    public LockCode getLockCode() {
        return LockCode.EMPTY_CODE;
    }
    
    @Override
    public String getGuiID() {
        return this.guiID;
    }
    
    @Override
    public Container createContainer(final InventoryPlayer playerInventory, final EntityPlayer playerIn) {
        throw new UnsupportedOperationException();
    }
}
