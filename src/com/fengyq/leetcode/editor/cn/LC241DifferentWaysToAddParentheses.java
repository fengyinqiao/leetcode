//给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。 
//
// 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 10⁴ 。 
//
// 
//
// 示例 1： 
//
// 
//输入：expression = "2-1-1"
//输出：[0,2]
//解释：
//((2-1)-1) = 0 
//(2-(1-1)) = 2
// 
//
// 示例 2： 
//
// 
//输入：expression = "2*3-4*5"
//输出：[-34,-14,-10,-10,10]
//解释：
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= expression.length <= 20 
// expression 由数字和算符 '+'、'-' 和 '*' 组成。 
// 输入表达式中的所有整数值在范围 [0, 99] 
// 
//
// Related Topics 递归 记忆化搜索 数学 字符串 动态规划 👍 860 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LC241DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        Solution solution = new LC241DifferentWaysToAddParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            List<Integer> res = new ArrayList<>();
            if (isNum(expression)) {
                res.add(Integer.parseInt(expression));
                return res;
            }

            for (int i = 0; i < expression.length(); i++) {
                Character c = expression.charAt(i);
                if (c.equals('+') || c.equals('-') || c.equals('*') || c.equals('/')) {
                    List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                    List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                    for (Integer l : left) {
                        for (Integer r : right) {
                            if (c.equals('+')) {
                                res.add(l + r);
                            } else if (c.equals('-')) {
                                res.add(l - r);
                            } else if (c.equals('*')) {
                                res.add(l * r);
                            } else if (c.equals('/')) {
                                res.add(l / r);
                            }
                        }
                    }
                }

            }

            return res;
        }

        boolean isNum(String expression) {
            try {
                Integer.parseInt(expression);
            } catch (NumberFormatException e) {
                return false;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}