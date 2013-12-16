package com.zfogg;

import org.junit.Assert;
import org.junit.Test;

import com.zfogg.hash.Hash;


public class HashTest {
    @Test
    public void testHash() {
        Hash<String,Integer> hash = new Hash<String,Integer>();
        hash.set("abc", 123);
        Assert.assertTrue(hash.get("abc") == 123);
    }
}
