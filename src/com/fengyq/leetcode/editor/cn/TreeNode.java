package com.fengyq.leetcode.editor.cn;

/**
 * @Author fengyinqiao
 * @Date 2021/4/27 15:53
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
