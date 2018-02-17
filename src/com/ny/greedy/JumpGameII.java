package com.ny.greedy;

public class JumpGameII {
    public static int jump(int[] nums) {
        int i = 0, count = 0;
        while (i < nums.length - 1) {
            count++;
            int fasest = 0, pos = i;
            for (int j = i + 1, len = nums.length - 1; j <= i + nums[i]; j++) {
                if (j == len) return count;
                if (nums[j] + j > fasest) {
                    fasest = nums[j] + j;
                    pos = j;
                }
            }
            i = pos;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{3, 2, 1, 2, 1, 1, 2}));
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }

}
