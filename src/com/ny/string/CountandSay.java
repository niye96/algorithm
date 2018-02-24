package com.ny.string;

public class CountandSay {
    public static String countAndSay(int n) {
        String res = "1";
        while (--n > 0) {
            StringBuilder temp = new StringBuilder();
            char pre = res.charAt(0);
            int count = 0;
            for (int i = 0; i < res.length(); i++) {
                if (pre != res.charAt(i)) {
                    temp.append(count);
                    temp.append(pre);
                    pre = res.charAt(i);
                    count = 0;
                }
                count++;
            }
            temp.append(count);
            temp.append(pre);
            res = temp.toString();
        }
        return res;
    }

    public static void main(String[] args) {
//        countAndSay(1);
//        countAndSay(2);
//        countAndSay(3);
        countAndSay(4);
        countAndSay(5);
    }
}
