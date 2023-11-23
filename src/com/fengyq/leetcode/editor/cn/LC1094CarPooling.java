//车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向） 
//
// 给定整数 capacity 和一个数组 trips , trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有
// numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。 
//
// 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 4
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 5
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= trips.length <= 1000 
// trips[i].length == 3 
// 1 <= numPassengersi <= 100 
// 0 <= fromi < toi <= 1000 
// 1 <= capacity <= 10⁵ 
// 
//
// Related Topics 数组 前缀和 排序 模拟 堆（优先队列） 👍 284 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.Arrays;

public class LC1094CarPooling {
    public static void main(String[] args) {
        Solution solution = new LC1094CarPooling().new Solution();
        System.out.println(solution.carPooling(new int[][]{new int[]{2, 1, 5}, new int[]{3, 5, 7}}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int[] nums = new int[1000];
            LC370RangeAddition rangeAddition = new LC370RangeAddition(nums);
            for (int i = 0; i < trips.length; i++) {
                rangeAddition.rangeAddition(trips[i][1], trips[i][2] - 1, trips[i][0]);
            }

            nums = rangeAddition.result();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > capacity) {
                    return false;
                }
            }
            System.out.println(Arrays.toString(nums));
            return true;
        }

        class LC370RangeAddition {
            private final int[] diff;

            public LC370RangeAddition(int[] nums) {
                this.diff = new int[nums.length];
                diff[0] = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    diff[i] = nums[i] - nums[i - 1];
                }
            }

            public LC370RangeAddition rangeAddition(int start, int end, int inc) {
                if (start < 0 || end >= diff.length || start > end) {
                    return this;
                }

                diff[start] += inc;
                if (end + 1 >= diff.length) {
                    return this;
                }
                diff[end + 1] -= inc;
                return this;
            }

            public int[] result() {
                int[] nums = new int[diff.length];
                nums[0] = diff[0];
                for (int i = 1; i < diff.length; i++) {
                    nums[i] = diff[i] + nums[i - 1];
                }
                return nums;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}