package com.ny.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author: ny
 * @Date: Created in 15:35 2018/3/11 0011
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int pos = quicksort(nums, lo, hi);
            sort(nums, lo, pos - 1);
            sort(nums, pos + 1, hi);
        }
    }

    public int quicksort(int[] nums, int lo, int hi) {
        int pos = lo;
        while (lo < hi) {
            while (hi > lo && nums[hi] >= nums[pos])
                hi--;
            while (lo < hi && nums[lo] <= nums[pos])
                lo++;
            if (lo > hi) break;
            swap(nums, lo, hi);
        }
        swap(nums, pos, hi);
        return hi;
    }

    public void swap(int[] nums, int lo, int hi) {
        int temp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = temp;
    }

    public static void main(String[] args) {
        new SortColors().sortColors(new int[]{0, 0, 2, 1, 1, 1, 2, 2, 0, 0, 0, 1});
        new SortColors().sortColors(new int[]{});
        new SortColors().sortColors(new int[]{0, 1, 1, 2});
    }
}
