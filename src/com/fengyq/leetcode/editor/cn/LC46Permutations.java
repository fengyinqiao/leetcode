//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1287 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:全排列
public class LC46Permutations {
    public static void main(String[] args) {
        Solution solution = new LC46Permutations().new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}).size());
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[] visible;
        List<List<Integer>> res;

        public List<List<Integer>> permute(int[] nums) {
            res = new ArrayList<>();
            if (nums == null) {
                return res;
            }
            visible = new boolean[nums.length];
            Arrays.fill(visible, true);

            for (int i = 0; i < nums.length; i++) {
                List<Integer> list = new ArrayList<>();
                backtracking(nums, i, list);
            }
            return res;
        }

        void backtracking(int[] nums, int idx, List<Integer> list) {
            if (!visible[idx]) {
                return;
            }

            visible[idx] = false;
            list.add(nums[idx]);
            if (list.size() == nums.length) {
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                visible[idx] = true;
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                backtracking(nums, i, list);
            }
            list.remove(list.size() - 1);
            visible[idx] = true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}