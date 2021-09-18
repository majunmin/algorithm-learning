package com.majm.ratelimit;

public interface RateLimiter {

    boolean acquire();
}
