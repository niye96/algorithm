package com.ny.backtracking;

/**
 * @Author: ny
 * @Date: Created in 14:38 2018/3/16 0016
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        if (board == null || board.length == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(board, word, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int row, int col) {
        if (word.length() == 0) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;

        int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        if (board[row][col] == word.charAt(0) && board[row][col] != 0) {
            for (int i = 0; i < 4; i++) {
                char temp = board[row][col];
                board[row][col] = 0;
                boolean res = dfs(board, word.substring(1), row + direction[i][0], col + direction[i][1]);
                board[row][col] = temp;
                if (res) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new WordSearch().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED");
        new WordSearch().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "SEE");
        new WordSearch().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCB");
    }
}
