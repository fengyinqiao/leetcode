//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划 
// 👍 946 👎 0


package com.fengyq.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

//java:最长上升子序列
public class LC300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LC300LongestIncreasingSubsequence().new Solution();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(solution.lengthOfLIS(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            /*
            //递归解法
            this.memo=new int[nums.length];
            Arrays.fill(memo,Integer.MIN_VALUE);

            int res = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                res = Math.max(res, dp(nums, i));
            }
            return res;
            */

            //迭代解法
            return dpIteration(nums);
        }

        int dpIteration(int[] nums) {
            int[] dp = new int[nums.length];
            //base case
            Arrays.fill(dp,1);

            int res = dp[0];

            //遍历状态
            for (int i = 1; i < dp.length; i++) {
                //做选择，求最值，更新状态
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
                res=Math.max(res,dp[i]);
            }

            return res;
        }

        int[] memo;

        int dp(int[] nums, int i) {
            //base case
            if (nums.length == 0) {
                return 0;
            }
            if (i == 0) {
                return 1;
            }

            if (memo[i] != Integer.MIN_VALUE) {
                return memo[i];
            }

            //做选择，求最值，更新状态
            int res = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    res = Math.max(res, dp(nums, j) + 1);
                }
            }

            if (res == Integer.MIN_VALUE) {
                memo[i] = 1;
                return memo[i];
            }
            memo[i] = res;
            return memo[i];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}