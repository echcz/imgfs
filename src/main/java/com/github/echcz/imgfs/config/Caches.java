package com.github.echcz.imgfs.config;

public enum Caches {
    /**
     * imgs
     */
    imgs(600, 1000);
    private long ttl;
    private int maxSize;
    Caches(int ttl, int maxSize) {
        this.ttl = ttl;
        this.maxSize = maxSize;
    }

    public long getTtl() {
        return ttl;
    }

    public int getMaxSize() {
        return maxSize;
    }
}
