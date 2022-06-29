package com.leo.leetcode.LinkNode.LinkedListCycle;

/**
 * @Author: Leo
 * @Description: TODO
 * @DateTime: 2022/6/26 16:56
 **/
public class LinkedListCycleII {
    //经过大量的测试,slow指针的下一个.
    //静止不动之后,定义一个新指针.如果到达slow,就停止,当前就是闭环入口
    //初始位置为0
    public ListNode detectCycle(ListNode head) {
        //1. 定义快慢指针,并定义标识
        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;

        //2.判断有无闭环
        int length = 0;
        while(fast!=null&&fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) {
                flag = true;
                break;
            }
        }
        //3.计算入环节点
        if(flag==true) {
            //创建新节点,并定义slow.next,即入口节点
            ListNode restart = head;
            while(restart!=slow.next) {
                restart = restart.next;
            }
            return restart;
        } else {
            return null;
        }
    }
}
