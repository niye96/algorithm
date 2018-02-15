package com.ny.hash;

import java.util.Stack;

public class SudokuSolver {
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][] box = new boolean[9][9];
    Stack<int[]> stack = new Stack<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    row[i][c - '1'] = true;
                    col[j][c - '1'] = true;
                    box[i / 3 * 3 + j / 3][c - '1'] = true;
                }
            }
        }
        for (int i = 8; i >= 0; i--) {
            for (int j = 8; j >= 0; j--) {
                if (board[i][j] == '.')
                    stack.push(new int[]{i, j});
            }
        }
        solve(board);
    }

    private void solve(char[][] board) {
        if (stack.isEmpty()) return;
        int[] point = stack.pop();
        for (int i = 0; i < 9; i++) {
            if (row[point[0]][i] == false) {
                if (check(board, point[0], point[1], (char) ('1' + i))) {
                    put(board, point[0], point[1], (char) ('1' + i));
                    solve(board);
                    if (stack.isEmpty()) return;
                    back(board, point[0], point[1], (char) ('1' + i));
                }
            }
        }
        stack.push(new int[]{point[0], point[1]});
    }

    private void put(char[][] board, int r, int c, char num) {
        board[r][c] = num;
        row[r][num - '1'] = true;
        col[c][num - '1'] = true;
        box[r / 3 * 3 + c / 3][num - '1'] = true;
    }

    private void back(char[][] board, int r, int c, char num) {
        board[r][c] = '.';
        row[r][num - '1'] = false;
        col[c][num - '1'] = false;
        box[r / 3 * 3 + c / 3][num - '1'] = false;
    }

    private boolean check(char[][] board, int r, int c, char num) {
        if (row[r][num - '1'] || col[c][num - '1'] || box[r / 3 * 3 + c / 3][num - '1'])
            return false;
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver solver = new SudokuSolver();
        solver.solveSudoku(new char[][]{
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        });
    }
}
