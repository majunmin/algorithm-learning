package com.majm.ratelimit;

import java.util.concurrent.TimeUnit;

/**
 * 令牌桶算法 </br>
 * 适用于阻塞时限流
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-06 09:12
 * @since
 */
public class TokenBucketLimitRater implements RateLimiter {


    private TokenBucket tokenBucket;

    public TokenBucketLimitRater(String key, Integer limit, Long period) {
        this.tokenBucket = TokenProducerManager.addTokenAtFixRate(key, period, limit);
    }

    @Override
    public boolean acquire() {
        return tokenBucket.getToken();
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new TokenBucketLimitRater("hello", 10, 10L);
        for (int i = 0; i < 30; i++) {
            System.out.println(i + " : " + rateLimiter.acquire());
        }
        TimeUnit.SECONDS.sleep(1);

        for (int i = 0; i < 30; i++) {
            System.out.println(i + " : " + rateLimiter.acquire());
        }
    }
}


