//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
//
// Related Topics 数学 字符串 模拟 👍 1300 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.Arrays;

public class LC43MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new LC43MultiplyStrings().new Solution();
        System.out.println(solution.multiply("0", "0"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            int[] nums = new int[num1.length() + num2.length()];
            for (int i = num1.length() - 1; i >= 0; i--) {
                int n1 = Character.getNumericValue(num1.charAt(i));
                for (int j = num2.length() - 1; j >= 0; j--) {
                    int n2 = Character.getNumericValue(num2.charAt(j));
                    int sum = n1 * n2 + nums[i + j + 1];
                    nums[i + j + 1] = sum % 10;
                    nums[i + j] += sum / 10;
                }
            }

            int i = 0;
            while (i < nums.length && nums[i] == 0) {
                i++;
            }
            StringBuilder sb = new StringBuilder();
            while (i < nums.length) {
                sb.append(nums[i]);
                i++;
            }

            String res = sb.toString();
            if("".equals(res)) {
                return "0";
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}