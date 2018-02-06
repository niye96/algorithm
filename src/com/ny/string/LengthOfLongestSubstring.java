package com.ny.string;

import java.util.*;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<Character>();
        int length = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
                j--;
            } else {
                set.add(s.charAt(j));
                length = Math.max(length, set.size());
            }
        }
        return length;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring test = new LengthOfLongestSubstring();
        System.out.println(test.lengthOfLongestSubstring("abdvdzcef"));
    }
}
