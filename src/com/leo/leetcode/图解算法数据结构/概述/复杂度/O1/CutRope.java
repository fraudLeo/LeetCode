package com.leo.leetcode.图解算法数据结构.概述.复杂度.O1;

/**
 * 剑指 Offer 14- I 题目解析
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 作者：Krahets
 * 链接：https://leetcode.cn/leetbook/read/illustration-of-algorithm/5v1026/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

//想法解释：

/**
 * 通过基本不等式可以知道当平均分的时候是最大的。推理过程自己想。反正是当每段为3
 * 的时候是最大的。
 * 这样就要考虑几种情况，有余数和没有余数。
 * 当余数是一的时候就要想着减少一段为3让省下来的1 和3组成4，相乘。
 */
public class CutRope {

    public int cuttingRope(int n) {
        if(n<=3) return n-1;
        int a = n%3;
        int b = n/3;
        if(a == 1 ) return (int)Math.pow(3,b-1)*4;
        if(a == 2 ) return (int)Math.pow(3,b)*2;
        return (int)Math.pow(3,b);
    }
}
