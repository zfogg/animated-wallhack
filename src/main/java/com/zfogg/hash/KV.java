package com.zfogg.hash;


class KV<K, V> {
    private final K k;
    private       V v;

    public KV(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public K getK() {
        return k;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
}
