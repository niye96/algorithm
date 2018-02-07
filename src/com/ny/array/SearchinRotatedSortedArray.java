package com.ny.array;

public class SearchinRotatedSortedArray {
    public static int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private static int search(int[] nums, int lo, int hi, int target) {
        if (lo > hi) return -1;
        int mid = (lo + hi) >> 1;
        int pos = -1;
        if (target < nums[mid]) {
            if (nums[lo] <= nums[mid]) {
                if (target > nums[lo])
                    pos = search(nums, lo + 1, mid - 1, target);
                else if (target < nums[lo])
                    pos = search(nums, mid + 1, hi, target);
                else return lo;
            } else {
                pos = search(nums, lo, mid - 1, target);
            }
        } else if (target > nums[mid]) {
            if (nums[hi] >= nums[mid]) {
                if (target < nums[hi])
                    pos = search(nums, mid + 1, hi - 1, target);
                else if (target > nums[hi])
                    pos = search(nums, lo, mid - 1, target);
                else return hi;
            } else {
                pos = search(nums, mid + 1, hi, target);
            }
        } else {
            return mid;
        }
        return pos;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{2}, 2));
        System.out.println(search(new int[]{2}, 1));
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3}, 4));
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3}, 5));
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3}, 6));
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3}, 7));
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3}, 8));
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3}, 9));
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3}, 10));
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3}, 1));
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3}, 2));
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3}, 3));
        System.out.println(search(new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7}, 8));
        System.out.println(search(new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7}, 9));
        System.out.println(search(new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7}, 10));
        System.out.println(search(new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7}, 1));
        System.out.println(search(new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7}, 2));
        System.out.println(search(new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7}, 3));
        System.out.println(search(new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7}, 4));
        System.out.println(search(new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7}, 5));
        System.out.println(search(new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7}, 6));
        System.out.println(search(new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7}, 7));
    }
}
