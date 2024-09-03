package com.sf;

public class HuiwenJudge {

    public static void main(String[] args) {

    }


    // lc: 5:给你一个字符串 s，找到 s 中最长的回文子串

    // 动态规划，空间换时间，存储临时计算结果
    public String longestPalindrome3(String s) {
        int maxLen = 0;
        int maxStart = 0;
        int strLen = s.length();
        boolean[][] dp = new boolean[strLen][strLen];
        for (int i = 0; i < strLen; i++) {
            dp[i][i] = true;
        }
        // l l+1 xxx r-1 r
        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l ++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l+1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                    }
                }
            }
        }
        return s.substring(maxStart, maxStart + maxLen);
    }

    // 2中心扩展法
    public String longestPalindrome2(String s) {
        int max = 0;
        int maxStart = 0;
        int strLen = s.length();
        for (int i = 0; i < strLen; i++) {
            int len = 1;
            int left  = i - 1;
            int right = i + 1;
            //
            while (left >= 0 && s.charAt(i) == s.charAt(left)) {
                len ++;
                left --;
            }

            while (right < strLen && s.charAt(i) == s.charAt(right)) {
                len ++;
                right ++;
            }

            while (left >= 0 && right < strLen && s.charAt(left) == s.charAt(right)) {
                len = len + 2;
                right ++;
                left --;
            }

            if (len > max) {
                max = len;
                maxStart = left;
            }
        }
        return s.substring(maxStart + 1, maxStart + max + 1);
    }
    // 1、暴力解法
    public String longestPalindrome(String s) {
        if (s == null || s.equals("") || s.length() == 1) {
            return s;
        }
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String tmp = s.substring(i, j);
                if (isPalindromic(tmp) && tmp.length() > max) {
                    ans = tmp;
                    max = tmp.length();
                }
            }
        }
        return ans;
    }
    public boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    //  lc125: 检查是否为回文字符串
    public boolean isPalindrome(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        // 双指针
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            while(start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start ++;
            }
            while(start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end --;
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}
