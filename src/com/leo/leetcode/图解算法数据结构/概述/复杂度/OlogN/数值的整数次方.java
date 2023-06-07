package com.leo.leetcode.图解算法数据结构.概述.复杂度.OlogN;


/**
 * 剑指 Offer 16. 数值的整数次方
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 */

//讲解：

/**
 * 首先明确一点，二分法就是十进制数字转成二进制之后向右挪一位。
 * 再明确一点：直接for循环是超时的
 * 这一题这里用的方法就是快速幂法，引用到两种思想，一个是分治法，还有一个是二分法
 *
 * 首先，n转成二进制就是。。。。（自己想想公式）
 * 所以同理成x^(n) 就是 :( x^(1*b1)) + (x*(2*b2)) + (x*(4*b3)) + ``````````````````````````
 *
 * 当bn为0的时候，整一项就是1
 * myPow(double x, int n)中
 * 比如说n是3 x是9 ， 那么n二进制就是11，我们需要的结果是9*9*9，需要乘三次。
 * 那么就可以判断按位与，倘若为1的时候，就会累计上前面是一的部分，
 * 例如10010，底数是2
 * 那么就相当于我们来求2的18次方  我们在第二次的时候将res从1更新到4，在最后一位的时候会累计上来。相当于res是一个标签，标记了当前位置及
 * 其右边的乘积，而x的变化更多的像是一个指针。
 *
 * 直接乘的时间复杂度是On，但是二进制的快速幂法的时间复杂度是logn，res帮其分担了压力。
 *
 */
public class 数值的整数次方 {
    public static void main(String[] args) {
        myPow(9,5);
    }
    public static double myPow(double x, int n) {
        if(x == 0.0f) return 0.0d;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            //用于数据类型的转变
            if((b & 1) == 1) {
                res *= x;
                System.out.println(b);
                System.out.println(res);
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
