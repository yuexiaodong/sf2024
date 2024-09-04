package com.sf;

public class StringTest {
    public static void main(String[] args) {

    }

    // lc28：字符串匹配, 更优的算法是KMP
    public int strStr(String haystack, String needle) {
         int n = haystack.length();
         int m = needle.length();
         if (n < m) {
             return -1;
         }
         for (int i = 0; i <= n -m; i ++) {
             boolean flag = true;
             for (int j = 0; j < m; j ++) {
                 if (haystack.charAt(i + j) != needle.charAt(j)) {
                     flag = false;
                     break;
                 }
             }
             if (flag) {
                 return i;
             }
         }
         return -1;
    }

    // lc14: 编写一个函数来查找字符串数组中的最长公共前缀。
    //如果不存在公共前缀，返回空字符串 ""。
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 1) {
            return strs[0];
        }
        String s0 = strs[0];
        for (int i = 0; i < s0.length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i == strs[j].length() || s0.charAt(i) != strs[j].charAt(i)) {
                    return s0.substring(0, i);
                }
            }
        }
        return s0;
    }
}
