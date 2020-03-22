package Inf.Home_6;

import java.util.*;
import java.util.AbstractMap;

public class MyMap<K,V> extends AbstractMap<K,V> {

    private ArrayList<K> keys;
    private ArrayList<V> values;

    public MyMap() {
        this.keys = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    public MyMap(ArrayList<K> keys, ArrayList<V> values) {
        this.keys = keys;
        this.values = values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        HashSet<Entry<K, V>> entryHashSet = new HashSet<>();
        for (int i = 0; i < this.keys.size(); i++) {
            entryHashSet.add(new myEntry(this.keys.get(i), this.values.get(i)));
        }
        return entryHashSet;
    }


    @Override
    public int size() {
        return this.keys.size();
    }

    @Override
    public boolean isEmpty() {
        return this.keys.isEmpty();
    }

    @Override
    public boolean containsValue(Object value) {
        return this.values.contains(value);
    }

    @Override
    public boolean containsKey(Object key) {
        return this.keys.contains(key);
    }

    @Override
    public V get(Object key) {
        for (int i = 0; i < this.keys.size(); i++) {
            if (this.keys.get(i).equals(key)) {
                return this.values.get(i);
            }
        }
        throw new NoSuchElementException("Such a element does not exist senpai!");
    }

    @Override
    public V put(K key, V value) {
        for (int i = 0; i < this.keys.size(); i++) {
            if (this.keys.get(i).equals(key)) {
                V oldValue = this.values.get(i);
                this.values.set(i, value);
                return oldValue;
            }
        }
        this.keys.add(this.keys.size(), key);
        this.values.add(this.values.size(), value);
        return null;
    }

    @Override
    public V remove(Object key) {
        if (this.keys.contains(key)) {
            for (int i = 0; i < this.keys.size(); i++) {
                if (this.keys.get(i).equals(key)) {
                    V oldValue = this.values.get(i);
                    this.keys.remove(i);
                    this.values.remove(i);
                    return oldValue;
                }
            }
        }
        throw new NoSuchElementException("Such a key does not exist senpai!");
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        Set<? extends Entry<? extends K, ? extends V>> newSet = m.entrySet();
        Iterator<Entry<K, V>> it = (Iterator<Entry<K, V>>) newSet.iterator();
        while (it.hasNext()) {
            Entry<K, V> el = it.next();
            this.put(el.getKey(), el.getValue());
        }
    }

    @Override
    public void clear() {
        this.keys.clear();
        this.values.clear();
    }

    @Override
    public Set<K> keySet() {
        return new HashSet<K>(this.keys);
    }

    @Override
    public Collection<V> values() {
        return this.values();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.keys.size(); i++) {
            str.append("{" + keys.get(i) + " -> " + values.get(i) + "};");
        }
        return str.toString();
    }

    public ArrayList<K> getKeys() {
        return keys;
    }

    public void setKeys(ArrayList<K> keys) {
        this.keys = keys;
    }

    public ArrayList<V> getValues() {
        return values;
    }

    public void setValues(ArrayList<V> values) {
        this.values = values;
    }

    @Override
    public Object clone() {
        return new MyMap<>(this.keys, this.values);
    }

    private class myEntry implements Entry<K, V> {
        private K key;
        private V value;

        public myEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.getValue();
            this.value = value;
            return oldValue;
        }

        @Override
        public String toString() {
            return "{" + this.key + " -> " + this.value + "}";
        }
    }
}
