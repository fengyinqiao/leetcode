//给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。 
//
// 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第
//一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1
//, col + 1) 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
//输出：13
//解释：如图所示，为和最小的两条下降路径
// 
//
// 示例 2： 
//
// 
//
// 
//输入：matrix = [[-19,57],[-40,-5]]
//输出：-59
//解释：如图所示，为和最小的下降路径
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 321 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.Arrays;

public class LC931MinimumFallingPathSum {
    public static void main(String[] args) {
        Solution solution = new LC931MinimumFallingPathSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] memo;

        public int minFallingPathSum(int[][] matrix) {
            memo = new int[matrix.length][matrix[0].length];
            for (int[] ints : memo) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }

            int res = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.min(res, dp(matrix, matrix.length - 1, j));
            }

            return res;
        }

        int dp(int[][] matrix, int i, int j) {
            //base case
            if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
                return Integer.MAX_VALUE;
            }
            if (i == 0) {
                return matrix[0][j];
            }

            //优先从备忘录找
            if (memo[i][j] != Integer.MAX_VALUE) {
                return memo[i][j];
            }

            //做选择，求最值
            memo[i][j] = Math.min(Math.min(
                    dp(matrix, i - 1, j - 1),
                    dp(matrix, i - 1, j)),
                    dp(matrix, i - 1, j + 1)) + matrix[i][j];
            return memo[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}