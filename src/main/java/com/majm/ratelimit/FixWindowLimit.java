package com.majm.ratelimit;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * 固定时间窗口  的限流算法 </br>
 * 实现容易,占用内存小
 * 不会因为请求堆积而饿死
 * <p>
 * 线程安全实现 使用 AtomicInteger 或者  加锁  ReentrantLock
 * <p>
 * 缺点是存在临界问题,无法处理集中请求
 * <p>
 * ![](https://gitee.com/niubenwsl/image_repo/raw/master/image/java/20210806131533.png)
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-06 08:06
 * @since
 */
public class FixWindowLimit implements RateLimiter {

    private LimitConfig config;

    //    private int reqCnt; // 时间窗口计数
    private AtomicInteger reqCnt = new AtomicInteger(0); // 时间窗口计数,线程安全

    public FixWindowLimit(int limit, int interval) {
        this(new LimitConfig(limit, interval));
    }

    public FixWindowLimit(LimitConfig config) {
        this.config = config;
        new Thread(() -> {
            while (true) {
                reqCnt.set(0);
                try {
                    TimeUnit.MILLISECONDS.sleep(config.getWindowSize());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * @return return true if not limit
     */
    @Override
    public boolean acquire() {
        int cnt = reqCnt.incrementAndGet();
        return cnt <= config.getLimit();
    }

    public static void main(String[] args) {
        FixWindowLimit fixWindowLimit = new FixWindowLimit(20, 1000);
        IntStream.rangeClosed(1, 50).mapToObj(i -> (Runnable) () -> {
            if (fixWindowLimit.acquire()) {
                System.out.println("第" + i + "个请求: request access");
            } else {
                System.out.println("第" + i + "个请求: request cannot access!");
            }
        }).map(Thread::new).forEach(Thread::start);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        IntStream.rangeClosed(1, 50).mapToObj(i -> (Runnable) () -> {
            if (fixWindowLimit.acquire()) {
                System.out.println("第" + i + "个请求: request access");
            } else {
                System.out.println("第" + i + "个请求: request cannot access!");
            }
        }).map(Thread::new).forEach(Thread::start);
    }
}
