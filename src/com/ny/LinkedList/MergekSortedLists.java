package com.ny.LinkedList;

import java.util.*;

public class MergekSortedLists {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static class Point implements Comparable {
        int val;
        int pos;

        Point(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }

        public int compareTo(Object o) {
            Point p = (Point) o;
            if (val < p.val) return -1;
            else return 1;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode root = new ListNode(0);
        ListNode p = root;
        ListNode[] points = new ListNode[lists.length];
        Queue<Point> queue = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            points[i] = lists[i];
        }
        for (int i = 0; i < lists.length; i++) {
            if (points[i] != null) queue.add(new Point(lists[i].val, i));
        }
        while (!queue.isEmpty()) {
            Point point = queue.remove();
            p.next = new ListNode(point.val);
            p = p.next;
            int pos = point.pos;
            points[pos] = points[pos].next;
            if (points[pos] != null) {
                queue.add(new Point(points[pos].val, pos));
            }
        }
        root = root.next;
        return root;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        ListNode p1 = l1;
//        int[] data = new int[]{2, 3, 4, 7, 9};
//        for (int i = 0; i < data.length; i++) {
//            p1.next = new ListNode(data[i]);
//            p1 = p1.next;
//        }
//
//
//        ListNode l2 = new ListNode(2);
//        ListNode p2 = l2;
//        data = new int[]{3, 5};
//        for (int i = 0; i < data.length; i++) {
//            p2.next = new ListNode(data[i]);
//            p2 = p2.next;
//        }
//
//        ListNode l3 = new ListNode(1);
//        ListNode p3 = l3;
//        data = new int[]{5, 6, 8};
//        for (int i = 0; i < data.length; i++) {
//            p3.next = new ListNode(data[i]);
//            p3 = p3.next;
//        }
//
//        ListNode[] list = new ListNode[]{l1, l2, l3};
//        mergeKLists(list);
//        Queue<Point> queue = new PriorityQueue<>();
//        queue.add(new Point(1,1));
//        queue.add(new Point(2,2));
//        queue.add(new Point(2,3));
//        queue.add(new Point(1,4));
//        System.out.println(queue.remove().pos);
//        System.out.println(queue.remove().pos);
//        System.out.println(queue.remove().pos);
//        System.out.println(queue.remove().pos);
        int a = -1;
        int b = 5;
        System.out.println(((a >> 31) ^ (b >> 31)));
        System.out.println(1);
    }
}
