/**
 * LeetCode - 110 - https://leetcode.com/problems/balanced-binary-tree/description/
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    private TreeNode getHeightsRecursion(TreeNode actualNode) {
        if (actualNode == null) {
            return null;
        }
        TreeNode tree = new TreeNode();
        tree.left = getHeightsRecursion(actualNode.left);
        tree.right = getHeightsRecursion(actualNode.right);
        if (tree.left != null && tree.right != null) {
            tree.val = Math.max(tree.left.val, tree.right.val) + 1;
        } else if (tree.left != null) {
            tree.val = tree.left.val + 1;
        } else if (tree.right != null) {
            tree.val = tree.right.val + 1;
        } else {
            tree.val = 0;
        }
        return tree;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        TreeNode heightTree = getHeightsRecursion(root);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(heightTree);
        while (!q.isEmpty()) {
            TreeNode head = q.remove();
            if (head.left != null && head.right != null) {
                if ((head.left.val - head.right.val) > 1 || (head.right.val - head.left.val) > 1) return false;
                q.add(head.left);
                q.add(head.right);
            } else if (head.left != null) {
                if (head.left.val >= 1) return false;
                q.add(head.left);
            } else if (head.right != null){
                if (head.right.val >= 1) return false;
                q.add(head.right);
            } else {
                return true;
            }
        }
        return true;
    }
}