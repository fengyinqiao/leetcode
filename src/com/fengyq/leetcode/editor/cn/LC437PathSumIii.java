//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1781 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class LC437PathSumIii {
    public static void main(String[] args) {
        Solution solution = new LC437PathSumIii().new Solution();
        System.out.println(solution.pathSum(new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))), new TreeNode(-3, null, new TreeNode(11))), 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        /*public int pathSum(TreeNode root, int targetSum) {

        }

        int res = 0;
        int sum = 0;

        void traverse(TreeNode root, int targetSum) {
            if (root == null) {
                return;
            }

            sum += root.val;
            if(sum == targetSum) {
                res++;
                sum-= root.val;
            }
            if(sum > targetSum) {

            }
            traverse(root.left, targetSum);
            traverse(root.right, targetSum);
        }*/

        public int pathSum(TreeNode root, int targetSum) {
            traverse(root, targetSum);
            System.out.println(res);
            return res.size();
        }

        List<List<Integer>> res = new LinkedList<>();

        void traverse(TreeNode root, int targetSum) {
            if (root == null) {
                return;
            }

            backtrack(root, new LinkedList<>(), targetSum);

            traverse(root.left, targetSum);
            traverse(root.right, targetSum);
        }

        void backtrack(TreeNode root, LinkedList<Integer> track, int targetSum) {
            if (root == null) {
                return;
            }

            track.add(root.val);
            int sum = track.stream().mapToInt(Integer::intValue).sum();
            if (sum == targetSum) {
                res.add(new LinkedList<>(track));
            }

            backtrack(root.left, track, targetSum);
            backtrack(root.right, track, targetSum);

            track.removeLast();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}