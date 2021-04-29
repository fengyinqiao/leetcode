//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 
// 👍 689 👎 0


package com.fengyq.leetcode.editor.cn;

//java:二叉树的直径
public class LC543DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new LC543DiameterOfBinaryTree().new Solution();
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)),
                new TreeNode(3, null, null));
        System.out.println(solution.diameterOfBinaryTree(root));
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
        int res;

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            depth(root);
            return res - 1;
        }

        public int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftDepth = depth(root.left);
            int rightDepth = depth(root.right);
            res = Math.max(leftDepth + rightDepth + 1, res);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}