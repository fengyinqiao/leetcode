//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 200 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1608 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.Arrays;

public class LC64MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new LC64MinimumPathSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;

        public int minPathSum(int[][] grid) {
            /* 递归解法
            this.memo = new int[grid.length][grid[0].length];
            for (int[] ints : memo) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }

            return dp(grid, grid.length - 1, grid[0].length - 1);
            */

            //迭代解法
            return dpIteration(grid);
        }

        int dp(int[][] grid, int i, int j) {
            //base case
            if (i == 0 && j == 0) {
                return grid[0][0];
            }
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                return Integer.MAX_VALUE;
            }
            if (memo[i][j] != Integer.MAX_VALUE) {
                return memo[i][j];
            }
            //做选择，求最值，更新状态（递归解法不需要在for循环中遍历状态并更新，因为递归是自顶向下的，递归的过程就是在遍历状态）
            memo[i][j] = Math.min(
                    dp(grid, i, j - 1),
                    dp(grid, i - 1, j)) + grid[i][j];
            return memo[i][j];
        }

        int dpIteration(int[][] grid) {
            int[][] dp = new int[grid.length][grid[0].length];
            //base case
            dp[0][0] = grid[0][0];
            for (int j = 1; j < grid[0].length; j++) {
                dp[0][j] = dp[0][j - 1] + grid[0][j];
            }
            for (int i = 1; i < grid.length; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }

            //遍历状态
            for (int i = 1; i < grid.length; i++) {
                for (int j = 1; j < grid[0].length; j++) {
                    //做选择，求最值，更新状态
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }

            return dp[grid.length - 1][grid[0].length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}