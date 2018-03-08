package com.ny.dp;

/**
 * @Author: ny
 * @Date: Created in 9:42 2018/3/8 0008
 */
public class ClimbingStairs {
    public static int climbStairs(int n) {
        //递归超时
//        if(n == 1) return 1;
//        else if(n == 2) return 2;
//        else return climbStairs(n - 1) + climbStairs(n - 2);
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] step = new int[n];
        step[0] = 1;
        step[1] = 2;
        for (int i = 2; i < n; i++)
            step[i] = step[i - 1] + step[i - 2];
        return step[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));
    }
}
