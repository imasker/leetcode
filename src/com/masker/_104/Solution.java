package com.masker._104;

/**
 * @author masker
 * @date 2020/2/29 3:28 PM
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    public int maxDepth(TreeNode root) {
        return recursion(root, 0);
    }

    private int recursion(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        return Math.max(recursion(root.left, depth+1), recursion(root.right, depth+1));
    }
}
