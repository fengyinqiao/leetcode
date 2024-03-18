package com.fengyq.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;


public class PathSum {
    private List<List<Integer>> result = new LinkedList<>();
//    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum);
        return result;
    }

    private void traverse(TreeNode root, int targetSum) {
        if (root == null) return;

        LinkedList<Integer> track = new LinkedList<>();
        track.add(root.val);
        backtrack(root, track, targetSum, root.val);
        track.removeLast();// 回溯

        // 递归遍历子节点
        traverse(root.left, targetSum);
        traverse(root.right, targetSum);
    }

    private void backtrack(TreeNode node, LinkedList<Integer> track, int targetSum, int currentSum) {
        // 检查当前路径的和是否等于目标和
        if (currentSum == targetSum) {
            result.add(new LinkedList<>(track));
        }
        // 遍历子节点
        if (node.left != null) {
            track.add(node.left.val);
            backtrack(node.left, track, targetSum, currentSum + node.left.val);
            track.removeLast(); // 回溯
        }
        if (node.right != null) {
            track.add(node.right.val);
            backtrack(node.right, track, targetSum, currentSum + node.right.val);
            track.removeLast(); // 回溯
        }
    }

    public static void main(String[] args) {
        // 构造测试用例的二叉树
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        int targetSum = 8;

        // 使用算法求解
        PathSum pathSum = new PathSum();
        List<List<Integer>> result = pathSum.pathSum(root, targetSum);

        // 输出结果
        System.out.println("输出结果：" + result);

    }
}

