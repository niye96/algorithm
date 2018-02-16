package com.ny.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, res, 0);
        return res;
    }

    private void permute(int[] nums, List res, int depth) {
        for (int i = depth; i < nums.length; i++) {
            swap(nums, i, depth);
            permute(nums, res, depth + 1);
            if (depth == nums.length - 1) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < nums.length; j++) {
                    list.add(nums[j]);
                }
                res.add(list);
            }
            swap(nums, i, depth);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        new Permutations().permute(new int[]{});
//        ArrayList list = new ArrayList();
//        ArrayList b = new ArrayList();
//        b.add(1);
//        list.add(b);
//        b.add(2);
//        list.add(b);
//        System.out.println(1);
    }
}
