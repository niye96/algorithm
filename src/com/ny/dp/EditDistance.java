package com.ny.dp;

/**
 * @Author: ny
 * @Date: Created in 20:30 2018/3/8 0008
 */
public class EditDistance {
    public static int minDistance(String word1, String word2) {
//        int m = word1.length(), n = word2.length();
//        if(m == 0 || n == 0) return Math.abs(m - n);
//        int[][] dp = new int[m][n];
//        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 1:0;
//        for(int i = 1; i < n; i++){
//            if(word1.charAt(0) == word2.charAt(i)){
//                dp[0][i] = 1;
//            }else{
//                dp[0][i] = dp[0][i - 1];
//            }
//        }
//        for(int i = 1; i < m; i++){
//            if(word1.charAt(i) == word2.charAt(0)){
//                dp[i][0] = 1;
//            }else{
//                dp[i][0] = dp[i - 1][0];
//            }
//        }
//        for(int i = 1;i < m; i++){
//            for(int j = 1; j < n; j++){
//                if(word1.charAt(i) == word2.charAt(j)){
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                }else{
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//        return Math.max(m,n) - dp[m - 1][n - 1];
        int m = word1.length(), n = word2.length();
        if (m == 0 || n == 0) return Math.abs(m - n);
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = i;
        for (int i = 1; i <= m; i++) {
            int pre = dp[0];
            dp[0] = i;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = pre;
                } else {
                    dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), pre) + 1;
                }
                pre = temp;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("abbaceffber", "acbberff"));
        System.out.println(minDistance("a", "a"));
        System.out.println(minDistance("food", "money"));
        System.out.println(minDistance("ab", "bc"));
    }
}
