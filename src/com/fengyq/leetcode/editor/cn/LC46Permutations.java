//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2742 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class LC46Permutations {
    public static void main(String[] args) {
        Solution solution = new LC46Permutations().new Solution();
        System.out.println(solution.permute(new int[]{0, 1, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        boolean[] used;

        public List<List<Integer>> permute(int[] nums) {
            used = new boolean[nums.length];
            backtrack(nums, new LinkedList<>());
            return res;
        }

        void backtrack(int[] nums, LinkedList<Integer> track) {
            if (track.size() == nums.length) {
                res.add(new LinkedList<>(track));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }

                track.add(nums[i]);
                used[i]=true;

                backtrack(nums, track);

                used[i]=false;
                track.removeLast();
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}