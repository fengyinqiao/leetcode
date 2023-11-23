//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2632 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.Arrays;

public class LC322CoinChange {
    public static void main(String[] args) {
        Solution solution = new LC322CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            /*//递归解法
            this.memo = new int[amount + 1];
            Arrays.fill(memo, Integer.MAX_VALUE);
            return dp(coins, amount);
            */

            //迭代解法
            return dpIteration(coins, amount);
        }

        int dpIteration(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            //base case
            dp[0] = 0;
            //遍历状态
            for (int i = 1; i < dp.length; i++) {
                //做选择，求最值，更新状态
                int res = Integer.MAX_VALUE;
                for (int coin : coins) {
                    if (i - coin < 0 || dp[i - coin] == -1) {
                        continue;
                    }
                    res = Math.min(dp[i - coin] + 1, res);
                }

                if (res == Integer.MAX_VALUE) {
                    dp[i] = -1;
                } else {
                    dp[i] = res;
                }
            }
            return dp[amount];
        }

        int[] memo;

        int dp(int[] coins, int amount) {
            //base case
            if (amount == 0) {
                return 0;
            }
            if (amount < 0) {
                return -1;
            }

            if (memo[amount] != Integer.MAX_VALUE) {
                return memo[amount];
            }
            //做选择，求最值，更新状态
            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                int dpRes = dp(coins, amount - coin);
                if (dpRes == -1) {
                    continue;
                }
                res = Math.min(dpRes + 1, res);
            }

            if (res == Integer.MAX_VALUE) {
                memo[amount] = -1;
                return memo[amount];
            }
            memo[amount] = res;
            return memo[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}