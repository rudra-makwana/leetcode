/**
 *
 * LeetCode - 314 - https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/
 *
 * First approach was DFS but the output requires to be sorted by columns and if same columns then sorted by levels.
 * DFS requires to use a data structure like a priority queue that will sort the list of elements on the same column.
 * Which is an unnecessary work. We can avoid that by using BFS approach where a node will appear before the next
 * level's nodes. So that order is maintained.
 *
 *
 * My solution was using a BFS with treemap to sort the map by vertical column ids. But we can ignore that part as we
 * can keep track the left most column ID and right most column ID in the available tree. That means we do not require
 * to sort the Map, we can simply iterate from the leftMostColumnId to rightMostColumnId and we will get the correct
 * order. The solution is implemented below.
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Map<Integer, List<Integer>> verticals = new HashMap<>();

        Deque<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.addLast(new Pair(root, 0));

        int min = 0, max = 0;
        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.removeFirst();
            int val = p.getValue();
            TreeNode curr = p.getKey();

            List<Integer> temp = verticals.getOrDefault(val, new ArrayList<>());
            temp.add(curr.val);
            verticals.put(val, temp);

            if (curr.left != null) queue.addLast(new Pair(curr.left, val - 1));
            if (curr.right != null) queue.addLast(new Pair(curr.right, val + 1));

            min = Math.min(min, val);
            max = Math.max(max, val);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            res.add(verticals.get(i));
        }
        return res;
    }
}