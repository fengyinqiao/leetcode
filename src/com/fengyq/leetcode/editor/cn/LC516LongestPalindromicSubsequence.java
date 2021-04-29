//给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。 
//
// 
//
// 示例 1: 
//输入: 
//
// "bbbab"
// 
//
// 输出: 
//
// 4
// 
//
// 一个可能的最长回文子序列为 "bbbb"。 
//
// 示例 2: 
//输入: 
//
// "cbbd"
// 
//
// 输出: 
//
// 2
// 
//
// 一个可能的最长回文子序列为 "bb"。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 只包含小写英文字母 
// 
// Related Topics 动态规划 
// 👍 282 👎 0

//aabaa
package com.fengyq.leetcode.editor.cn;

//java:最长回文子序列
public class LC516LongestPalindromicSubsequence{
    public static void main(String[] args) {
         Solution solution = new LC516LongestPalindromicSubsequence().new Solution();
        String s="";
        System.out.println(solution.longestPalindromeSubseq(s));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s==null || s=="") {
            return 0;
        }

        int[][] dp=new int[s.length()][s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i < s.length()&&(i+len-1)<s.length(); i++) {
                int j=i+len-1;

                if(len==1) {
                    dp[i][j]=1;
                }else if(len==2&&s.charAt(i)==s.charAt(j)) {
                    dp[i][j]=2;
                }else if(s.charAt(i)==s.charAt(j)) {
                    dp[i][j]=dp[i+1][j-1]+2;
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}