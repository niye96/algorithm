package com.ny.greedy;

/**
 * @Author: ny
 * @Date: Created in 10:05 2018/3/5 0005
 */
public class JumpGame {
    public static boolean canJump(int[] nums) {
//        int i = 0;
//        while(i < nums.length - 1){
//            int fasest = 0, pos = 0;
//            for(int j = 1 + i; j <= nums[i] + i; j++){
//                if(nums[j] + j >= fasest) {
//                    fasest = nums[j] + j;
//                    pos = j;
//                }
//                if(fasest >= nums.length - 1) return true;
//            }
//            if(pos == 0) return false;
//            i = pos;
//        }
//        return true;
        
        if (nums.length == 0) return false;
        if (nums.length == 1) return true;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                int jumpsNeeded = 1;
                while (jumpsNeeded > nums[i]) {
                    jumpsNeeded++;
                    i--;
                    if (i < 0) return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(canJump(new int[]{1,1,0,0}));
//        System.out.println(canJump(new int[]{0,1}));
//        System.out.println(canJump(new int[]{2}));
//        System.out.println(canJump(new int[]{2,0}));
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
