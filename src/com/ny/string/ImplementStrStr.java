package com.ny.string;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class ImplementStrStr {
    private int[][] dfa;       // the ImplementStrStr automoton

    private String needle;        // the pattern string

    public static void main(String[] args) {
        System.out.println(KMP("aaaaaaaaaaaaaaaaa", "aaaaaaaaao"));
        System.out.println("aaaaaaaaaaaaaaaaa".indexOf("aaaaaaao"));

        // print results
//        System.out.println("text:    " + txt);

//        System.out.print("pattern: ");
//        for (int i = 0; i < offset1; i++)
//            System.out.print(" ");
//        System.out.println(needle);

    }

    public static int KMP(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (needle.length() > haystack.length()) return -1;
        int[] next = new int[needle.length()];
        if (!needle.isEmpty())
            next[0] = -1;
        for (int i = 1, k = -1; i < needle.length(); i++) {
            while (k > -1 && needle.charAt(i) != needle.charAt(k + 1)) {
                k = next[k];
            }
            if (needle.charAt(i) == needle.charAt(k + 1)) k++;
            next[i] = k;
        }
        int i = 0, j = -1;
        for (; i < haystack.length(); i++) {
            while (j > -1 && needle.charAt(j + 1) != haystack.charAt(i))
                j = next[j];
            if (haystack.charAt(i) == needle.charAt(j + 1))
                j++;
            if (j == needle.length() - 1) {
                return i - j;
            }
        }

        return -1;
    }
//    public int search(String txt) {
//        int res = -1;
//        int x = 0;
//        for (int i = 0, j = 0; i < txt.length(); i++) {
//            j = dfa[txt.charAt(i)][j];
//            if(j == needle.length()){
//                res = i + 1 - j;
//            }
//        }
//        return res;
//    }
//
//    public ImplementStrStr(String needle) {
//        dfa = new int[256][needle.length()];
//        dfa[needle.charAt(0)][0] = 1;
//
//        for (int i = 1, x = 0; i < needle.length(); i++) {
//            for (int j = 0; j < 256; j++) {
//                dfa[j][i] = dfa[j][x];
//            }
//            dfa[needle.charAt(i)][i] = i + 1;
//            x = dfa[needle.charAt(i)][x];
//        }
//    }
}
