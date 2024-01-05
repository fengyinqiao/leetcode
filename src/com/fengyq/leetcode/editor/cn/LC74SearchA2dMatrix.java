//给你一个满足下述两条属性的 m x n 整数矩阵： 
//
// 
// 每行中的整数从左到右按非严格递增顺序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 874 👎 0


package com.fengyq.leetcode.editor.cn;

public class LC74SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new LC74SearchA2dMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = searchRow(matrix,target);
            if(row == -1) {
                return false;
            }

            if(matrix[row][0] == target) {
                return true;
            }

            int col = binarySearch(matrix[row],target);
            if(col != -1) {
                return true;
            }
            return false;
        }

        int searchRow(int[][] matrix, int target) {
            int left = 0, right = matrix.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (target == matrix[mid][0]) {
                    return mid;
                } else if (target < matrix[mid][0]) {
                    right = mid - 1;
                } else if (target > matrix[mid][0]) {
                    left = mid + 1;
                }
            }
            if(right < 0) {
                return -1;
            }
            return right;
        }

        int binarySearch(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (target == nums[mid]) {
                    return mid;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else if (target > nums[mid]) {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}