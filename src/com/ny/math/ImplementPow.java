package com.ny.math;

public class ImplementPow {
    public static double myPow(double x, int n) {
//        double mul = 1;
//        int i = 0;
//        boolean flag = true;
//        if (n < 0) {
//            flag = false;
//            mul = 1/x;
//            n = -(n+1);
//        }
//        while (n > 0) {
//            if (n % 2 == 1) {
//                double temp;
//                if (flag == true)
//                    temp = x;
//                else
//                    temp = 1 / x;
//                for (int j = 0; j < i; j++) {
//                    temp = temp * temp;
//                }
//                mul *= temp;
//            }
//            n = n >> 1;
//            i++;
//        }
//        return mul;
        //牛逼方法
        if (x == 0) {
            return 0;
        }

        double result = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                if (n > 0) {
                    result *= x;
                } else {
                    result /= x;
                }
            }
            x *= x;
            n /= 2;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 3));
//        System.out.println(-3%2);
    }
}
