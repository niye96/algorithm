package com.ny.LinkedList;

public class AddTwoNumbers {
    private class ListNode {
        int val;
        ListNode next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = new ListNode();
        int c = 0;
        ListNode l = p;

        while (l1.next != null || l2.next != null) {
            int a = l1.next == null ? 0 : l1.next.val;
            int b = l2.next == null ? 0 : l2.next.val;
            l.next = new ListNode();
            l.next.val = l1.next.val + l2.next.val + c;
            l = l.next;
            if (l.val >= 10) {
                c = 1;
                l.val = l.val % 10;
            } else {
                c = 0;
            }
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (c == 1) {
            l.next = new ListNode();
            l.next.val = c;
        }
        return p;
    }

}
