package com.fengyq.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC3sum {
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int startEle=nums[i];
            List<List<Integer>> twoSumRes=twoSum(nums, i+1, -1-startEle);
            for (List<Integer> twoSumRe : twoSumRes) {
                List<Integer> threeSumRe = new ArrayList<>(twoSumRe);
                threeSumRe.add(startEle);
                res.add(threeSumRe);
            }
            while(i < nums.length - 1 && nums[i+1] == startEle ) {
                i++;
            }
        }
        System.out.println(res);
    }

    public static List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int left = start, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            int leftEle= nums[left], rightEle = nums[right];
            if(sum == target) {
                res.add(Arrays.asList(nums[left], nums[right]) );
                while(nums[left] == leftEle && left < right) {
                    left++;
                }
                while(rightEle == nums[right] && left < right) {
                    right--;
                }
            } else if(sum < target) {
                while(nums[left] == leftEle && left < right) {
                    left++;
                }
            } else {
                while(rightEle == nums[right] && left < right) {
                    right--;
                }
            }
        }
        return  res;
    }
}
