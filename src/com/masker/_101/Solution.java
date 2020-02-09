package com.masker._101;

/**
 * @author masker
 * @date 2019/10/23 11:31 AM
 */

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right != null) {
            if ((left.left == null && right.right == null) ||
                    (left.left != null && right.right != null && left.left.val == right.right.val)) {
                if (!isSymmetric(left.left, right.right)) {
                    return false;
                }
            } else {
                return false;
            }
            if ((left.right == null && right.left == null) ||
                    (left.right != null && right.left != null && left.right.val == right.left.val)) {
                if (!isSymmetric(left.right, right.left)) {
                    return false;
                }
            } else {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
