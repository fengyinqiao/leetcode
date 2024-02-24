//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 2211 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LC560SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new LC560SubarraySumEqualsK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int preSum = 0, res = 0;
            for (int i = 0; i < nums.length; i++) {
                preSum += nums[i];
                res += map.getOrDefault(preSum - k, 0);

                int cnt = map.getOrDefault(preSum, 0);
                map.put(preSum, ++cnt);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}