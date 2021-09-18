package com.majm.ratelimit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 漏桶算法 </br>
 * <p>
 * 一次请求 就是往桶里加一次水,  处理请求的速率是固定的,就是一次漏水(leak)
 * 适合使用阻塞队列(bucket)的方式实现
 *
 * @author majunmin
 * @description
 * @datetime 2021-08-06 08:45
 * @since
 */
public class LeakBucketRateLimiter {

    private int capacity; //桶的容量
    private int rate;   // 漏斗漏出速率
    private int left;   // 剩余容量
    private LinkedList<Request> requestList;

    public LeakBucketRateLimiter(int limit, int rate) {
        this.capacity = limit;
        this.rate = rate;
        this.left = capacity;
        this.requestList = new LinkedList<>();
        new Thread(() -> {
            while (true) {

                if (!requestList.isEmpty()) {
                    Request request = requestList.removeFirst();
                    handleRequest(request);
                    left++;
                }

                try {
                    Thread.sleep(1000 / rate);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void handleRequest(Request request) {
        request.setHandleTime(new Date());
        System.out.println(request.getCode() + "请求被处理, 处理时间:" + request.getHandleTime());
    }

    /**
     * @return
     */
    public boolean acquire(Request request) {

        if (left <= 0) {
            return false;
        } else {
            // 一次请求 到来就是一次加水
            left--;
            requestList.addLast(request);
            return true;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    static class Request {
        private int code;
        private Date launchTime;
        private Date handleTime;
    }

    public static void main(String[] args) {
        LeakBucketRateLimiter rateLimiter = new LeakBucketRateLimiter(10, 100);
        for (int i = 0; i < 100; i++) {
            Request request = new Request();
            request.setCode(i);
            if (rateLimiter.acquire(request)) {
                System.out.println(i + "号请求被接收");
            } else {
                System.out.println(i + "号请求被拒绝");
            }
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 20; i++) {
            Request request = new Request();
            request.setCode(i);
            if (rateLimiter.acquire(request)) {
                System.out.println(i + "号请求被接收");
            } else {
                System.out.println(i + "号请求被拒绝");
            }
        }
    }
}

