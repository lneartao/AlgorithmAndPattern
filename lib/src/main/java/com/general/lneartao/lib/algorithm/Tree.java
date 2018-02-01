package com.general.lneartao.lib.algorithm;

/**
 * Created by lneartao on 2017/11/13.
 */

public class Tree {
    /*        这样一棵二叉树
                       5
                      / \
                     4   8
                    /   / \
                   11  13  4
                  /  \      \
                 7    2      1
    */
    public TreeNode createATree() {
        TreeNode node11 = new TreeNode(11);
        node11.left = new TreeNode(7);
        node11.right = new TreeNode(2);
        TreeNode node44 = new TreeNode(4);
        node44.right = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        node4.left = node11;
        TreeNode node8 = new TreeNode(8);
        node8.left = new TreeNode(13);
        node8.right = node44;
        TreeNode root = new TreeNode(5);
        root.left = node4;
        root.right = node8;
        return root;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return root != null && solveRecursively(root, sum);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean solveRecursively(TreeNode root, int sum) {
        int val = root.val;
        if (root.left == null && root.right == null) {
            return val == sum;
        }
        return (root.left != null && solveRecursively(root.left, sum - val)) ||
                (root.right != null && solveRecursively(root.right, sum - val));
    }
}
