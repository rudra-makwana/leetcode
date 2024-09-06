/**
 * LeetCode - 310 - https://leetcode.com/problems/minimum-height-trees/description/
 *
 * Approach:
 * Look at the LeetCode editorial for more understanding: https://leetcode.com/problems/minimum-height-trees/editorial/
 */


class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 2) {
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < n; i++) res.add(i);
            return res;
        }
        Map<Integer, Set<Integer>> neighbors = new HashMap<>();
        for(int i =0; i < n-1; i++) {
            int l = edges[i][0], r = edges[i][1];
            Set<Integer> list = neighbors.getOrDefault(l, new HashSet<>());
            if(list.add(r)) neighbors.put(l, list);
            list = neighbors.getOrDefault(r, new HashSet<>());
            if(list.add(l)) neighbors.put(r, list);
        }
        List<Integer> leaves = new ArrayList<>(); // creating an array of leaf nodes
        for(int i = 0; i < n; i++) {
            if (neighbors.get(i).size() == 1) leaves.add(i);
        }

        int remaining = n;
        while (remaining > 2) {
            remaining -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (Integer leaf: leaves) {
                Integer neighbor = neighbors.get(leaf).iterator().next();
                neighbors.get(neighbor).remove(leaf);
                if (neighbors.get(neighbor).size() == 1) newLeaves.add(neighbor);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}