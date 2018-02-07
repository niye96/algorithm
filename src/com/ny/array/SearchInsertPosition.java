package com.ny.array;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int mid;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            mid = (lo + hi) >> 1;
            if (target < nums[mid]) {
                hi = mid - 1;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{}, 0));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 1));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 3));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 4));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 6));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}
