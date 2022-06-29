package com.leo.leetcode.LinkNode.LinkedListCycle;

/**
 * @Author: Leo
 * @Description: TODO
 * @DateTime: 2022/6/26 16:56
 **/
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        //定义快慢指针,倘若重复,则证明有闭环
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null&&fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow ==fast) {
                return true;
            }
        }
        return false;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }