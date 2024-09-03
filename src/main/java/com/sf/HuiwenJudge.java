package com.sf;

public class HuiwenJudge {

    public static void main(String[] args) {

    }

    // lc: 5:给你一个字符串 s，找到 s 中最长的回文子串
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
