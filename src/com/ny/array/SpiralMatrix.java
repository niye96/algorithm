package com.ny.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ny
 * @Date: Created in 8:53 2018/3/5 0005
 */
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        int count = Math.min(m, n) / 2;
        for (int i = 0; i < count; i++) {
            for (int j = i; j < n - 1 - i; j++) result.add(matrix[i][j]);
            for (int j = i; j < m - 1 - i; j++) result.add(matrix[j][n - i - 1]);
            for (int j = n - i - 1; j > i; j--) result.add(matrix[m - 1 - i][j]);
            for (int j = m - i - 1; j > i; j--) result.add(matrix[j][i]);
        }
        if (m >= n) {
            if (n % 2 == 1) {
                for (int i = count; i < m - count; i++) {
                    result.add(matrix[i][count]);
                }
            }
        } else {
            if (m % 2 == 1) {
                for (int i = count; i < n - count; i++) {
                    result.add(matrix[count][i]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        spiralOrder(new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}});
        spiralOrder(new int[][]{{1}, {2}, {3}, {4}, {5}, {6}, {7}});
        spiralOrder(new int[][]{});
        spiralOrder(new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {11, 12, 13, 14, 16, 17, 18, 19, 20, 21}});
        spiralOrder(new int[][]{{1}});
        spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {6, 7, 8, 9},
                {11, 12, 13, 14},
                {16, 17, 18, 19},
                {20, 21, 22, 23}
        });
        spiralOrder(new int[][]{
                {2, 3, 4},
                {7, 8, 9},
                {12, 13, 14},
                {17, 18, 19},
                {21, 22, 23}
        });
    }
}
