//这里有 n 个航班，它们分别从 1 到 n 进行编号。 
//
// 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 
//firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。 
//
// 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
//输出：[10,55,45,25,25]
//解释：
//航班编号        1   2   3   4   5
//预订记录 1 ：   10  10
//预订记录 2 ：       20  20
//预订记录 3 ：       25  25  25  25
//总座位数：      10  55  45  25  25
//因此，answer = [10,55,45,25,25]
// 
//
// 示例 2： 
//
// 
//输入：bookings = [[1,2,10],[2,2,15]], n = 2
//输出：[10,25]
//解释：
//航班编号        1   2
//预订记录 1 ：   10  10
//预订记录 2 ：       15
//总座位数：      10  25
//因此，answer = [10,25]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 10⁴ 
// 1 <= bookings.length <= 2 * 10⁴ 
// bookings[i].length == 3 
// 1 <= firsti <= lasti <= n 
// 1 <= seatsi <= 10⁴ 
// 
//
// Related Topics 数组 前缀和 👍 498 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.Arrays;

public class LC1109CorporateFlightBookings {
    public static void main(String[] args) {
        Solution solution = new LC1109CorporateFlightBookings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            LC370RangeAddition rangeAddition = new LC370RangeAddition(new int[n]);

            for (int i = 0; i < bookings.length; i++) {
                rangeAddition.rangeAddition(bookings[i][0] - 1, bookings[i][1] - 1, bookings[i][2]);
            }
            return rangeAddition.result();
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