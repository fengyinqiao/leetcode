//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2363 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.Arrays;

//java:最大子序和
public class LC53MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new LC53MaximumSubarray().new Solution();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            /* 递归解法
            this.memo = new int[nums.length];
            Arrays.fill(memo, Integer.MIN_VALUE);

            int res = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                res = Math.max(res, dp(nums, i));
            }
            return res;
            */

            // 迭代解法
            return dpIteration(nums);
        }

        int[] memo;

        int dp(int[] nums, int i) {
            //base case
            if (nums.length == 0) {
                return 0;
            }
            if (i == 0) {
                return nums[0];
            }

            if (memo[i] != Integer.MIN_VALUE) {
                return memo[i];
            }

            //做选择，求最值，更新状态（递归解法不需要在for循环中遍历状态并更新，因为递归是自顶向下的，递归的过程就是在遍历状态）
            memo[i] = Math.max(dp(nums, i - 1) + nums[i], nums[i]);
            return memo[i];
        }

        int dpIteration(int[] nums) {
            int[] dp = new int[nums.length];
            //base case
            dp[0] = nums[0];
            //遍历状态
            for (int i = 1; i < dp.length; i++) {
                //做选择，求最值，更新状态
                dp[i] = Math.max(dp[i-1] + nums[i] ,nums[i]);
            }

            int res = Integer.MIN_VALUE;
            for (int i = 0; i < dp.length; i++) {
                res=Math.max(res,dp[i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}