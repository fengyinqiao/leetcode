//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。 
//
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。 
//
// 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 注意：不允许旋转信封。 
//
// 示例 1： 
//
// 
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。 
//
// 示例 2： 
//
// 
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= envelopes.length <= 10⁵ 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 10⁵ 
// 
//
// Related Topics 数组 二分查找 动态规划 排序 👍 975 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.Arrays;

public class LC354RussianDollEnvelopes {
    public static void main(String[] args) {
        Solution solution = new LC354RussianDollEnvelopes().new Solution();
        int[][] envelopes = new int[][]{new int[]{30, 50}, new int[]{12, 2}, new int[]{3, 4}, new int[]{12, 15}};
        System.out.println(solution.maxEnvelopes(envelopes));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            });

            int[] nums = new int[envelopes.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = envelopes[i][1];
            }

            /*
            //递归解法(会超时)
            this.memo = new int[nums.length];
            Arrays.fill(memo, Integer.MIN_VALUE);

            int res = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                res = Math.max(res, dp(nums, i));
            }
            return res;*/

            //迭代解法(也会超时)
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
            int res = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    res = Math.max(res, dp(nums, j) + 1);
                }
            }

            memo[i] = res;
            return memo[i];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}