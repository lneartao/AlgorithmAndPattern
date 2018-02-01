package com.general.lneartao.lib.test;

import com.general.lneartao.lib.algorithm.Tree;


/**
 * Created by lneartao on 2017/11/15.
 */

public class TestTree {

    public static void main(String[] args) {
        Tree tree = new Tree();
        Tree.TreeNode root = tree.createATree();
        tree.hasPathSum(root, 22);
    }
}
