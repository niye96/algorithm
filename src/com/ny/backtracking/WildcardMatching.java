package com.ny.backtracking;

import java.util.regex.Pattern;

public class WildcardMatching {

    public static boolean isMatch(String s, String p) {
//        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
//        dp[0][0] = true;
//        int len1 = s.length();
//        int len2 = p.length();
//
//        for (int i = 0; i < len2; i++) {
//            if (p.charAt(i) == '*') {
//                dp[0][i + 1] = dp[0][i];
//            } else {
//                break;
//            }
//        }
//
//        for (int i = 0; i < len1; i++) {
//            for (int j = 0; j < len2; j++) {
//                if (p.charAt(j) == '*') {
//                    dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j];
//                } else if (p.charAt(j) == '?') {
//                    dp[i+1][j+1] = dp[i][j];
//                } else if (s.charAt(i) == p.charAt(j)) {
//                    dp[i+1][j+1] = dp[i][j];
//                }
//            }
//        }
//        return dp[len1][len2];


        //回溯方法，速度超快，比DP快近两倍
        int i = 0;
        int j = 0;
        int starIndex = -1;
        int iIndex = -1;

        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                starIndex = j;
                iIndex = i;
                j++;
            } else if (starIndex != -1) {
                j = starIndex + 1;
                i = iIndex + 1;
                iIndex++;
            } else return false;
        }
        while (j < p.length() && p.charAt(j) == '*') j++;

        return p.length() == j;

//        此方法超时
//        boolean first = false, next = true;
//        if (p.isEmpty() && s.isEmpty()) {
//            first = true;
//        } else if (s.isEmpty() && !p.isEmpty()) {
//            boolean ok = true;
//            for (int i = 0, len = p.length(); i < len; i++) {
//                if (p.charAt(i) != '*') {
//                    ok = false;
//                    break;
//                }
//            }
//            if (ok) first = true;
//        } else if(!s.isEmpty() && p.isEmpty()){
//            ;
//        }else {
//            if (p.charAt(0) == '*') {
//                first = true;
//                next = isMatch(s.substring(1), p) || isMatch(s, p.substring(1));
//            } else if (p.charAt(0) == '?') {
//                first = true;
//                next = isMatch(s.substring(1), p.substring(1));
//            } else {
//                first = p.charAt(0) == s.charAt(0);
//                next = isMatch(s.substring(1), p.substring(1));
//            }
//        }
//        return first && next;
//        if(s==null || p==null) return false;
//        int s_len = s.length();
//        int p_len = p.length();
//
//        boolean[][] d = new boolean[s_len+1][p_len+1];
//        d[0][0] = true;
//
//        for (int i = 0; i < p_len; i++) {
//            if ( p.charAt(i) == '*') d[0][i+1] = d[0][i];
//        }
//
//        for (int i = 0; i < s_len; i++) {
//            for (int j = 0; j < p_len; j++) {
//                if(p.charAt(j) == '?') d[i+1][j+1] = d[i][j];
//                if(p.charAt(j) == s.charAt(i)) d[i+1][j+1] = d[i][j];
//                if(p.charAt(j) == '*') d[i+1][j+1] = d[i+1][j] || d[i][j+1];
//            }
//        }
//
//        return d[s_len][p_len];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("", "*"));
        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatch("aaa", "aa"));
        System.out.println(isMatch("ajgjgjhka", "*"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aa", "?*"));
        System.out.println(isMatch("aab", "*a*b"));
        System.out.println(isMatch("aab", "a**b"));
        System.out.println(isMatch("aacb", "*aab*b"));
        System.out.println(isMatch("aacb", "*aa*b"));
        System.out.println(isMatch("zacabz", "*a?b*"));
        System.out.println(isMatch("babaaababaabababbbbbbaabaabbabababb", "***bba**a*bbba**aab**b"));
    }
}
