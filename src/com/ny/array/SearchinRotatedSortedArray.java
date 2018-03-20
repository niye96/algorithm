package com.ny.array;

public class SearchinRotatedSortedArray {
    public static boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid;
        while (lo <= hi) {
            mid = (lo + hi) >> 1;
            if (nums[mid] == target) return true;
            //如果左边是排序的
            if (nums[mid] > nums[lo]) {
                if (target < nums[mid] && target >= nums[lo]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[mid] < nums[lo]) { //右边是排序的
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                lo++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 1, 1, 3, 1}, 3));
        System.out.println(search(new int[]{1, 3, 1, 1, 1}, 3));
        System.out.println(search(new int[]{1, 3, 0, 1, 1}, 3));
        System.out.println(search(new int[]{2, 1}, 3));
        System.out.println(search(new int[]{1, 1, 1, 2, 2, 3, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1}, 3));
        System.out.println(search(new int[]{4, 5, 5, 6, 8, 8, 9, 10, 1, 2, 3}, 7));
        System.out.println(search(new int[]{2, 5, 5, 6, 7, 8, 9, 10, 1, 2, 2}, 5));
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
