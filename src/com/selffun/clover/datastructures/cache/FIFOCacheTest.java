package com.selffun.clover.datastructures.cache;


public class FIFOCacheTest<K, V> {
    public static void main(String[] args) {
        FIFOCache<String,String> lruCache = new FIFOCache<String,String>(3);
        lruCache.put("j1", "1j");
        System.out.println(lruCache.size());

        lruCache.put("j2", "2j");
        System.out.println(lruCache.size());

        System.out.println(lruCache.get("j1"));
        
        lruCache.put("j4", "4j");
        System.out.println(lruCache.size());

        lruCache.put("j8", "8j");
        System.out.println(lruCache.size());

        System.out.println(lruCache.get("j1"));
        System.out.println(lruCache.get("j2"));
        System.out.println(lruCache.get("j4"));
        System.out.println(lruCache.get("j8"));

    }
}