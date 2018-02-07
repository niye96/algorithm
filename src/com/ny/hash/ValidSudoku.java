package com.ny.hash;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map row = new HashMap();
        Map col = new HashMap();
        Map square = new HashMap();
        for (int i = 0; i < board.length; i++) {
            row.clear();
            col.clear();
            square.clear();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    if (row.get(board[i][j]) == null) {
                        row.put(board[i][j], true);
                    } else {
                        return false;
                    }
                }
                if (board[j][i] != '.') {
                    if (col.get(board[j][i]) == null) {
                        col.put(board[j][i], true);
                    } else {
                        return false;
                    }
                }
                int x = j / 3 + i / 3 * 3;
                int y = j % 3 + i % 3 * 3;
                if (board[x][y] != '.') {
                    if (square.get(board[x][y]) == null) {
                        square.put(board[x][y], true);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
//    public boolean isValidSudoku(char[][] board) {
//        Set seen = new HashSet();
//        for (int i=0; i<9; ++i) {
//            for (int j=0; j<9; ++j) {
//                char number = board[i][j];
//                if (number != '.')
//                    if (!seen.add(number + " in row " + i) ||
//                            !seen.add(number + " in column " + j) ||
//                            !seen.add(number + " in block " + i/3 + "-" + j/3))
//                        return false;
//            }
//        }
//        return true;
//    }

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.println("(" + i + "," + j + ")->" + "(" + (j / 3 + i / 3 * 3) + "," + (j % 3 + i % 3 * 3) + ")");
            }
        }
    }
}
