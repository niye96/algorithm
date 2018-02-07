package com.ny.array;

public class SearchforaRange {
    public static int[] searchRange(int[] nums, int target) {
        int pos = -1;
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0, start, end;
        while (lo <= hi) {
            mid = (lo + hi) >> 1;
            if (target <= nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
            if (nums[mid] == target) pos = mid;
        }
        if (pos == -1) return new int[]{-1, -1};
        start = lo;

        lo = 0;
        hi = nums.length - 1;
        while (lo <= hi) {
            mid = (lo + hi) >> 1;
            if (target >= nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        end = hi;

        return new int[]{start, end};
    }

//    public static int[] searchRange(int[] nums, int target) {
//        int pos = binarySearch(nums, 0, nums.length - 1, target);
//        if (pos == -1) return new int[]{-1, -1};
//        int start = pos;
//        int end = pos;
//        while (start >= 0 && nums[start] == nums[pos]) start--;
//        while (end <= nums.length - 1 && nums[end] == nums[pos]) end++;
//        return new int[]{start + 1, end - 1};
//    }
//
//    public static int binarySearch(int[] nums, int lo, int hi, int target) {
//        int mid;
//        while (lo <= hi) {
//            mid = (lo + hi) >> 1;
//            if (target < nums[mid]) {
//                hi = mid - 1;
//            } else if (target > nums[mid]) {
//                lo = mid + 1;
//            } else {
//                return mid;
//            }
//        }
//        return -1;
//    }

    public static void main(String[] args) {
//        System.out.println(searchRange(new int[]{1, 2, 3}, 2));
        System.out.println(searchRange(new int[]{}, 2));
        System.out.println(searchRange(new int[]{0, 0, 0, 1, 1, 1, 2, 3}, 0));
        System.out.println(searchRange(new int[]{1, 2, 2, 3, 3, 3}, 3));
        System.out.println(searchRange(new int[]{3}, 2));

    }
}
