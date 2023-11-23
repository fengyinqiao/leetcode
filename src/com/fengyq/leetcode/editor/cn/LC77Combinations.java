//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics 回溯 👍 1534 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//      []
//    /  |  \
//  [0] [1] [2]
public class LC77Combinations {
    public static void main(String[] args) {
        Solution solution = new LC77Combinations().new Solution();
        System.out.println(solution.combine(3, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();

        public List<List<Integer>> combine(int n, int k) {
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
            }
            backtrack(nums, track, 0, k);
            return res;
        }

        void backtrack(int[] nums, LinkedList<Integer> track, int start, int k) {
            if (track.size() == k) {
                res.add(new LinkedList<>(track));
                return;
            }
            for (int i = start; i < nums.length; i++) {
                int num = nums[i];
                track.add(num);
                backtrack(nums, track, i + 1, k);
                track.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}