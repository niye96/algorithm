package com.ny.LinkedList;

import java.util.List;

public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode p3 = l3;
        while (l1 != null && l2 != null) {
            int val;
            if (l1.val < l2.val) {
                val = l1.val;
                l1 = l1.next;
            } else {
                val = l2.val;
                l2 = l2.next;
            }
            p3.next = new ListNode(val);
            p3 = p3.next;
        }
        if (l1 == null) {
            p3.next = l2;
        }
        if (l2 == null) {
            p3.next = l1;
        }
        l3 = l3.next;
        return l3;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        ListNode l1 = null;
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(4);
        ListNode l2 = null;
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);
        mergeTwoLists(l1, l2);
    }
}
