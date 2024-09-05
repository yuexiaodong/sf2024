package com.sf;

import javax.swing.plaf.IconUIResource;

public class StringTest {
    public static void main(String[] args) {
//        StringTest stringTest = new StringTest();
//        System.out.printf(stringTest.reverseWords("the sky is blue"));
    }

    // lc76:最小覆盖子串
    public String minWindow(String s, String t) {
        return "";
    }

    // lc151:  翻转字符串中的单词
    public String reverseWords(String s) {
        char[] sc = s.toCharArray();
        int start = 0;
        int end = sc.length - 1;
        //  翻转字符串
        reverse(sc, start, end);
        //  去除空格
        int head = 0;
        while (head <= s.length() - 1) {
            if (sc[head] == ' ') {
                head ++;
                continue;
            }
            break;
        }
        int tail = s.length() - 1;
        while (tail >= 0) {
            if (sc[tail] == ' ') {
                tail --;
                continue;
            }
            break;
        }
        // 去除中间的多余空格
        StringBuilder sb1  = new StringBuilder();
        for (int i = head; i <= tail ; i++) {
             if (sc[i] != ' ') {
                 sb1.append(sc[i]);
             } else if (sc[i] == ' ' && sc[i+1] != ' '){
                 sb1.append(sc[i]);
             }
        }
        sc = sb1.toString().toCharArray();
        head = 0;
        tail = sc.length - 1;

        //  翻转每个单词
        for (int i = head; i <= tail;) {
            int fast = i;
            int slow = i;
            while (fast <= tail && sc[fast] != ' ') {
                fast ++;
            }
            reverse(sc, slow, fast - 1);
            i = i + fast - slow + 1;
        }
        // 输出
        StringBuilder sb  = new StringBuilder();
        for (int i = head; i <= tail ; i++) {
            sb.append(sc[i]);
        }
        return sb.toString();
    }
    
    private void reverse(char[] sc, int start, int end) {
        while (start < end) {
            char tmp = sc[start];
            sc[start] = sc[end];
            sc[end] = tmp;
            start ++;
            end --;
        }
    }

    // lc58
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int count  = 0;
        for (int i = n -1; i >= 0; i --) {
            if (!Character.isLetter(s.charAt(i))) {
                if (count > 0) {
                    break;
                }
                continue;
            }
            count ++;
        }
        return count;
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

    // lc121: 股票最大收益
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    // lc122:贪心，
    public int maxProfitV2(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(0, prices[i] - prices[i-1]);
        }
        return ans;
    }

}
