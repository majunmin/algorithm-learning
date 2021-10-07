package com.majm.exercise.geek.dynamicprogramming;

/**
 * 0-1 背包 加入了 价值 </br>
 * <p>
 * 背包的重量 物品的重量  物品的价值,
 * 在总重量 不超过背包的承重情况下,能装下的最大的价值是多少?
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-11 22:55
 * @since
 */
public class Bag2 {

    private int maxValue = 0;

    public int maxValue(int[] weight, int[] values, int w) {
        return dpSolution(weight, values, w);
    }

    private int dpSolution(int[] weight, int[] values, int w) {
        // TODO: 2021/9/12  
        return 0;
    }

    private int backTraceSolution(int[] weight, int[] values, int w) {
        if (w == 0 || weight.length == 0) {
            return 0;
        }
        backTrace(0, 0, 0, weight, values, w);
        return maxValue;
    }

    private void backTrace(int idx, int cw, int cv, int[] weight, int[] values, int w) {
        if (cw == w || idx == weight.length) {
            if (cv >= maxValue) {
                maxValue = cv;
            }
        }

        backTrace(idx + 1, cw, cv, weight, values, w);
        if (cw + weight[idx] <= w) {
            backTrace(idx + 1, cw + weight[idx], cv + values[idx], weight, values, w);
        }
    }

}
