package com.majm.ratelimit;

/**
 * 滑动窗口 限流 </br>
 * 滑动窗口相对于固定时间窗口来讲 有更好的整流效果,需要而外记录每一次请求的时间
 * 但是还是不能对细粒度时间段内的集中请求
 * <p>
 * 滑动时间窗口 实现简单,不容易出错,空间复杂度 比固定时间窗口大一些
 * <p>
 * ![](https://gitee.com/niubenwsl/image_repo/raw/master/image/java/20210806131615.png)
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-06 08:19
 * @since
 */
public class SlidingWindowLimit implements RateLimiter {


    private LimitConfig config;

    private int index; // 当前窗口计数器的索引
    private int[] counts; // 每个小窗口的计数数组
    private long startTime;// 窗口开始时间

    public SlidingWindowLimit(int limit, int interval, int splitNum) {
        final LimitConfig limitConfig = new LimitConfig();
        limitConfig.setLimit(limit);
        limitConfig.setWindowSize(interval);
        limitConfig.setSplitNum(splitNum);
        this.index = 0;
        this.startTime = System.currentTimeMillis();
        this.counts = new int[splitNum];
        this.config = limitConfig;
    }

    /**
     * todo: 滑动窗口实现
     *
     * @return true if access
     */
    @Override
    public synchronized boolean acquire() {
        // 获取当前时间所在子窗口 的开始时间
        long curTime = System.currentTimeMillis();
        // 计算滑动窗口的最小数量
        // curTime - config.getWindowSize() - startTime <= 0 : 表示还在窗口内,不需要滑动
        long windowNum = Math.max(curTime - config.getWindowSize() - startTime, 0)
                / (config.getWindowSize() / config.getSplitNum());

        slidingWindow(windowNum);

        int sumReq = 0;
        for (int i = 0; i < config.getSplitNum(); i++) {
            sumReq += counts[i];
        }
        if (sumReq >= config.getLimit()) {
            return false;
        }
        counts[index]++;
        return true;
    }

    // 滑动窗口
    private void slidingWindow(long windowNum) {
        if (windowNum == 0) {
            return;
        }
        long slideNum = Math.min(windowNum, config.getSplitNum());
        for (int i = 0; i < slideNum; i++) {
            index = (index + 1) % config.getSplitNum();
            counts[index] = 0;
        }
        startTime = startTime + windowNum * (config.getWindowSize() / config.getSplitNum());
    }


    public static void main(String[] args) throws InterruptedException {
        //每秒20个请求
        int limit = 20;
        RateLimiter counterSildeWindowLimiter = new SlidingWindowLimit(limit, 1000, 10);
        int count = 0;
        Thread.sleep(3000);

        //计数器滑动窗口算法模拟100组间隔30ms的50次请求
        System.out.println("计数器滑动窗口算法测试开始");
        System.out.println("开始模拟100组间隔150ms的50次请求");
        int faliCount = 0;
        for (int j = 0; j < 100; j++) {
            count = 0;
            for (int i = 0; i < 50; i++) {
                if (counterSildeWindowLimiter.acquire()) {
                    count++;
                }
            }
            Thread.sleep(150);
            //模拟50次请求，看多少能通过
            for (int i = 0; i < 50; i++) {
                if (counterSildeWindowLimiter.acquire()) {
                    count++;
                }
            }
            if (count > limit) {
                System.out.println("时间窗口内放过的请求超过阈值，放过的请求数" + count + ",限流：" + limit);
                faliCount++;
            }
            Thread.sleep((int) (Math.random() * 100));
        }
        System.out.println("计数器滑动窗口算法测试结束，100组间隔150ms的50次请求模拟完成，限流失败组数：" + faliCount);
        System.out.println("===========================================================================================");


        //计数器固定窗口算法模拟100组间隔30ms的50次请求
        System.out.println("计数器固定窗口算法测试开始");
        //模拟100组间隔30ms的50次请求
        RateLimiter counterLimiter = new SlidingWindowLimit(limit, 1000, 10);
        System.out.println("开始模拟100组间隔150ms的50次请求");
        faliCount = 0;
        for (int j = 0; j < 100; j++) {
            count = 0;
            for (int i = 0; i < 50; i++) {
                if (counterLimiter.acquire()) {
                    count++;
                }
            }
            Thread.sleep(150);
            //模拟50次请求，看多少能通过
            for (int i = 0; i < 50; i++) {
                if (counterLimiter.acquire()) {
                    count++;
                }
            }
            if (count > limit) {
                System.out.println("时间窗口内放过的请求超过阈值，放过的请求数" + count + ",限流：" + limit);
                faliCount++;
            }
            Thread.sleep((int) (Math.random() * 100));
        }
        System.out.println("计数器滑动窗口算法测试结束，100组间隔150ms的50次请求模拟完成，限流失败组数：" + faliCount);
    }

}
