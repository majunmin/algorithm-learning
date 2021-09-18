package com.majm.ratelimit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LimitConfig {
    private int limit; // interval限流数
    private int windowSize; // 毫秒数,窗口大小
    private int splitNum; // 切分小窗口的 数目

    public LimitConfig(int limit, int windowSize) {
        this.limit = limit;
        this.windowSize = windowSize;
    }
}