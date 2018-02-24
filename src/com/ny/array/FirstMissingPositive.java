package com.ny.array;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int postive = 0;
        int negative;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) postive++;
        }
        negative = nums.length - postive;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] != i - negative + 1) {
                if (negative + nums[i] - 1 < nums.length)
                    if (nums[i] != nums[negative + nums[i] - 1]) {
                        swap(nums, i, negative + nums[i] - 1);
                    } else {
                        break;
                    }
                else
                    break;
            }
        }
        for (int i = negative; i < nums.length; i++) {
            if (nums[i] != i - negative + 1) {
                return i - negative + 1;
            }
        }
        return postive + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        firstMissingPositive(new int[]{1, 2, 0});
        firstMissingPositive(new int[]{-1, 2, 8, 8, -5, 3, 4, 2, 1, 5, -4, 4});
        firstMissingPositive(new int[]{1, 6, 6, -1, 3, 2, -1, 5, 2, 5, 1, 1, -5, 3, 2, 6, 7, 7, 8, 1});
    }
}
