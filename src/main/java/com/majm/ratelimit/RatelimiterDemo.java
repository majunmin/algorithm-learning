package com.majm.ratelimit;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * guava 限流实现 </br>
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-09 17:41
 * @since
 */
public class RatelimiterDemo {


    public static void main(String[] args) throws InterruptedException {
        // QPS 设置为 5，代表一秒钟只允许处理五个请求
        RateLimiter rateLimiter = RateLimiter.create(5);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(10);
        long startTime = System.currentTimeMillis();
        AtomicInteger count = new AtomicInteger();

        for (int i = 0; i < 10; i++) {
            threadPool.submit(() -> {
                rateLimiter.acquire(1);
                latch.countDown();
                System.out.println("第 " + count.incrementAndGet() + " 个请求完成，" +
                        "距离开始时间 " + (System.currentTimeMillis() - startTime) + " ms");
            });
        }
        latch.await();
        System.out.println("共计用时：" + (System.currentTimeMillis() - startTime) + "ms");
        threadPool.shutdown();
    }
}
