package com.masker._107;

/**
 * @author masker
 * @date 2020/2/28 2:58 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        recursion(root, answer, 0);
        return answer;
    }

    private void recursion(TreeNode root, List<List<Integer>> answer, int level) {
        if (root == null) {
            return;
        }
        if (answer.size() == level) {
            answer.add(0, new ArrayList<>());
        }
        answer.get(answer.size() - level - 1).add(root.val);
        if (root.left != null) {
            recursion(root.left, answer, level+1);
        }
        if (root.right != null) {
            recursion(root.right, answer, level+1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.levelOrderBottom(null);
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }
}
