//某班级考试成绩按非严格递增顺序记录于整数数组 scores，请返回目标成绩 target 的出现次数。 
//
// 
//
// 示例 1： 
//
// 
//输入: scores = [2, 2, 3, 4, 4, 4, 5, 6, 6, 8], target = 4
//输出: 3 
//
// 示例 2： 
//
// 
//输入: scores = [1, 2, 3, 5, 7, 9], target = 6
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= scores.length <= 10⁵ 
// -10⁹ <= scores[i] <= 10⁹ 
// scores 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
//
// 
//
// Related Topics 数组 二分查找 👍 452 👎 0


package com.fengyq.leetcode.editor.cn;

class LCLCR172ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new LCLCR172ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countTarget(int[] scores, int target) {
            int leftIdx = binarySearchLeft(scores, target);
            int rightIdx = binarySearchRight(scores, target);
            if (leftIdx == -1 && rightIdx == -1) {
                return 0;
            } else if (leftIdx == -1 || rightIdx == -1) {
                return 1;
            } else {
                return rightIdx - leftIdx + 1;
            }
        }

        int binarySearchLeft(int[] nums, int target) {
            if (nums.length == 0) {
                return -1;
            }
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    right = mid - 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }

            if (left < 0 || left >= nums.length) {
                return -1;
            }

            if (nums[left] == target) {
                return left;
            }
            return -1;
        }

        int binarySearchRight(int[] nums, int target) {
            if (nums.length == 0) {
                return -1;
            }
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }

            if (right < 0 || right >= nums.length) {
                return -1;
            }

            if (nums[right] == target) {
                return right;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}