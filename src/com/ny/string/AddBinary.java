package com.ny.string;

/**
 * @Author: ny
 * @Date: Created in 9:19 2018/3/6 0006
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int c = 0;
        int i = a.length(), j = b.length();
        while (--i >= 0 && --j >= 0) {
            int bit1 = a.charAt(i), bit2 = b.charAt(j);
            builder.insert(0, bit1 ^ bit2 ^ c);
            c = bit1 & bit2;
        }
        return builder.toString();
    }
}
