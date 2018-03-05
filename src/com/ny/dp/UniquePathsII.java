package com.ny.dp;

/**
 * @Author: ny
 * @Date: Created in 20:17 2018/3/5 0005
 */
public class UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] grid = new int[row][col];
        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 1) break;
            grid[0][i] = 1;
        }
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) break;
            grid[i][0] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                }
            }
        }
        return grid[row - 1][col - 1];

    }

    public static void main(String[] args) {
        uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 0, 1},
                {0, 0, 0},
                {0, 1, 0}
        });
    }
}
