package com.ny.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ny
 * @Date: Created in 15:13 2018/3/5 0005
 */
public class PermutationSequence {
    private int count = 0;
    private StringBuffer buffer = new StringBuffer();

    public static String getPermutation(int n, int k) {
        List<Character> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int total = 1;
        for (int i = 1; i <= 9; i++) list.add((char) ('0' + i));
        for (int i = 1; i <= n; i++) total *= i;
        k--;
        while (n > 0) {
            total = total / n--;
            builder.append(list.remove(k / total));
            k = k % total;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        getPermutation(4, 5);
    }


}
