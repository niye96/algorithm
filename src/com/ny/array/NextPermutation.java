package com.ny.array;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            int swapPos = i + 1;
            for (int j = swapPos; j < nums.length; j++) {
                if (nums[j] > nums[i] && nums[j] < nums[swapPos])
                    swapPos = j;
            }
            int temp = nums[i];
            nums[i] = nums[swapPos];
            nums[swapPos] = temp;
        }
        Arrays.sort(nums, i + 1, nums.length);
    }

    public static void main(String[] args) {
        new NextPermutation().nextPermutation(new int[]{1, 3, 2});
        new NextPermutation().nextPermutation(new int[]{4, 1, 5, 4, 6, 6, 2});
    }
}
