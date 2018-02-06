package com.ny.point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (4 * nums[i] > target) break;
            if (i == 0 || nums[i - 1] != nums[i]) {
                List<List<Integer>> temp = threeSum(nums, i + 1, nums.length - 1, target - nums[i]);
                for (int j = 0; j < temp.size(); j++) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.addAll(temp.get(j));
                    res.add(l);
                }

            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums, int lo, int hi, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = lo; i < hi - 1; i++) {
            if (3 * nums[i] > target) break;
            if (i == lo || nums[i - 1] != nums[i]) {
                int low = i + 1, high = hi;
                while (low < high) {
                    if (nums[i] + nums[low] + nums[high] - target < 0) {
                        low++;
                    } else if (nums[i] + nums[low] + nums[high] - target > 0) {
                        high--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        low++;
                        high--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        fourSum(new int[]{-5, -5, -5, -5, -5, 0, 0, 0, 1, 1, 1, 4, 4, 4, 2, 2, 2, 2, 3, 3, 3, 3, 3}, 0);
    }
}
