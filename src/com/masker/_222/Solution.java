package com.masker._222;

/**
 * @author masker
 * @date 2020/9/2 8:36 PM
 */

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode l = root.left;
        int hl = 0;
        while (l != null) {
            hl++;
            l = l.left;
        }
        TreeNode r = root.right;
        int hr = 0;
        while (r != null) {
            hr++;
            r = r.right;
        }
        if (hl == hr) {
            return (int)Math.pow(2, (hl+1)) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
