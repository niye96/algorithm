package com.ny.array;

/**
 * @Author: ny
 * @Date: Created in 8:12 2018/3/17 0017
 */
public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        int pre = nums[0], twice = 0, count = 0;
//        for (int i = 0; i < nums.length - count; i++) {
//            if (nums[i] != pre) {
//                twice = 1;
//                pre = nums[i];
//            } else {
//                if (twice < 2) {
//                    twice++;
//                }else{
//                    count++;
//                    for(int j = i + 1; j <= nums.length - count; j++)
//                        nums[j - 1] = nums[j];
//                    i--;
//                }
//            }
//        }
//        return nums.length - count;
        int n = nums.length;
        if (n < 3)
            return n;
        int i = 2, j = 2;
        while (j < n && i < n) {
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
                j++;
            } else {
                j++;
            }

        }
        return i;
    }

    public static void main(String[] args) {
//        new RemoveDuplicatesfromSortedArrayII().removeDuplicates(new int[]{1, 1, 1, 2});
        new RemoveDuplicatesfromSortedArrayII().removeDuplicates(new int[]{1, 1, 2, 2, 2, 2, 3, 3, 4});

    }
}
