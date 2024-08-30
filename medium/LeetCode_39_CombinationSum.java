/**
 * LeetCode - 39 - https://leetcode.com/problems/combination-sum/
 *
 * Approach 1 - Backtracking because we need to find all possible combinations
 *
 */

class Solution {
    private List<List<Integer>> res;
    private void backtrack(int[] candidates, int start, int target, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>());
        return res;
    }
}