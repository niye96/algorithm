package com.ny.numbers;


public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) return dividend > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        boolean flag = (dividend ^ divisor) < 0 ? false : true;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int i = 31;
        long sum = 0;
        while (a > 0 && i >= 0) {
            if (a >> i >= b) {
                a = a - (b << i);
                sum += (long) 1 << i;
            }
            i--;
        }
        sum = flag ? sum : -sum;
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int) sum;
    }

    public static void main(String[] args) {
        System.out.println(divide(50, 4));
    }
}
