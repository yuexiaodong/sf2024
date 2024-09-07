package com.sf;

import java.util.Arrays;

// 三数之和：三个指针遍历
public class ThreeNumSum {

    public static void main(String[] args) {

    }

    public int threeNumSum(int[] nums, int t) {
        Arrays.sort(nums); // O(nlogn)
        if (nums[0] + nums[1] + nums[2] >= t) {
            return nums[0] + nums[1] + nums[2];
        }
        int n = nums.length;
        if (nums[n-1] + nums[n-2] + nums[n-3] <= t) {
            return nums[n-1] + nums[n-2] + nums[n-3];
        }
        int minClose = Integer.MIN_VALUE;
        int maxClose = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) { //o(n*n)
            int L = i + 1;
            int R = n - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum < t) { //
                    if (sum > minClose) {
                        minClose = sum;
                    }
                    L++;
                } else if (sum > t) {
                    if (sum < maxClose) {
                        maxClose = sum;
                    }
                    R--;
                } else {
                    maxClose = t;
                    minClose = t;
                    return t;
                }
            }
        }
        return Math.abs(maxClose - t) > Math.abs(minClose - t) ? minClose : maxClose;
    }
}
