package com.leo.leetcode.Dynamicprogramming.SumOfKNmbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Allpermutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Allpermutation allpermutation = new Allpermutation();

        List res = allpermutation.permute(nums);
        res.forEach(System.out::println);
    }


    public List<List<Integer>> permute(int[] nums) {
        List res = new ArrayList();
        List tmp = new ArrayList();
        if (nums.length==0) return new ArrayList<>();
        breaktracking(nums,res,tmp);
        return res;
    }



    public void breaktracking(int[] nums,List res,List tmp) {

        if (nums.length == tmp.size()) {
//            for (Object s:tmp) {
//                System.out.print(s+" ");
//            }
//            System.out.println();
            res.add(new ArrayList(tmp));
            return;
        }

        for (int i = 0;i<nums.length;i++) {
            if (tmp.contains(nums[i])) {
                continue;
            }
            tmp.add(nums[i]);
            breaktracking(nums,res,tmp);
//            res.add(set);
//            System.out.println(res.size());
            tmp.remove(tmp.size()-1);
        }

    }
}
