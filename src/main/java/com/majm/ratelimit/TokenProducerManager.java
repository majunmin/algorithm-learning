package com.majm.ratelimit;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 令牌桶 token 生产管理 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-09 16:55
 * @since
 */
public class TokenProducerManager {


    private static TokenBucket execute(String key, Long period, Integer limit) {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1);

        TokenBucket tokenBucket = TokenBucket.builder().key(key).limit(limit).build();
        threadPool.scheduleAtFixedRate(new TokenProducer(tokenBucket), 0L, period, TimeUnit.MILLISECONDS);
        return tokenBucket;
    }

    /**
     * 暴露 addTokenAtFixRate 支持指定请求key 指定速率 指定桶大小
     *
     * @param key
     * @param period
     * @param limit
     * @return
     */
    public static TokenBucket addTokenAtFixRate(String key, Long period, Integer limit) {
        return execute(key, period, limit);
    }
}
