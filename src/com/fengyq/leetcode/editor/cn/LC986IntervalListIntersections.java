//给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 
//secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。 
//
// 返回这 两个区间列表的交集 。 
//
// 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。 
//
// 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,
//24],[25,26]]
//输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
// 
//
// 示例 2： 
//
// 
//输入：firstList = [[1,3],[5,9]], secondList = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：firstList = [], secondList = [[4,8],[10,12]]
//输出：[]
// 
//
// 示例 4： 
//
// 
//输入：firstList = [[1,7]], secondList = [[3,10]]
//输出：[[3,7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= firstList.length, secondList.length <= 1000 
// firstList.length + secondList.length >= 1 
// 0 <= starti < endi <= 10⁹ 
// endi < starti+1 
// 0 <= startj < endj <= 10⁹ 
// endj < startj+1 
// 
//
// Related Topics 数组 双指针 👍 405 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC986IntervalListIntersections {
    public static void main(String[] args) {
        Solution solution = new LC986IntervalListIntersections().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
            List<List<Integer>> resList = new ArrayList<>();
            if (firstList.length == 0 || secondList.length == 0) {
                return new int[][]{};
            }
            int i = 0, j = 0;
            while (i < firstList.length && j < secondList.length) {
                int firstStart = firstList[i][0];
                int firstEnd = firstList[i][1];
                int secondStart = secondList[j][0];
                int secondEnd = secondList[j][1];

                if (Math.max(firstStart, secondStart) <= Math.min(firstEnd, secondEnd)) {
                    resList.add(Arrays.asList(Math.max(firstStart, secondStart), Math.min(firstEnd, secondEnd)));
                }

                if (firstEnd <= secondEnd) {
                    i++;
                } else {
                    j++;
                }
            }

            /*
            int[][] res = new int[resList.size()][2];
            for (int k = 0; k < resList.size(); k++) {
                List<Integer> integers = resList.get(k);
                for (int l = 0; l < integers.size(); l++) {
                    Integer integer = integers.get(l);
                    res[k][l] = integer;
                }
            }
            */
            int[][] res = resList.stream()
                    .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                    .toArray(int[][]::new);

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}