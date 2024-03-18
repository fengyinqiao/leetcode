//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2834 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.HashMap;

public class LC76MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new LC76MinimumWindowSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            String res = "";
            int resLen = Integer.MAX_VALUE, start = 0;
            HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
            for (char c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }


            int left = 0, right = 0, valid = 0;
            while (right < s.length()) {
                // c 是将移入窗口的字符
                char c = s.charAt(right);
                // 进行窗口内数据的一系列更新
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (need.get(c).equals(window.get(c))) {
                        valid++;
                    }
                }
                // 增大窗口
                right++;

                // 打印窗口，debug
                //System.out.printf("window: %s\n", window);

                while (valid == need.size()) {
                    // 更新答案
                    if (right - left < resLen) {
                        start = left;
                        resLen = right - left;
                    }

                    // d 是将移出窗口的字符
                    char d = s.charAt(left);
                    // 进行窗口内数据的一系列更新
                    if (need.containsKey(d)) {
                        if (need.get(d).equals(window.getOrDefault(d, 0))) {
                            valid--;
                        }
                        window.put(d, window.getOrDefault(d, 0) - 1);
                    }
                    // 缩小窗口
                    left++;
                }
            }

            if (resLen != Integer.MAX_VALUE) {
                res = s.substring(start, resLen + start);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}