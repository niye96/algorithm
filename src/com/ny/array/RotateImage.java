package com.ny.array;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        int time = matrix.length / 2;
        for (int i = 0; i < time; i++) {
            for (int j = 0; j < matrix.length - 2 * i - 1; j++) {
                int a = matrix[i][i + j];
                int b = matrix[i + j][matrix.length - i - 1];
                int c = matrix[matrix.length - i - 1][matrix.length - i - 1 - j];
                int d = matrix[matrix.length - i - 1 - j][i];
                matrix[i + j][matrix.length - i - 1] = a;
                matrix[matrix.length - i - 1][matrix.length - i - 1 - j] = b;
                matrix[matrix.length - i - 1 - j][i] = c;
                matrix[i][i + j] = d;
            }
        }
    }

    public static void main(String[] args) {
        rotate(new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        });
        rotate(new int[][]{

        });
        rotate(new int[][]{
                {1}
        });
        rotate(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
    }
}
