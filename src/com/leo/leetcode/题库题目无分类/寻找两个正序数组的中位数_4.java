package com.leo.leetcode.题库题目无分类;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 寻找两个正序数组的中位数_4 {

    public static void main(String[] args) {

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        //判断长度,过滤几种情况
        /**
         * 为什么不需要过滤呢？
         */
//        if (len1 ==0 && len2 ==0) return 0;
//        if (len1 ==0) return nums2[len2/2 +1];
//        if (len2 ==0) return nums1[len2/2 +1];
        //统一长短格式
        if (len1>len2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        //左边数的长度
        int totalLeft = (len1+len2+1)/2;
        int left = 0,right = len1;

        while(left<right) {
            int i = (left+right+1)/2;
            int j = totalLeft-i;
            if (nums1[i-1]>nums2[j]) {
                right = i-1;
            } else {
                left = i;
            }
        }
        int i = left;
        int j = totalLeft-i;
        int nums1LeftMax = i==0?Integer.MIN_VALUE:nums1[i-1];
        int nums1RightMin = i==len1?Integer.MAX_VALUE:nums1[i];
        int nums2LeftMax = j==0? Integer.MIN_VALUE:nums2[j-1];
        int nums2RightMin = j==len2? Integer.MAX_VALUE:nums2[j];

        //判断奇偶
        if ((len1+len2)%2 ==1) {
            return Math.max(nums1LeftMax,nums2LeftMax);
        } else {
            return (Math.max(nums1LeftMax,nums2LeftMax) + Math.min(nums1RightMin,nums2RightMin))/2;
        }
    }
}
