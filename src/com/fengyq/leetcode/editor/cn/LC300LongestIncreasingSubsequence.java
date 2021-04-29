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
//java:最长上升子序列
public class LC300LongestIncreasingSubsequence{
    public static void main(String[] args) {
         Solution solution = new LC300LongestIncreasingSubsequence().new Solution();
        int[] nums={10,9,2,5,3,7,101,18};
        System.out.println(solution.lengthOfLIS(nums));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0) {
            return 0;
        }

        int[] f=new int[nums.length];
        int max=1;
        for (int i = 0; i < nums.length; i++) {
            f[i]=maxLen(nums,f,i)+1;
        }

        for (int i = 0; i < f.length; i++) {
            if(f[i]>max) {
                max=f[i];
            }
        }
        return max;
    }

        private int maxLen(int[] nums,int[] f,int i) {
            int max=0;
            for (int j = 0; j < i; j++) {
                if(f[j]>max && nums[j]<nums[i]) {
                    max=f[j];
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}