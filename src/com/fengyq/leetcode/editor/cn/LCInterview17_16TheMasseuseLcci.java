//一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩
//师找到最优的预约集合（总预约时间最长），返回总的分钟数。 
//
// 注意：本题相对原题稍作改动 
//
// 
//
// 示例 1： 
//
// 输入： [1,2,3,1]
//输出： 4
//解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
// 
//
// 示例 2： 
//
// 输入： [2,7,9,3,1]
//输出： 12
//解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
// 
//
// 示例 3： 
//
// 输入： [2,1,4,5,3,1,1,3]
//输出： 12
//解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
// 
// Related Topics 动态规划 
// 👍 119 👎 0


package com.fengyq.leetcode.editor.cn;

//java:按摩师
public class LCInterview17_16TheMasseuseLcci{
    public static void main(String[] args) {
         Solution solution = new LCInterview17_16TheMasseuseLcci().new Solution();
        int[] nums={1,2,3,1};
        System.out.println(solution.massage(nums));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int massage(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }

        int chosen=0,unchosen=0,preUnchosen;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            preUnchosen=unchosen;
            unchosen=Math.max(chosen, unchosen);
            chosen=preUnchosen+num;
        }

        return Math.max(chosen, unchosen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}