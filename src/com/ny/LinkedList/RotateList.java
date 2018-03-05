package com.ny.LinkedList;

/**
 * @Author: ny
 * @Date: Created in 16:39 2018/3/5 0005
 */
public class RotateList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int len = 1;
        ListNode temp = head;
        ListNode end;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        end = temp;
        temp = head;
        k = k % len;
        if (k == 0) return head;
        while (--len > k) {
            temp = temp.next;
        }
        end.next = head;
        head = temp.next;
        temp.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
        rotateRight(listNode, 4);
    }
}
