package com.general.lneartao.lib.test;

import com.general.lneartao.lib.Logger;
import com.general.lneartao.lib.algorithm.Tree;
import com.general.lneartao.lib.algorithm.TreeNode;


/**
 * Created by lneartao on 2017/11/15.
 */

public class TestTree {

    public static void main(String[] args) {
//        testHasPathSum();
//        testInorderTraversal();
        testZigzagLevelOrder();
    }

    private static void testInorderTraversal() {
        Tree tree = new Tree();
        TreeNode root = tree.createATree();
        Logger.printl(tree.inorderTraversalIterative(root));
    }

    private static void testHasPathSum() {
        Tree tree = new Tree();
        TreeNode root = tree.createATree();
        tree.hasPathSum(root, 22);
    }

    private static void testZigzagLevelOrder() {
        Tree tree = new Tree();
        TreeNode root = tree.createATree();
        Logger.printl(tree.zigzagLevelOrder(root));
        Logger.printl(tree.zigzagLevelOrderRecursive(root));
    }
}
