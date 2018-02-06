package com.ny.numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            int area;
            if (height[i] > height[j]) {
                area = height[j] * (j - i);
                j--;
            } else {
                area = height[i] * (j - i);
                i++;
            }
            if (max < area) max = area;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }
}
