package com.ny.dp;

import java.util.Arrays;

/**
 * @Author: ny
 * @Date: Created in 17:20 2018/3/5 0005
 */
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
//        int[][] matrix = new int[m][n];
//        for(int i = 0; i < n;i++)matrix[0][i]=1;
//        for(int i = 0; i < m; i++)matrix[i][0]=1;
//        for(int i = 1; i < m;i++){
//            for(int j = 1; j < n;j++){
//                matrix[i][j]=matrix[i-1][j]+matrix[i][j-1];
//            }
//        }
//        return matrix[m - 1][n -1];
//        long total = m + n - 1 - 1;
//        long min = Math.min(m - 1, n - 1);
//        long res = 1;
//        for (int i = 1; i <= min; i++) {
//            res *= (total + 1 - i);
//            res /= i;
//        }
//        return (int) res;

        int[] row = new int[n];
        Arrays.fill(row, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                row[j] += row[j - 1];
            }
        }
        return row[n - 1];
    }

    public static void main(String[] args) {
        uniquePaths(4, 3);
        uniquePaths(1, 2);
        uniquePaths(1, 1);
    }
}
