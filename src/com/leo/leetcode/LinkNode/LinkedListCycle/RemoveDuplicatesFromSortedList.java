package com.leo.leetcode.LinkNode.LinkedListCycle;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Leo
 * @Description: TODO
 * @DateTime: 2022/6/29 19:03
 **/
public class RemoveDuplicatesFromSortedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
//        ListNode head4 = new ListNode(4);
        ListNode head3 = new ListNode(2);
        ListNode head2= new ListNode(1,head3);
        ListNode head = new ListNode(1,head2);

        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        ListNode rs = removeDuplicatesFromSortedList.deleteDuplicates(head);
        while(rs!=null) {
            System.out.println(rs.val);
            rs = rs.next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {

        ListNode move = head;
        Set store = new HashSet();
        while(move!=null&&move.next!=null) {
            if(!store.contains(move.val)) {
                store.add(move.val);
            } else {
                move.next = move.next.next;
            }
            move = move.next;

        }
        return head;
    }
}
