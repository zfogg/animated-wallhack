package com.zfogg.hash;

import java.util.ArrayList;
import java.util.Arrays;


public class Hash<K,V> {
    final int SIZE = 2;

    @SuppressWarnings("unchecked")
    KV<K,V>[] kvs = new KV[SIZE];

    public V get(K k) {
        int i = indexOf(k);
        return i < 0 ? null : kvs[i].getV();
    }

    public void set(K k, V v) {
        int i = indexOf(k);
        if (i < 0) {
            i = emptySpot();
            if (i < 0)
                i = grow();
            kvs[i] = new KV<K,V>(k, v);
        } else
            kvs[i].setV(v);
    }

    int grow() {
        kvs = Arrays.copyOf(kvs, kvs.length + SIZE);
        return kvs.length - SIZE;
    }

    //int shrink() { }

    int indexOf(K k) {
        for (int i = 0; i < kvs.length; i++) {
            if (kvs[i] == null)
                continue;
            if (kvs[i].getK().equals(k))
                return i;
        }
        return -1;
    }

    int emptySpot() {
        for (int i = 0; i < kvs.length; i++)
            if (kvs[i] == null)
                return i;
        return -1;
    }

    @SuppressWarnings("unchecked")
    public K[] keys() {
        ArrayList<K> ks = new ArrayList<K>();
        for (int i = 0; i < kvs.length; i++)
            if (kvs[i] != null)
                ks.add(kvs[i].getK());
        return (K[]) ks.toArray();
    }

    @SuppressWarnings("unchecked")
    public V[] values() {
        ArrayList<V> vs = new ArrayList<V>();
        for (int i = 0; i < kvs.length; i++)
            if (kvs[i] != null)
                vs.add(kvs[i].getV());
        return (V[]) vs.toArray();
    }
}
