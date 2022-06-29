package com.leo.leetcode.LinkNode.LinkedListCycle;

public class MiddleoftheLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head==null||head.next==null) return head;
        while(fast!=null&&fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // if(fast!=null) {
        //     slow = slow.next;
        // }
        return slow;
    }
}
