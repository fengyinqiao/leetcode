//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3468 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class LC22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new LC22GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res = new LinkedList<>();

        public List<String> generateParenthesis(int n) {
            backtrack(new LinkedList<>(), n, n);

            List<String> ans = new LinkedList<>();
            for (List<String> re : res) {
                StringBuilder sb = new StringBuilder();
                for (String s : re) {
                    sb.append(s);
                }
                ans.add(sb.toString());
            }
            return ans;
        }

        void backtrack(LinkedList<String> track, int left, int right) {
            if (right < left) {
                return;
            }
            if (right < 0 || left < 0) {
                return;
            }
            if (left == 0 && right == 0) {
                res.add(new LinkedList<>(track));
                return;
            }

            track.add("(");
            backtrack(track, left - 1, right);
            track.removeLast();

            track.add(")");
            backtrack(track, left, right - 1);
            track.removeLast();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}