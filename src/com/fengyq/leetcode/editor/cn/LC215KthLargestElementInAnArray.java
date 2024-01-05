//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2358 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.Random;

public class LC215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new LC215KthLargestElementInAnArray().new Solution();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            k = nums.length - k;
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int partition = partition(nums, left, right);
                if (k < partition) {
                    right = partition - 1;
                } else if (k > partition) {
                    left = partition + 1;
                } else if (k == partition) {
                    return nums[partition];
                }
            }

            return -1;
        }

        int partition(int[] nums, int left, int right) {
            if (left > right) {
                return -1;
            }
            int pivotIdx = left;
            int pivot = nums[pivotIdx];
            left = pivotIdx + 1;
            while (left <= right) {
                while (left <= right && nums[left] <= pivot) {
                    left++;
                }
                while (left <= right && nums[right] > pivot) {
                    right--;
                }

                if (left > right) {
                    break;
                }

                swap(nums, left, right);
            }
            swap(nums, pivotIdx, right);

            return right;
        }

        void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}