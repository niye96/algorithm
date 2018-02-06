package com.ny.numbers;

public class IntegertoRoman {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            int head = num / values[i];
            num = num % values[i];
            for (int j = 0; j < head; j++) {
                res.append(strs[i]);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {

    }
}
