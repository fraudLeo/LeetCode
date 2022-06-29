package com.leo.leetcode.LinkNode.LinkedListCycle;

public class PalindromeLinkedLIst {
    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;
        ListNode prepre = null;
        if(head==null||head.next==null) {
            return true;
        }

        while(fast!=null&&fast.next!=null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
            pre.next = prepre;
            prepre = pre;
        }
        //奇数，偶数判断
        if(fast != null) {
            slow = slow.next;
        }
        //原来写的是：(slow!=null&&slow.next!=null）这种写法只考虑了slow，会提前停止
        while(slow!=null&&pre!=null) {
            if(pre.val!=slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
