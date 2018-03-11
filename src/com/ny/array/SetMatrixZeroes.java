package com.ny.array;

/**
 * @Author: ny
 * @Date: Created in 13:47 2018/3/11 0011
 */
public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        boolean row = false, col = false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) row = true;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) matrix[i][j] = 0;
            }
            if (row == true) matrix[i][0] = 0;
        }
        System.out.println(1);
    }

    public static void main(String[] args) {
        setZeroes(new int[][]{
                {0, 0, 0, 5},
                {4, 3, 1, 4},
                {0, 1, 1, 4},
                {1, 2, 1, 3},
                {0, 0, 1, 1}
        });

        setZeroes(new int[][]{{1}});
    }
}
