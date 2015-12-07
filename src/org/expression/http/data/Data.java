package org.expression.http.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * An generic encapsulation of data input and output which is easily accessible.
 * @author Jack Timblin
 */
public class Data implements Iterable<Data>, Iterator<Data> {
    
    /**
     * The dataset of entries in this data entry.
     */
    private final Map<Object, Data> entries;
    
    /**
     * The value stored in this dataset if this data entry represents a
     * single value.
     */
    private Object value;
    
    /**
     * The current position in the iterator.
     */
    private int position = -1;
    
    /**
     * IF we have served the single value.
     */
    private boolean hasServedValue = false;
    
    /**
     * Initialises a new data object with a null value.
     */
    public Data() {
        //use linked hash map to maintain insertion order.
        this.entries = new LinkedHashMap<>();
        this.value = null;
    }
    
    /**
     * Initialises a data object with a single value, only used internally. 
     * @param value the single value of this data object.
     */
    public Data(Object value) {
        this();
        this.value = value;
    }
    
    /**
     * Generic Method to retrieve an object of a particular class type.
     * In this method the value is attempted to be unwrapped in the data container, 
     * so this method should only be used when retrieving a concrete value and not
     * another data value.
     * @param <T> The type of the object to retrieve.
     * @param <K> The type of the key used to store the value.
     * @param key The key value to retrieve with.
     * @param cls The class object of the object, used to cast.
     * @return The object stored at the key index, null if the key doesn't exist.
     */
    private <T,K> T get(K key, Class<T> cls) {
        if(!(key instanceof String) && !(key instanceof Integer)) {
            return null;
        }
        try {
            if(value != null) {
                return cls.cast(value);
            }
            if(!entries.containsKey(key)) {
                return null;
            }
            Data e = entries.get(key);
            if(e.hasValue()) {
                return e.get(cls);
            }
            return null;
        } catch (ClassCastException e) {
            return null;
        }
    }
    
    /**
     * Attempts to grab a value from this data entry without unwrapping
     * the value into its concrete type, it will be wrapped in another Data class.
     * @param key the key.
     * @return the data entry at the key or null if it doesn't exist.
     */
    private Data get(Object key) {
        if(!(key instanceof String) && !(key instanceof Integer)) {
            return null;
        }
        if(hasValue()) {
            return null;
        }
        if(!entries.containsKey(key)) {
            return null;
        }
        Data e = entries.get(key);
        return e;
    }
    
    /**
     * Attempts to grab a value from this data entry without unwrapping
     * the value into its concrete type, it will be wrapped in another Data class.
     * @param key the key.
     * @return the data entry at the key or null if it doesn't exist.
     */
    public Data get(String key) {
        return this.get((Object)key);
    }
    
    /**
     * Attempts to grab a value from this data entry without unwrapping
     * the value into its concrete type, it will be wrapped in another Data class.
     * @param key the key.
     * @return the data entry at the key or null if it doesn't exist.
     */
    public Data get(Integer key) {
        return this.get((Object)key);
    }
    
    /**
     * Determines if this data entry has a value with a certain key.
     * @param <K> The type of key to use.
     * @param key  the key.
     * @param cls the type of the key.
     * @return true if this data object has an entry with this key, false otherwise.
     */
    private <K> boolean hasKey(Object key, Class<K> cls) {
        if(hasValue()) {
            return false;
        }
        return this.entries.containsKey(cls.cast(key));
    }
    
    /**
     * Determines if this data entry has a value with a certain string key.
     * @param key  the key.
     * @return true if this data object has an entry with this key, false otherwise.
     */
    public boolean hasKey(String key) {
        return this.<String>hasKey(key, String.class);
    }
    
    /**
     * Determines if this data entry has a value with a certain integer key.
     * @param key  the key.
     * @return true if this data object has an entry with this key, false otherwise.
     */
    public boolean hasKey(Integer key) {
        return this.<Integer>hasKey(key, Integer.class);
    }
    
    /**
     * Attempts to set a new value in this data entry.
     * @param key the key to use.
     * @param value the value to set.
     */
    public void set(Object key, Object value) {
        if(!(value instanceof Data)) {
            value = new Data(value);
        }
        boolean emptyButInteger = ((key instanceof Integer) && entries.isEmpty());
        if(key != null) {
            key = (!emptyButInteger && this.isObject()) ? (""+(String)key.toString()) : key;
            this.entries.put(key, (Data) value);
        }
    }
    
    /**
     * Returns the size of this data entry.
     * @return the size of this data entry.
     */
    public int size() {
        return this.entries.size();
    }
    
    /**
     * Place-holder function to retrieve the single value stored in this data entry
     * if it contains one.
     * @return the single value of this data entry, or null if it doesn't contain one.
     */
    public Object get() {
        return this.<Object>get(Object.class);
    }
    
    /**
     * Place-holder function to retrieve the single value stored in this data entry
     * if it contains one.
     * @param <T> The type of object.
     * @param cls The class used to cast the object to a certain type.
     * @return the single value of this data entry, or null if it doesn't contain one.
     */
    public <T> T get(Class<T> cls) {
        if(!hasValue()) {
            return null;
        }
        try {
            return cls.cast(value);
        } catch (ClassCastException e) {
            return null;
        }
    }
    
    /**
     * Attempts to retrieve an object using a particular string key.
     * @param <T> The type of the object to retrieve.
     * @param key the key
     * @param cls the class of the object to retrieve, used to cast.
     * @return the object or null if the object is not set.
     */
    public <T> T get(String key, Class<T> cls) {
        return this.<T,String>get(key, cls);
    }
    
    /**
     * Attempts to retrieve an object using a particular integer key.
     * @param <T> The type of the object to retrieve.
     * @param key the key
     * @param cls the class of the object to retrieve, used to cast.
     * @return the object or null if the object is not set.
     */
    public <T> T get(Integer key, Class<T> cls) {
        return this.<T,Integer>get(key, cls);
    }
    
    /**
     * Determines if this data entry has a single value.
     * @return true if this data entry has a single value, false otherwise.
     */
    public boolean hasValue() {
        return this.value != null;
    }
    
    /**
     * If this data entry is an array, this method will return this data entry
     * as a list of data entries.
     * @return a list of data entries, or null if this data entry is not an array.
     */
    public List<Data> toList() {
        if(!isArray()) {
            return null;
        }
        List<Data> l = new ArrayList<>();
        try {
            entries.entrySet().stream().forEach((entry) -> {
                l.add((Integer)entry.getKey(), entry.getValue());
            });
        } catch (ClassCastException e) {
            return null;
        }
        return l;
    }
    
    /**
     * If this data entry is an object this method will return this data object 
     * as an map of string-data values.
     * @return a map of string-data entries, or null if this data entry is not an object.
     */
    public Map<String, Data> toMap() {
        if(!isObject()) {
            return null;
        }
        Map<String, Data> l = new HashMap<>();
        try {
            entries.entrySet().stream().forEach((entry) -> {
                l.put((String)entry.getKey().toString() + "", entry.getValue());
            });
        } catch (ClassCastException e) {
            return null;
        }
        return l;
    }
    
    /**
     * Determines if this data entry is classed as an array representation.
     * i.e it has no single value and all of the keys used to store values are integer values.
     * @return true if this data entry is classed as an array, false otherwise.
     */
    public boolean isArray() {
        if(value != null) {
            return false;
        }
        return !isObject();
    }
    
    /**
     * An object is defined as an entry with at least string key, or no keys.
     * @return true if this data entry is classed as an object.
     */
    public boolean isObject() {
        if(value != null) {
            return false; //is a value.
        }
        if(entries.isEmpty()) {
            return true;
        }
        boolean hasStringKeys = false;
        for(Map.Entry<Object, Data> entry : entries.entrySet()) {
            Object key = entry.getKey();
            if(key instanceof String) {
                hasStringKeys = true;
            }
        }
        return hasStringKeys;
    }
    
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        if(!hasValue()) {
            String bracketStart = isObject() ? "{" : "[";
            b.append(bracketStart);
        }
        if(!hasValue()) {
            int i = 0;
            for(Map.Entry<Object, Data> entry : entries.entrySet()) {
                Object key = entry.getKey();
                Data _value = entry.getValue();
                b.append(key.toString()).append(" : ")
                        .append(_value.toString())
                        .append(i != entries.size() - 1 ? ", " : "");
                i++;
            }
        } else {
            String sv = (value.getClass().isArray()) 
                    ? Arrays.toString((Object[])value) : value.toString();
            b.append(sv);
        }
        if(!hasValue()) {
            String bracketEnd = isObject() ? "}" : "]";
            b.append(bracketEnd);
        }
        return b.toString();
    }

    @Override
    public Iterator iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        if(value != null && !hasServedValue) {
            return true;
        }
        int newPos = this.position + 1;
        if(newPos >= this.size()) {
            this.position = -1;
            return false;
        }
        Object[] keys = this.entries.keySet().toArray(new Object[]{});
        return keys[newPos] != null;
    }

    @Override
    public Data next() {
        this.position++;
        if(value != null && !hasServedValue) {
            hasServedValue = true;
            return new Data(value);
        }
        if(value != null && hasServedValue) {
            return null;
        }
        if(this.position >= this.size()) {
            return null;
        }
        Object[] keys = this.entries.keySet().toArray(new Object[]{});
        Object key = keys[this.position];
        return this.entries.get(key);
    }
    
    /**
     * Sorts this Data object into natural order by the key.
     */
    public void sort() {
        Map<Object, Data> map = new TreeMap<>(entries);
        entries.clear();
        map.entrySet().stream().forEach((e) -> {
            entries.put(e.getKey(), e.getValue());
        });
    }
    
}
