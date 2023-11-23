//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2166 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new LC56MergeIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length < 2) {
                return intervals;
            }

            Arrays.sort(intervals, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            });

            List<List<Integer>> res = new ArrayList<>();
            int start = intervals[0][0], end = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                int[] interval = intervals[i];
                if (interval[0] <= end && interval[1] >= end) {
                    end = interval[1];
                }

                if (interval[0] > end) {
                    res.add(Arrays.asList(start,end));
                    start = interval[0];
                    end = interval[1];
                }
            }
            res.add(Arrays.asList(start,end));

            int[][] resArr=new int[res.size()][2];
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    resArr[i][j]=res.get(i).get(j);
                }
            }
            //resArr = res.stream().map(integers -> integers.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);

            return resArr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}