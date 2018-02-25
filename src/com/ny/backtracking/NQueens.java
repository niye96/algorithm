package com.ny.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] chessboard = new int[n];
        Arrays.fill(chessboard, -1);
        solveNQueens(res, chessboard, 0);
        return res;
    }

    public void solveNQueens(List<List<String>> res, int[] chessboard, int depth) {
        if (depth == chessboard.length) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < chessboard.length; i++) {
                char[] line = new char[chessboard.length];
                Arrays.fill(line, '.');
                line[chessboard[i]] = 'Q';
                temp.add(String.valueOf(line));
            }
            res.add(temp);
            return;
        }
        for (int i = 0; i < chessboard.length; i++) {
            //判断(depth, i)落位是否合理
            boolean isValid = true;
            for (int j = 0; j < depth; j++) {
                //竖着 斜着
                if (i == chessboard[j] || Math.abs(chessboard[j] - i) == Math.abs(j - depth)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                chessboard[depth] = i;
                solveNQueens(res, chessboard, depth + 1);
                chessboard[depth] = -1;
            }
        }
    }

    public static void main(String[] args) {
        new NQueens().solveNQueens(4);
    }
}
