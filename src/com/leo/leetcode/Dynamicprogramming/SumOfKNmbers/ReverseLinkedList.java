package com.leo.leetcode.Dynamicprogramming.SumOfKNmbers;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //如果头节点为空或者头结点的下一个节点为空 即长度为一或者0
        if (head==null||head.next==null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
 class ListNode {
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