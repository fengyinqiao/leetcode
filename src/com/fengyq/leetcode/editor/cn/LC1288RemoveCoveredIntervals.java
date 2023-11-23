//给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。 
//
// 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。 
//
// 在完成所有删除操作后，请你返回列表中剩余区间的数目。 
//
// 
//
// 示例： 
//
// 
//输入：intervals = [[1,4],[3,6],[2,8]]
//输出：2
//解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 1000 
// 0 <= intervals[i][0] < intervals[i][1] <= 10^5 
// 对于所有的 i != j：intervals[i] != intervals[j] 
// 
//
// Related Topics 数组 排序 👍 108 👎 0


package com.fengyq.leetcode.editor.cn;

import com.oracle.tools.packager.Log;

import java.util.Arrays;
import java.util.Comparator;

public class LC1288RemoveCoveredIntervals {
    public static void main(String[] args) {
        Solution solution = new LC1288RemoveCoveredIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            if (intervals.length < 2) {
                return intervals.length;
            }

            int res = 0;
            long start = Long.MIN_VALUE, end = Long.MIN_VALUE;
            Arrays.sort(intervals, (o1, o2) -> {
                if(o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            });

            for (int i = 0; i < intervals.length; i++) {
                int[] interval = intervals[i];
                if (interval[0] >= start && interval[1] <= end) {
                    res++;
                }

                if (interval[0] <= end && interval[1] >= end) {
                    end = interval[1];
                }

                if (interval[0] > end) {
                    start = interval[0];
                    end = interval[1];
                }
            }

            return intervals.length - res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}