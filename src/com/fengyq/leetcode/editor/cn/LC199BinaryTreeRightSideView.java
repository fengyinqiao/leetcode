//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 递归 队列 
// 👍 452 👎 0


package com.fengyq.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//java:二叉树的右视图
public class LC199BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new LC199BinaryTreeRightSideView().new Solution();
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5, null, null)),
                new TreeNode(3, null, new TreeNode(4, null, null)));
        solution.rightSideView(root);
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
        class TreeNodeWrap {
            TreeNode node;
            int depth;

            public TreeNodeWrap(TreeNode node, int depth) {
                this.node = node;
                this.depth = depth;
            }
        }

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Deque<TreeNodeWrap> stack = new LinkedList<>();
            Map<Integer, TreeNodeWrap> map = new HashMap<>();
            int maxDepth = Integer.MIN_VALUE;

            stack.push(new TreeNodeWrap(root, 0));
            while (!stack.isEmpty()) {
                TreeNodeWrap wrap = stack.pop();
                if (!map.containsKey(wrap.depth)) {
                    map.put(wrap.depth, wrap);
                }
                maxDepth = Math.max(wrap.depth, maxDepth);
                //System.out.printf("current node: %d, left: %d, right: %d, maxDepth: %d%n", wrap.node.val, wrap.node.left != null ? wrap.node.left.val : -1, wrap.node.right != null ? wrap.node.right.val : -1, maxDepth);
                //System.out.printf("map: %s%n",map);
                if (wrap.node.left != null) {
                    stack.push(new TreeNodeWrap(wrap.node.left, wrap.depth + 1));
                }
                if (wrap.node.right != null) {
                    stack.push(new TreeNodeWrap(wrap.node.right, wrap.depth + 1));
                }
            }

            for (int i = 0; i <= maxDepth; i++) {
                res.add(map.get(i).node.val);
            }
            //System.out.println(res);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}