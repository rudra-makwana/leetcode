/**
 * LeetCode - 230 - https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */

/**
 *
 * My first approach - Recursive method
 * Create a inorder traversal list on the BST tree till the size of the list becomes k. Stop the recursion and return
 * the k - 1 element that will be the kth smallest element in the Binary Search Tree.
 *
 * More better approach - use iterative inorder approach.
 *
 * 1. Add the current node's all left node include the node itself in a stack.
 * 2. Pop a node from the stack and check if the k == 0 or not. if k is 0 then return the popped node's value
 * 3. decrement the k's value
 * 4. now add all the right node of the popped nodes to the stack and apply the same process.
 *
 * This logic does the same in-order traversal using stack. Checkout the code for better understanding.
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
    List<Integer> inorder;

    private void dfs(TreeNode node, int k) {
        if (node == null || inorder.size() == k) return;
        dfs(node.left, k);
        inorder.add(node.val);
        dfs(node.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        String approach = "iterative";
        if (approach.equals("recursice")) {
            inorder = new ArrayList<>();
            dfs(root, k);
            return inorder.get(k-1);
        }

        // better method
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}