package net.minecraft.util;

import java.util.*;
import com.google.common.base.*;
import com.google.common.collect.*;

public class ObjectIntIdentityMap<T> implements IObjectIntIterable<T>
{
    private final IdentityHashMap<T, Integer> identityMap;
    private final List<T> objectList;
    
    public ObjectIntIdentityMap() {
        this.identityMap = new IdentityHashMap<T, Integer>(512);
        this.objectList = (List<T>)Lists.newArrayList();
    }
    
    public void put(final T key, final int value) {
        this.identityMap.put(key, value);
        while (this.objectList.size() <= value) {
            this.objectList.add(null);
        }
        this.objectList.set(value, key);
    }
    
    public int get(final T key) {
        final Integer integer = this.identityMap.get(key);
        return (integer == null) ? -1 : integer;
    }
    
    public final T getByValue(final int value) {
        return (value >= 0 && value < this.objectList.size()) ? this.objectList.get(value) : null;
    }
    
    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>)Iterators.filter((Iterator)this.objectList.iterator(), Predicates.notNull());
    }
}
