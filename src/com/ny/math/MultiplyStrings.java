package com.ny.math;

import java.math.BigDecimal;

public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        int[] mul = new int[num1.length() + num2.length() - 1];
        StringBuilder result = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                mul[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int c = 0;
        for (int i = mul.length - 1; i >= 0; i--) {
            int a = (mul[i] + c) % 10;
            result.insert(0, a);
            c = (mul[i] + c) / 10;
        }
        if (c != 0)
            result.insert(0, c);
        while (result.length() > 1 && result.charAt(0) == '0') result.deleteCharAt(0);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("0", "40006"));
        System.out.println(297 * 76);
        System.out.println(multiply("254", "452452"));
        System.out.println(254 * 452452);
        System.out.println(multiply("7572", "12222012"));
        System.out.println(7572L * 12222012L);
        System.out.println(multiply("2548797", "12345"));
        System.out.println(2548797L * 12345L);
        System.out.println(multiply("223197", "745456"));
        System.out.println(223197L * 745456L);
    }
}
