package com.majm.offer;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 剑指 Offer 45. 把数组排成最小的数</br>
 * 排序 + 字符串
 *
 * @author majunmin
 * @description
 * @datetime 2021-09-13 20:49
 * @since
 */
public class Offer45 {


    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = nums[i] + "";
        }

        mergeSort(strs, 0, strs.length - 1);

        StringBuilder sBuilder = new StringBuilder();
        for (String s : strs) {
            sBuilder.append(s);
        }
        return sBuilder.toString();

    }

    private void mergeSort(String[] strs, int left, int right) {
        if (left >= right){
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(strs, left, mid);
        mergeSort(strs, mid + 1, right);
        merge(strs, left, mid, right);
    }

    /**
     * 合并两个有序数组
     * [left, mid][mid+1, right]
     *
     * @param strs  数组
     * @param left  left
     * @param mid   mid
     * @param right right
     */
    private void merge(String[] strs, int left, int mid, int right) {
        String[] sortArr = new String[right - left + 1];
        int i = left;
        int cnt = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if ((strs[i] + strs[j]).compareTo(strs[j] + strs[i]) <= 0) {
                sortArr[cnt++] = strs[i++];
            } else {
                sortArr[cnt++] = strs[j++];
            }
        }
        while (i <= mid) {
            // System.arraycopy()...
            sortArr[cnt++] = strs[i++];
        }
        while (j <= right) {
            sortArr[cnt++] = strs[j++];
        }
        System.arraycopy(sortArr, 0, strs, left, sortArr.length);
    }

    private void quickSort(String[] strs, int left, int right) {
        if (left > right) {
            return;
        }
        int mid = partition(strs, left, right);
        quickSort(strs, left, mid - 1);
        quickSort(strs, mid + 1, right);
    }

    private int partition(String[] strs, int left, int right) {
        int pivot = right;
        int cnt = left;
        for (int i = left; i < right; i++) {
            if ((strs[i] + strs[pivot]).compareTo(strs[pivot] + strs[i]) <= 0) {
                swap(strs, i, cnt);
                cnt++;
            }
        }
        swap(strs, cnt, pivot);
        return cnt;
    }

    private void swap(String[] strs, int i, int j) {
        String tmp = strs[i];
        strs[i] = strs[j];
        strs[j] = tmp;
    }


    private String solution2(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = nums[i] + "";
        }

        Arrays.sort(strs, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sBuilder = new StringBuilder();
        for (String s : strs) {
            sBuilder.append(s);
        }
        return sBuilder.toString();
    }

    private String solution1(int[] nums) {
        List<String> numsStr = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.toList());
        numsStr.sort((s1, s2) -> {
            return (s1 + s2).compareTo(s2 + s1);
        });
        StringBuilder sBuilder = new StringBuilder();
        for (String s : numsStr) {
            sBuilder.append(s);
        }
        return sBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Offer45().minNumber(new int[]{10, 2}));
//        System.out.println(new Offer45().minNumber(new int[]{3,30,34,5}));
    }
}
