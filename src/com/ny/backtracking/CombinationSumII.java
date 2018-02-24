package com.ny.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSumII {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList();
        combinationSum(res, new Stack(), candidates, target, 0, 0);
        return res;
    }

    public static void combinationSum(List<List<Integer>> res, Stack stack, int[] candidates, int target, int sum, int depth) {
        for (int i = depth; i < candidates.length; i++) {
            if (candidates[i] > target - sum) {
                return;
            }
            if (i != depth && candidates[i] == candidates[i - 1]) {
                continue;
            }
            stack.push(candidates[i]);
            sum += candidates[i];
            if (sum == target) res.add(new ArrayList<>(stack));
            combinationSum(res, stack, candidates, target, sum, i + 1);
            if (!stack.empty()) sum -= (int) stack.pop();
        }
    }

    public static void main(String[] args) {
        combinationSum(new int[]{10, 1, 1, 2, 2, 1, 1, 1, 3, 3, 3, 2, 7, 6, 1, 5}, 6);
    }
}
