/**
 * LeetCode - 102 - https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 */

/**
 * My first approach = do BFS and add each elements to queue and process them level by level.
 * Every iteration will have certain number of elements in the queue. That size will be the number of elements on
 * that level in the binary tree.
 *
 * Time Complexity = O(n) as we iterate over elements in queue one by one.
 * Space Complexity = O(n) as we have an queue that is of same size as input.
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int num = queue.size();
            List<Integer> levelList = new ArrayList<>();
            while (!queue.isEmpty() && num > 0) {
                TreeNode t = queue.remove();
                if (t != null) {
                    queue.add(t.left);
                    queue.add(t.right);
                    levelList.add(t.val);
                }
                num--;
            }
            if (levelList.size() != 0) res.add(levelList);
        }
        return res;
    }
}