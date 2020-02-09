package com.masker._145;

import java.util.ArrayList;
import java.util.List;

/**
 * @author masker
 * @date 2019/11/8 6:49 PM
 */

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        foo(list, root);
        return list;
    }

    private void foo(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        foo(list, node.left);
        foo(list, node.right);
        list.add(node.val);
    }
}
