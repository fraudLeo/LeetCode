package com.leo.leetcode.Dynamicprogramming.SumOfKNmbers;

import java.util.HashMap;

/**
 * @Author: Leo
 * @Description: TODO
 * @DateTime: 2022/6/24 14:26
 **/
public class TwoSumSolution {
    public static void main(String[] args) {
        int nums[] = {2,7,11,15};
        int target = 9;
        TwoSumSolution twoSumSolution = new TwoSumSolution();
        int[] arr = twoSumSolution.twoSum(nums,target);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 正式方法
     */
    public int[] twoSum(int[] nums,int target) {
        int arr[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++) {
            if (map.containsKey(target-nums[i])) {
                arr[0] = i;
                arr[1] = map.get(target-nums[i]);
                return arr;
            }
            map.put(nums[i],i);
        }
        return arr;
    }
}
