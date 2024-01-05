//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4288 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.Stack;

public class LC20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LC20ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c=='('||c=='['||c=='{') {
                    stack.push(c);
                }else {
                    if(stack.empty()) {
                        return false;
                    }

                    char peek = stack.pop();
                    if(c==')' && peek!='('){
                        return false;
                    }
                    if(c==']' && peek!='['){
                        return false;
                    }
                    if(c=='}' && peek!='{'){
                        return false;
                    }
                }
            }

            return stack.empty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}