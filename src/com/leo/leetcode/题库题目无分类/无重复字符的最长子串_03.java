package com.leo.leetcode.题库题目无分类;

/**
 * @Classname 无重复字符的最长子串_03
 * @Description 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * @Date 2023/6/11 21:48
 * @Created by WL110
 */
public class 无重复字符的最长子串_03 {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("accbacab"));
//        tssest();
    }

    private static void tssest() {
        System.out.println("---------");
        int[] last = new int[128];
        for (int i = 0; i < 3; i++) {
            int start = 0;
            start = Math.max(start,last[0] +1);
            start = Math.max(start,last[0] +1);
            start = Math.max(start,last[0] +1);
            start = Math.max(start,last[0] +1);
            start = Math.max(start,last[0] +1);
            System.out.println(start);
            System.out.println(last[0]);

        }
    }

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int[] arr = new int[128];
        int start = 0;
        int n = s.length();
        for(int i = 0;i<n;i++) {
            int index = s.charAt(i);
            start = Math.max(start,arr[index]);
            res = Math.max(res,i-start+1);
            arr[index] = i+1;
        }
        return res;
    }
}
