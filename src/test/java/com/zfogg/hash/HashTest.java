package com.zfogg.hash;

import org.junit.Assert;
import org.junit.Test;


public class HashTest {
    final Hash<String,Integer> hash = new Hash<String,Integer>();

    final String[] keys = {
        "a", "b", "c", "d"
    };
    final Integer[] vals = {
        1, 2, 3, 4
    };
    final int kvLen = keys.length;

    public HashTest() {
        for (int i = 0; i < kvLen; i++)
            hash.set(keys[i], vals[i]);
    }

    @Test
    public void set() {
        for (int i = 0; i < kvLen; i++)
            Assert.assertTrue(hash.get(keys[i]) == vals[i]);
    }
    @Test
    public void get() {
        for (int i = 0; i < kvLen; i++)
            Assert.assertTrue(hash.get(keys[i]) == vals[i]);
    }

    @Test
    public void keys() {
        Object[] ks = hash.keys();
        for (int i = 0; i < kvLen; i++)
            Assert.assertTrue((String) ks[i] == keys[i]);
    }
    @Test
    public void values() {
        Object[] vs = hash.values();
        for (int i = 0; i < kvLen; i++)
            Assert.assertTrue((Integer) vs[i] == vals[i]);
    }
}
