package com.ny.string;

/**
 * @Author: ny
 * @Date: Created in 9:19 2018/3/6 0006
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int c = 0;
        int i = a.length(), j = b.length();
        while (i > 0 && j > 0) {
            i--;
            j--;
            int bit1 = a.charAt(i) - 48, bit2 = b.charAt(j) - 48;
            builder.insert(0, bit1 ^ bit2 ^ c);
            c = (bit1 + bit2 + c) >= 2 ? 1 : 0;
        }
        if (i <= 0) {
            while (--j >= 0) {
                int bit = b.charAt(j) - 48;
                builder.insert(0, bit ^ c);
                c = bit & c;
            }
        } else if (j <= 0) {
            while (--i >= 0) {
                int bit = a.charAt(i) - 48;
                builder.insert(0, bit ^ c);
                c = bit & c;
            }
        }
        if (c == 1) builder.insert(0, c);
        return builder.toString();
    }

    public static void main(String[] args) {
        addBinary("101111", "101111");
    }
}
