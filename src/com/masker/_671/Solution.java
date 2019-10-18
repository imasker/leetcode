package com.masker._671;

import java.util.ArrayList;
import java.util.List;

/**
 * @author masker
 * @date 2019/10/18 6:53 PM
 */
public class Solution {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) return -1;
        int minValue = root.val;
        int secondMinimumValue = -1;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode node = list.remove(0);
            if (node.val > minValue) {
                if (secondMinimumValue == -1 || node.val < secondMinimumValue) {
                    secondMinimumValue = node.val;
                }
            } else {
                if (node.left != null) {
                    list.add(node.left);
                    list.add(node.right);
                }
            }
        }
        return secondMinimumValue;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
