package com.ny.array;

/**
 * @Author: ny
 * @Date: Created in 14:50 2018/3/5 0005
 */
public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int count = 0;
        int midLen = n / 2;
        for (int i = 0; i < midLen; i++) {
            int temp = n - i - 1;
            for (int j = i; j < temp; j++) result[i][j] = ++count;
            for (int j = i; j < temp; j++) result[j][temp] = ++count;
            for (int j = temp; j > i; j--) result[temp][j] = ++count;
            for (int j = temp; j > i; j--) result[j][i] = ++count;
        }
        if (n % 2 == 1) result[midLen][midLen] = ++count;
        return result;
    }

    public static void main(String[] args) {
        generateMatrix(0);
        generateMatrix(1);
        generateMatrix(2);
        generateMatrix(3);
        generateMatrix(5);
    }
}
