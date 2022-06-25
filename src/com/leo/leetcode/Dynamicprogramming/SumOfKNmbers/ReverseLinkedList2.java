package com.leo.leetcode.Dynamicprogramming.SumOfKNmbers;

public class ReverseLinkedList2 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        //创建一个非空节点
        ListNode flagNode = new ListNode(99);
        //创建一个头节点前的pre,作为标识,谨防第一个变化,没有基准
        flagNode.next = head;
        ListNode pre = flagNode;
        //寻找前部节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        //确立当前节点
        ListNode cur = pre.next;
        //先定义,下面发生变化
        ListNode temp;
        for (int i = 0; i < right - left; i++) {
            temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return flagNode.next;

    }
}
