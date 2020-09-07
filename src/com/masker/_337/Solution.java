package com.masker._337;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int rob(TreeNode root) {
        int[] res = backtrace(root);
        return Math.max(res[0], res[1]);
    }

    private int[] backtrace(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = backtrace(root.left);
        int[] right = backtrace(root.right);
        int rob = root.val + left[0] + right[0];
        int not_rob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{not_rob, rob};
    }
}
