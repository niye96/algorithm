package com.ny.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] str = "00000000000000000000000000".toCharArray();
            for (int j = 0; j < strs[i].length(); j++) {
                int pos = strs[i].charAt(j) - 'a';
                str[pos] = (char) (str[pos] + 1);
            }
            String key = String.valueOf(str);
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);

            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        List list = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        Map<String, String> map = new HashMap<>();
        String a = "123";
        String b = String.valueOf(new char[]{'1', '2', '3'});
        System.out.println(a.equals(b));
        System.out.println(a == b);
        map.put(a, "sadsadsa");
        map.put(b, "@34");
        System.out.println(map.get(a));
    }
}
