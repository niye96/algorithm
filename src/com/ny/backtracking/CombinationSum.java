package com.ny.backtracking;

import java.util.*;

public class CombinationSum {
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
            stack.push(candidates[i]);
            sum += candidates[i];
            if (sum == target) res.add(new ArrayList<>(stack));
            combinationSum(res, stack, candidates, target, sum, i);
            if (!stack.empty()) sum -= (int) stack.pop();
        }
    }

    public static void main(String[] args) {
        combinationSum(new int[]{2, 3, 6, 7}, 7);
        combinationSum(new int[]{2, 3, 6, 7}, 6);
        combinationSum(new int[]{1, 2, 5, 7, 9}, 10);
        combinationSum(new int[]{8, 7, 4, 3}, 11);
    }
}
