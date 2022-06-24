package com.leo.leetcode.Dynamicprogramming.SumOfKNmbers;

import java.sql.Array;
import java.util.*;

/**
 * @Author: Leo
 * @Description: TODO
 * @DateTime: 2022/6/24 14:53
 **/
public class ThreeSumSolution {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        List list = new ArrayList<>();
        ThreeSumSolution threeSumSolution = new ThreeSumSolution();
        list = threeSumSolution.threeSum2(arr);
        list.forEach(System.out::println);
    }

    /**
     * 正式代码
     */
    public List<List<Integer>> threeSum1(int[] arr) {
        if (arr==null||arr.length<3) return new ArrayList<>();
        ArrayList<List<Integer>> res = new ArrayList<>();
        //去重
        Set set = new HashSet<>();
        for (int i = 0; i < arr.length-2; i++) {
            for (int j = i+1; j <arr.length-1 ; j++) {
                for (int k = j+1; k < arr.length ; k++) {
                    if (arr[i]+arr[j]+arr[k]==0) {
                        List<Integer> list = Arrays.asList(arr[i],arr[j],arr[k]);
                        Collections.sort(list);
//                        res.add(list);
                        String str = list.toString();
                        if(!set.contains(str)) {
                            set.add(str);
                            res.add(list);
                        }
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] arr) {
        if (arr==null||arr.length<3) return new ArrayList<>();
       Set res = new HashSet();
       Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int target = -arr[i];
            int LPoint = i+1;
            int RPoint = arr.length-1;
            while(LPoint<RPoint) {
                int sum = arr[LPoint]+arr[RPoint];
                if (sum ==target) {
                    res.add(Arrays.asList(arr[i],arr[LPoint],arr[RPoint]));
                    LPoint++;
                    RPoint--;
                } else if (sum<target){
                    LPoint++;
                } else {
                    RPoint--;
                }
            }
        }

       return new ArrayList<>(res);

    }
}
