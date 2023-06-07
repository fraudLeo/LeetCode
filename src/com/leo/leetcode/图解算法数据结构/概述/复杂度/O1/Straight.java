package com.leo.leetcode.图解算法数据结构.概述.复杂度.O1;

import java.util.HashSet;
import java.util.Set;


/**
 *  剑指 Offer 61. 扑克牌中的顺子
 *
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 作者：Krahets
 * 链接：https://leetcode.cn/leetbook/read/illustration-of-algorithm/57mpoj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

//解释：

/**
 * 我觉得挺简单的。。。。就是不断刷新max，min。对比最后剩下来的差值在五以内，遇到零就直接跳过
 */
public class Straight {

    public static void main(String[] args) {

        int[] integers = {4, 7, 5, 9, 2};

        boolean straight = isStraight(integers);
    }
    public static boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int max = 0;
        int min = 14;
        for(int n:nums) {
            if(n == 0) continue;
            if(set.contains(n)) return false;
            set.add(n);
            max = Math.max(max,n);
            min = Math.min(min,n);
            System.out.println(max+" "+min);
        }
        return max-min<=5;
    }
}
