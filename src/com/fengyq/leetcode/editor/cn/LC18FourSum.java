//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 1791 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC18FourSum {
    public static void main(String[] args) {
        Solution solution = new LC18FourSum().new Solution();
        int[] nums={1,0,-1,0,-2,2};
        Arrays.sort(nums);
        System.out.println(solution.nSum(nums,0,4,0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            return nSum(nums,target,4,0);
        }

        //0,1,2
        List<List<Integer>> nSum(int[] nums, long target, int n, int start) {
            List<List<Integer>> res = new LinkedList<>();
            if (n < 2 || nums.length == 0) {
                return res;
            }
            if (n == 2) {
                int left = start, right = nums.length - 1;
                while (left < right) {
                    int leftEle = nums[left];
                    int rightEle = nums[right];
                    if (leftEle + rightEle < target) {
                        while (left<right && nums[left] == leftEle) {
                            left++;
                        }
                    } else if (leftEle + rightEle > target) {
                        while (left<right && nums[right] == rightEle) {
                            right--;
                        }
                    } else {
                        res.add(new LinkedList<>(Arrays.asList(leftEle, rightEle)));
                        while (left<right && nums[left] == leftEle) {
                            left++;
                        }
                    }
                }
                return res;
            }

            for (int left = start;left < nums.length;) {
                int leftEle = nums[left];
                List<List<Integer>> preRes = nSum(nums, target - nums[left], n - 1, left + 1);
                for (List<Integer> preRe : preRes) {
                    preRe.add(nums[left]);
                    res.add(new LinkedList<>(preRe));
                }
                while (left < nums.length && nums[left] == leftEle) {
                    left++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}