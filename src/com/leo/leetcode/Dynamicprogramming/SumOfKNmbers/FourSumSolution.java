package com.leo.leetcode.Dynamicprogramming.SumOfKNmbers;

import java.util.*;

/**
 * @Author: Leo
 * @Description: TODO
 * @DateTime: 2022/6/24 17:52
 **/
public class FourSumSolution {
    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        int target = 0;
        FourSumSolution fourSumSolution = new FourSumSolution();
        List list = new ArrayList<>();
        list = fourSumSolution.fourSum(arr, target);
        list.forEach(System.out::println);
    }

    public List<List<Integer>> fourSum(int[] arr, int target) {

        if (arr == null || arr.length < 4) return new ArrayList<>();
        Set res = new HashSet<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length-1; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            if ((long) arr[i] + arr[i + 1] + arr[i + 2] + arr[i + 3] > target) {
                break;
            }
            if ((long) arr[i] + arr[arr.length - 3] + arr[arr.length - 2] + arr[arr.length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < arr.length-2; j++) {
                int left = j + 1;
                int right = arr.length - 1;
                while (left < right) {
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    if (sum == target) {
                        res.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        while (right > left && arr[right] == arr[right - 1]) right--;
                        while (right > left && arr[left] == arr[left + 1]) left++;
                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }


            }
        }
        return new ArrayList<>(res);
    }
}