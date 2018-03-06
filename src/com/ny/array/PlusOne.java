package com.ny.array;

/**
 * @Author: ny
 * @Date: Created in 9:09 2018/3/6 0006
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int c = 0;
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += c;
            c = digits[i] / 10;
            digits[i] %= 10;
        }
        if (c == 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = c;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            return newDigits;
        }
        return digits;
    }

    public static void main(String[] args) {
        plusOne(new int[]{0});
    }
}
