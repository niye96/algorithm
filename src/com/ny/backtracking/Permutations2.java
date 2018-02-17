package com.ny.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutations2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, res, 0);
        return res;
    }

    private void permute(int[] nums, List res, int depth) {
        if (depth == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                list.add(nums[j]);
            }
            res.add(list);
        }
        Map<String, Boolean> check = new HashMap<>();
        for (int i = depth; i < nums.length; i++) {
            if (check.containsKey(nums[depth] + "," + nums[i])) {
                continue;
            }
            swap(nums, i, depth);
            if ((i == depth || nums[i] != nums[depth]) && !check.containsKey(nums[depth] + "," + nums[i])) {
                permute(nums, res, depth + 1);
            }
            check.put(nums[depth] + "," + nums[i], true);
            swap(nums, i, depth);

        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
//        new Permutations().permute(new int[]{-1,-1,2,3});
//        new Permutations().permute(new int[]{-1,-1,-1,3});
//        new Permutations().permute(new int[]{-1,-1,3,3});
        new Permutations().permute(new int[]{-1});
        new Permutations().permute(new int[]{});
//        ArrayList list = new ArrayList();
//        ArrayList b = new ArrayList();
//        b.add(1);
//        list.add(b);
//        b.add(2);
//        list.add(b);
//        System.out.println(1);
        Map<String, Boolean> check = new HashMap<>();
        check.put(-1 + "" + 3, true);
        System.out.println(check.get(-1 + "" + 3));
    }
}
