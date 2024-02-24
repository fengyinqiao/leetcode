//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 941 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Random;

public class LC912SortAnArray {
    public static void main(String[] args) {
        Solution solution = new LC912SortAnArray().new Solution();
        System.out.println(Arrays.toString(solution.sortArray(new int[]{5, 2, 3, 1})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            shuffle(nums);
            QuickSortUtil quickSortUtil = new QuickSortUtil();
            quickSortUtil.quickSort(nums, 0, nums.length - 1);

            shuffle(nums);
            MergeSortUtil mergeSortUtil = new MergeSortUtil(nums);
            mergeSortUtil.mergeSort(nums, 0, nums.length - 1);
            return nums;
        }

        class MergeSortUtil {
            int[] tmp;

            public MergeSortUtil(int[] nums) {
                tmp = new int[nums.length];
            }

            void merge(int[] nums, int left, int mid, int right) {
                for (int i = left; i <= right; i++) {
                    tmp[i] = nums[i];
                }

                int i = left, j = mid + 1;
                while (i <= mid && j <= right) {
                    if (tmp[i] <= tmp[j]) {
                        // 赋值下标是left++，不是i
                        nums[left++] = tmp[i];
                        i++;
                    } else {
                        nums[left++] = tmp[j];
                        j++;
                    }
                }

                if (i == mid + 1) {
                    for (int k = j; k <= right; k++) {
                        nums[left++] = tmp[k];
                    }
                }
                if (j == right + 1) {
                    for (int k = i; k <= mid; k++) {
                        nums[left++] = tmp[k];
                    }
                }
            }

            void mergeSort(int[] nums, int left, int right) {
                if (left >= right) {
                    return;
                }

                int mid = (left + right) / 2;
                mergeSort(nums, left, mid);
                mergeSort(nums, mid + 1, right);
                merge(nums, left, mid, right);
            }
        }

        class QuickSortUtil {
            int partition(int[] nums, int left, int right) {
                int pivotIdx = left, pivotEle = nums[left];
                while (left <= right) {
                    while (left <= right && nums[left] <= pivotEle) {
                        left++;
                    }
                    while (left <= right && nums[right] >= pivotEle) {
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

            void quickSort(int[] nums, int left, int right) {
                if (left >= right) {
                    return;
                }
                int p = partition(nums, left, right);
                quickSort(nums, left, p - 1);
                quickSort(nums, p + 1, right);
            }
        }

        void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        private void shuffle(int[] nums) {
            Random rand = new Random();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                // 生成 [i, n - 1] 的随机数
                int r = i + rand.nextInt(n - i);
                swap(nums, i, r);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}