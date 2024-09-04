package com.sf;

import java.util.HashMap;
import java.util.Map;

public class ArraySfTest {

    public static void main(String[] args) {

    }

    // lc189:轮转数组  暴力解法
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            int tailNum = nums[len - 1];
            for (int j = len - 1; j > 0; j --) {
                nums[j] = nums[j - 1];
            }
            nums[0] = tailNum;
        }
    }

    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

    //lc 238: ans[i]= num[0]*num[1]...num[i-1]*num[i+1] = ∏num(K)/num(i)
    // Li * Ri = ans[i] 暴力求解
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int Li = 1;
            int Ri = 1;
            for (int j = 0; j < i; j ++) {
                Li = Li * nums[j];
            }
            for (int j = i + 1; j < nums.length; j ++) {
                Ri = Ri * nums[j];
            }
            ans[i] = Li * Ri;
        }
        return ans;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] ans = new int[nums.length];
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        L[0] = 1;
        for (int j = 1; j < nums.length ; j ++) {
            L[j] = L[j - 1] * nums[j - 1];
        }
        R[nums.length - 1] = 1;
        for (int j = nums.length -2; j >= 0; j --) {
            R[j] = R[j + 1] * nums[j + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = L[i] * R[i];
        }
        return ans;
    }


    // lc45: 跳跃游戏II，找到一个最小跳跃次数，贪心算法：每次选择跳的最远的，剩余的问题结构跟上一次的问题同构
    public int jumpGame2(int[] nums) {
        int step = 0;
        int max = 0;
        int jump = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == jump) {
                jump = max;
                step ++;
            }
        }
        return step;
    }

    // lc55:跳跃游戏， 贪心，更新每个位置的最大覆盖范围 y = x + num[x]
    public boolean jumpGame(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                continue;
            }
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length) {
                return true;
            }
        }
        return false;
    }

    // lc169  多数元素
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            int old = count.getOrDefault(nums[i], 0);
            count.put(nums[i], old + 1);
        }
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            if (e.getValue() > nums.length/2) {
                return e.getKey();
            }
        }
        return -1;
    }

    // lc:80 删除超过2次的重复元素
    public int removeDuplicatesV2(int[] nums) {
        int len = nums.length;
        if(len <= 2) {
            return len;
        }
        int fast = 2;
        int slow = 2;
        while (fast < len) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow ++;
            }
            fast ++;
        }
        return slow;
    }

    // lc:26 快慢指针  1 1 1 2 2  3 3 3 3
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0) {
            return 0;
        }
        int fast = 1;
        int slow = 1;
        //
        for (int i = 1; i< len; i++) {
            if (nums[i] == nums[i-1]) {
                fast = i;
                slow = i;
                break;
            }
        }
        while (fast < len) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow ++;
            }
            fast ++;
        }
        return slow;
    }


     // lc27: 移除元素， 双指针
     public int removeElement(int[] nums, int val) {
        int right = nums.length;
        for (int i = 0; i < right;) {
            if (nums[i] == val) {
                // override by tail
                nums[i] = nums[right-1];
                right --;
            } else {
                 i++;
            }
        }
        return right;
     }
}
