package com.majm.ratelimit;

import lombok.Builder;

import java.util.concurrent.atomic.AtomicInteger;

@Builder
public class TokenBucket {
    /**
     * 唯一标识
     */
    private String key;
    /**
     * 桶大小
     */
    private Integer limit;
    /**
     * bucket 当前token
     */
    private volatile AtomicInteger tokens;

    public void addToken() {
        if (tokens == null) {
            tokens = new AtomicInteger(limit);
        }
        if (tokens.intValue() <= limit) {
            tokens.incrementAndGet();
        }
    }

    public void delToken() {
        tokens.decrementAndGet();
    }

    public boolean getToken() {
        if (tokens == null) {
            tokens = new AtomicInteger(limit);
        }
        if (tokens.intValue() > 0) {
            return tokens.decrementAndGet() > 0;
        }
        return false;
    }
}