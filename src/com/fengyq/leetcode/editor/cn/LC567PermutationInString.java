//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 989 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.HashMap;

public class LC567PermutationInString {
    public static void main(String[] args) {
        Solution solution = new LC567PermutationInString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
            for (char c : s1.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            int left = 0, right = 0, valid = 0;
            while (right < s2.length()) {
                char c = s2.charAt(right);
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (need.get(c).equals(window.get(c))) {
                        valid++;
                    }
                }
                right++;

                //System.out.println("window = " + window);

                while (valid == need.size()) {
                    if (right - left == s1.length()) {
                        return true;
                    }

                    char d = s2.charAt(left);
                    if (need.containsKey(d)) {
                        if (need.get(d).equals(window.getOrDefault(d, 0))) {
                            valid--;
                        }
                        window.put(d, window.getOrDefault(d, 0) - 1);
                    }
                    left++;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}