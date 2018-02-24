package com.ny.array;

import java.util.Stack;

public class TrappingRainWater {
    public static int trap(int[] height) {
        /**
         * 第一种方法
         * 使用stack
         */
//        if (height.length == 0) return 0;
//        int total = 0;
//        int preI = 0;
//        Stack<Integer> stack = new Stack<>();
//        stack.push(0);
//        for (int i = 1; i < height.length; i++) {
//            if(height[i] >= height[preI]) {
//                while(stack.lastElement()!=preI) stack.pop();
//                preI=i;
//                stack.push(i);
//            }else{
//                if (height[i] >= height[i-1]) {
//                    while(height[i] >= height[stack.lastElement()]) {
//                        stack.pop();
//                    }
//                    stack.push(i);
//                }
//            }
//        }
//        int[] points = new int[stack.size()];
//        for(int i = points.length - 1; i >= 0; i--){
//            points[i] = stack.pop();
//        }
//        for(int i = 1; i < points.length; i++){
//            int min = Math.min(height[points[i - 1]],height[points[i]]);
//            for(int j = points[i - 1]; j <= points[i]; j++){
//                int diff = min - height[j];
//                if(diff > 0) total += diff;
//            }
//        }
//        return total;


        /**
         * 第二种方法
         * 使用两个指针
         */
        int left = 0, right = height.length - 1;
        int total = 0;
        while (left < right) {
            int leftVal = height[left], rightVal = height[right];
            while (left < right && height[left] <= height[right] && height[left] <= leftVal) {
                total += leftVal - height[left];
                left++;
            }
            while (left < right && height[right] <= height[left] && height[right] <= rightVal) {
                total += rightVal - height[right];
                right--;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        trap(new int[]{4, 1, 2, 1, 3, 1, 1, 2, 1});
        trap(new int[]{2, 0, 1, 4, 2, 0, 2, 2, 4});
        trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        trap(new int[]{7, 7, 0, 4, 0, 6, 8, 5, 1, 6, 0, 4, 7, 0, 0, 1});
    }
}
