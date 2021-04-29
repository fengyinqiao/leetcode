//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2641 👎 0


package com.fengyq.leetcode.editor.cn;
//java:最长回文子串
public class LC5LongestPalindromicSubstring{
    public static void main(String[] args) {
         Solution solution = new LC5LongestPalindromicSubstring().new Solution();
        String s="babad";
        System.out.println(solution.longestPalindrome(s));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        int maxLen=0,begIdx=0;
        for (int len = 1; len<= s.length(); len++) {
            for (int i = 0; i < s.length()&&(i+len-1)<s.length(); i++) {
                int j=i+(len-1);

                if(len==1) {
                    dp[i][j]=true;
                }else if(len==2) {
                    dp[i][j]=(s.charAt(i)==s.charAt(j));
                }else {
                    dp[i][j]=dp[i+1][j-1] && (s.charAt(i)==s.charAt(j));
                }

                if(dp[i][j] && len>maxLen) {
                    maxLen=len;
                    begIdx=i;
                }
            }
        }
        return s.substring(begIdx, begIdx+maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}