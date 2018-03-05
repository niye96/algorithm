package com.ny.string;

/**
 * @Author: ny
 * @Date: Created in 13:35 2018/3/5 0005
 */
public class LengthofLastWord {
    public static int lengthOfLastWord(String s) {
        int len = 0;
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') break;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        lengthOfLastWord("Hello World");
    }
}
