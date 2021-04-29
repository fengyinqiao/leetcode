//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2363 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.Arrays;

//java:最大子序和
public class LC53MaximumSubarray{
    public static void main(String[] args) {
         Solution solution = new LC53MaximumSubarray().new Solution();
         int[] nums={-2,1,-3,4,-1,2,1,-5,4};
         System.out.println(solution.maxSubArray(nums));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int[] f=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(i==0) {
                f[i]= num;
            }else {
                f[i]= Math.max(num,f[i-1]+num);
            }
        }

        Arrays.sort(f);

        return f[f.length-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}