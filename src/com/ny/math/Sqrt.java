package com.ny.math;

/**
 * @Author: ny
 * @Date: Created in 9:00 2018/3/8 0008
 */
public class Sqrt {
    public static int mySqrt(int x) {
//        if(x == 1 || x == 0) return x;
//        double a = 0,b = x;
//        double mid = (a + b) /2;
//        double re = mid * mid;
//        while(re - x > 0.9 || re - x <0){
//            if(re > x){
//                b = mid;
//            }else if(re < x) {
//                a = mid;
//            }else{
//                return (int)mid;
//            }
//            mid = (a + b) / 2;
//            re = mid * mid;
//        }
//        return (int)mid;
        if (x == 0)
            return 0;
        long left = 1, right = (long) x + 1;
        long mid;
        int ans = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (mid > x / mid) {
                right = mid - 1;
            } else {
                ans = (int) mid;
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(2));
        System.out.println(mySqrt(3));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(5));
        System.out.println(mySqrt(Integer.MAX_VALUE));
    }
}
