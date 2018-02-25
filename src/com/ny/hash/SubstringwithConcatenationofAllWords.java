package com.ny.hash;

import java.util.*;

public class SubstringwithConcatenationofAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
//        int N = s.length();
//        List<Integer> indexes = new ArrayList<Integer>(s.length());
//        if (words.length == 0) {
//            return indexes;
//        }
//        int M = words[0].length();
//        if (N < M * words.length) {
//            return indexes;
//        }
//        int last = N - M + 1;
//
//        //map each string in words array to some index and compute target counters
//        Map<String, Integer> mapping = new HashMap<String, Integer>(words.length);
//        int [][] table = new int[2][words.length];
//        int failures = 0, index = 0;
//        for (int i = 0; i < words.length; ++i) {
//            Integer mapped = mapping.get(words[i]);
//            if (mapped == null) {
//                ++failures;
//                mapping.put(words[i], index);
//                mapped = index++;
//            }
//            ++table[0][mapped];
//        }
//
//        //find all occurrences at string S and map them to their current integer, -1 means no such string is in words array
//        int [] smapping = new int[last];
//        for (int i = 0; i < last; ++i) {
//            String section = s.substring(i, i + M);
//            Integer mapped = mapping.get(section);
//            if (mapped == null) {
//                smapping[i] = -1;
//            } else {
//                smapping[i] = mapped;
//            }
//        }
//
//        //fix the number of linear scans
//        for (int i = 0; i < M; ++i) {
//            //reset scan variables
//            int currentFailures = failures; //number of current mismatches
//            int left = i, right = i;
//            Arrays.fill(table[1], 0);
//            //here, simple solve the minimum-window-substring problem
//            while (right < last) {
//                while (currentFailures > 0 && right < last) {
//                    int target = smapping[right];
//                    if (target != -1 && ++table[1][target] == table[0][target]) {
//                        --currentFailures;
//                    }
//                    right += M;
//                }
//                while (currentFailures == 0 && left < right) {
//                    int target = smapping[left];
//                    if (target != -1 && --table[1][target] == table[0][target] - 1) {
//                        int length = right - left;
//                        //instead of checking every window, we know exactly the length we want
//                        if ((length / M) ==  words.length) {
//                            indexes.add(left);
//                        }
//                        ++currentFailures;
//                    }
//                    left += M;
//                }
//            }
//
//        }
//        return indexes;


        List<Integer> res = new ArrayList<>();
        int[] children = new int[s.length()];
        int wordLen = words[0].length();

        Map<String, Integer> map = new HashMap();
        int index = 0;
        int[] wordCount = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            Integer pos = map.get(words[i]);
            if (pos == null) {
                wordCount[index] = 1;
                map.put(words[i], index++);
            } else {
                wordCount[pos]++;
            }
        }

        for (int i = 0, end = children.length - wordLen; i <= end; i++) {
            String str = s.substring(i, i + wordLen);
            Integer pos = map.get(str);
            if (pos == null) {
                children[i] = -1;
            } else {
                children[i] = pos;
            }
        }
        int[] hash = new int[words.length];
        for (int i = 0; i < wordLen; i++) {
            int count = 0;
            int right = i, left = i, end = children.length - wordLen;
            Arrays.fill(hash, 0);
            while (right <= end) {
                //right指针不断向右移动，碰到-1则重置
                int failure = 0;
                while (count < map.size() && right <= end) {
                    //如果count!=0 并且 接收到 -1，清零重置
                    int target = children[right];
                    if (target == -1) {
                        if (count != 0) {
                            count = 0;
                            Arrays.fill(hash, 0);
                        }
                        right += wordLen;
                        left = right;
                    } else {
                        hash[target]++;
                        if (hash[target] == wordCount[target]) {
                            count++;
                        } else if (hash[target] > wordCount[target]) {
                            failure++;
                        }
                        right += wordLen;
                    }
                }
                //移动left指针
                while (failure > 0 && left < right) {
                    int target = children[left];
                    if (hash[target] > wordCount[target]) failure--;
                    else count--;
                    hash[target]--;
                    left += wordLen;
                }
                if (failure == 0 && map.size() == count) {
                    res.add(left);
                    hash[children[left]]--;
                    count--;
                    left += wordLen;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        findSubstring("aaaaaaaa", new String[]{"aa", "aa", "aa"});
        findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"});
        findSubstring("barfoofoobarthefoobarman", new String[]{"foo", "bar", "the"});
    }
}
