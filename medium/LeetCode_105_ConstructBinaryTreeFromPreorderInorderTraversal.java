/**
 * LeetCode - 105 - https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * Preorder: root -> preorder(root.left) -> preorder(root.right)
 * Inorder: Inorder(root.left) -> root -> Inorder(root.right)
 * Postorder: postorder(root.left) -> postorder(root.right) -> root
 *
 * Inorder and preorder is given
 *
 * Let's say we have an element at i. Left of the i element will be on it's left part and right will be on the right.
 *
 * Apply divide and conquer on the left and right;
 * Create a hashmap for the index of inorder elements;
 * preorder Index to create a next node.
 *
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
    HashMap<Integer, Integer> map;
    int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        preorderIndex = 0;
        return buildTree(preorder, 0, n-1);
    }

    private TreeNode buildTree(int[] preorder, int start, int end) {
        if (start > end) return null;
        if (start < 0 || end >= preorder.length) return null;
        TreeNode root = new TreeNode(preorder[preorderIndex++]);
        root.left = buildTree(preorder, start, map.get(root.val)-1);
        root.right = buildTree(preorder, map.get(root.val)+1, end);
        return root;
    }
}