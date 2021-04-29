//给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。 
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯算法 
// 👍 550 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:复原 IP 地址
public class LC93RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new LC93RestoreIpAddresses().new Solution();
        System.out.println(solution.restoreIpAddresses("101023"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();
        int[] segment = new int[4];

        //输入：s = "25525511135"
        //输出：["255.255.11.135","255.255.111.35"]
        public List<String> restoreIpAddresses(String s) {
            if (s == null || s.length() < 4) {
                return res;
            }

            dfs(s, 0, 0);
            return res;
        }

        void dfs(String s, int segId, int idx) {
            //System.out.printf("current dfs: segId=%d, idx=%d%n", segId, idx);
            //System.out.printf("segment=%s, res=%s%n", Arrays.toString(segment), res);
            if (segId == 4) {
                if (idx == s.length()) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < segment.length; i++) {
                        sb.append(segment[i]);
                        if (i < 3) {
                            sb.append(".");
                        }
                    }
                    res.add(sb.toString());
                }
                return;
            }

            if (idx == s.length()) {
                return;
            }

            if (s.charAt(idx) == '0') {
                segment[segId] = 0;
                dfs(s, segId + 1, idx + 1);
                return;
            }

            int sum = 0;
            for (int i = idx; i < s.length(); i++) {
                sum = sum * 10 + Character.getNumericValue(s.charAt(i));
                //System.out.printf("sum: %d%n", sum);
                if (sum >= 0 && sum <= 255) {
                    //System.out.printf("next dfs: segId=%d, idx=%d%n", segId + 1, i + 1);
                    segment[segId] = sum;
                    dfs(s, segId + 1, i + 1);
                } else {
                    break;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}