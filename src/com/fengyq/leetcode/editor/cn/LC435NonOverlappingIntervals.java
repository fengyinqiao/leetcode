//给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重
//叠 。 
//
// 
//
// 示例 1: 
//
// 
//输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
//输出: 1
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: intervals = [ [1,2], [1,2], [1,2] ]
//输出: 2
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: intervals = [ [1,2], [2,3] ]
//输出: 0
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= intervals.length <= 10⁵ 
// intervals[i].length == 2 
// -5 * 10⁴ <= starti < endi <= 5 * 10⁴ 
// 
//
// Related Topics 贪心 数组 动态规划 排序 👍 1069 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class LC435NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new LC435NonOverlappingIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            int res = 0;
            if (intervals.length == 1) {
                return 0;
            }

            Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
            int end = Integer.MIN_VALUE;
            for (int[] interval : intervals) {
                int start = interval[0];
                if (start < end) {
                    res++;
                } else {
                    end = interval[1];
                }
            }
            return res;
            //先找重叠的，然后再倒减也可以
            //return intervals.length-intervalSchedule(intervals);
        }

        //找出最多有几个不重叠的区间。
        int intervalSchedule(int[][] intervals) {
            int res = 0;
            if (intervals.length < 2) {
                return intervals.length;
            }
            Arrays.sort(intervals, Comparator.comparingInt(value -> value[1]));

            int end = Integer.MIN_VALUE;
            for (int[] interval : intervals) {
                int start = interval[0];
                if (start >= end) {
                    res++;
                    end = interval[1];
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}