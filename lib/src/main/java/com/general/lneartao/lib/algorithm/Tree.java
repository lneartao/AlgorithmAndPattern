package com.general.lneartao.lib.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

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

    public boolean solveRecursively(TreeNode root, int sum) {
        int val = root.val;
        if (root.left == null && root.right == null) {
            return val == sum;
        }
        return (root.left != null && solveRecursively(root.left, sum - val)) ||
                (root.right != null && solveRecursively(root.right, sum - val));
    }

    /**
     * 二叉树的中序遍历，迭代版本,左中右
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while (!s.empty() || p != null) {
            if (p != null) {
                s.push(p);
                p = p.left;
            } else {
                p = s.pop();
                result.add(p.val);
                p = p.right;
            }
        }
        return result;
    }

    /**
     * 二叉树中序遍历，递归版本
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverseInorder(result, root);
        return result;
    }

    private void traverseInorder(List<Integer> result, TreeNode root) {
        if (root != null) {
            traverseInorder(result, root.left);
            result.add(root.val);
            traverseInorder(result, root.right);
        }
    }

    /**
     * 二叉树前序遍历，迭代版本，中左右
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if (root != null) {
            s.push(root);
        }
        while (!s.empty()) {
            final TreeNode p = s.pop();
            result.add(p.val);

            if (p.right != null) {
                s.push(p.right);
            }
            if (p.left != null) {
                s.push(p.left);
            }
        }
        return result;
    }

    /**
     * 二叉树前序遍历，递归版本
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversePreorder(result, root);
        return result;
    }

    private void traversePreorder(List<Integer> result, TreeNode root) {
        if (root != null) {
            result.add(root.val);
            traversePreorder(result, root.left);
            traversePreorder(result, root.right);
        }
    }

    /**
     * 二叉树后序遍历，迭代版本，左右中
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        // p正在访问的结点，q刚刚访问的结点
        TreeNode p = root;
        TreeNode q = null;
        do {
            while (p != null) { //往左下走
                s.push(p);
                p = p.left;
            }
            q = null;
            while (!s.empty()) {
                p = s.pop();
                // 右孩子不存在或已被访问，访问之
                if (p.right == q) {
                    result.add(p.val);
                    q = p; // 保存刚访问过的结点
                } else {
                    // 当前结点不能访问，需第二次进栈
                    s.push(p);
                    // 先处理右子树
                    p = p.right;
                    break;
                }
            }
        } while (!s.empty());
        return result;
    }

    /**
     * 二叉树后序版本，递归版本
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversePostorder(result, root);
        return result;
    }

    private void traversePostorder(List<Integer> result, TreeNode root) {
        if (root != null) {
            traversePostorder(result, root.left);
            traversePostorder(result, root.right);
            result.add(root.val);
        }
    }

    /**
     * 其实核心还是广度遍历，只不过在得到每一层的结果后需要看情况翻转顺序
     * 去掉isNormalOrder的处理逻辑就是广度遍历的算法了
     * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        boolean isNormalOrder = true;
        while (cur.size() > 0) {
            ArrayList<TreeNode> next = new ArrayList<>();
            ArrayList<Integer> levelVal = new ArrayList<>();
            for (TreeNode node : cur) {
                levelVal.add(node.val);
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            if (!isNormalOrder) {
                Collections.reverse(levelVal);
            }
            result.add(levelVal);
            isNormalOrder = !isNormalOrder;
            cur = next;
        }
        return result;
    }

    /**
     * 上述算法的递归版本
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrderRecursive(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        zigzagTraverse(root, 1, result, true);
        return result;
    }

    private void zigzagTraverse(TreeNode root, int level, List<List<Integer>> result, boolean isNormalOrder) {
        if (root == null) {
            return;
        }
        if (level > result.size()) {
            result.add(new ArrayList<>());
        }
        if (isNormalOrder) {
            result.get(level - 1).add(root.val);
        } else {
            result.get(level - 1).add(0, root.val);
        }
        zigzagTraverse(root.left, level + 1, result, !isNormalOrder);
        zigzagTraverse(root.right, level + 1, result, !isNormalOrder);
    }

    /**
     * 根据先序和中序数组构建二叉树
     * 利用先序确定根，中序区分左右子树
     * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int begin1, int end1, int[] inorder, int begin2, int end2) {
        if (begin1 == end1 || begin2 == end2) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[begin1]);

        int inRootPos = find(inorder, begin2, end2, preorder[begin1]);
        int leftSize = inRootPos - begin2;

        root.left = buildTree(preorder, begin1 + 1, begin1 + leftSize + 1, inorder, begin2, begin2 + leftSize);
        root.right = buildTree(preorder, begin1 + leftSize + 1, end1, inorder, inRootPos + 1, end2);
        return root;
    }

    /**
     * 根据中序和后序构建二叉树
     * 利用后序确定根，中序区分左右子树
     * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        return buildTree2(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode buildTree2(int[] inorder, int begin1, int end1, int[] postorder, int begin2, int end2) {
        if (begin1 == end1 || begin2 == end2) {
            return null;
        }
        int val = postorder[end2 - 1];
        TreeNode root = new TreeNode(val);

        int inRootPos = find(inorder, begin1, end1, val);
        int leftSize = inRootPos - begin1;
        int postLeftLast = begin2 + leftSize;
        root.left = buildTree2(inorder, begin1, inRootPos, postorder, begin2, postLeftLast);
        root.right = buildTree2(inorder, inRootPos, end1, postorder, postLeftLast, end2 - 1);
        return root;
    }

    private int find(int[] arr, int begin, int end, int val) {
        for (int i = begin; i < end; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
