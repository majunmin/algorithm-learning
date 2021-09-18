package com.majm.ratelimit;

/**
 * 利用 redis 实现分布式限流 场景 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-06 08:41
 * @since
 */
public class DistributeRateLimiter implements RateLimiter {
    @Override
    public boolean acquire() {
        return false;
    }
}
