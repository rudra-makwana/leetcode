/**
 * LeetCode - 46 - https://leetcode.com/problems/permutations/description/
 *
 * Find all permutations of the given array
 *
 * Approach - Backtracking as we have to return all permutations
 *
 */

class Solution {
    private List<List<Integer>> res;

    private void backtrack(int[] nums, Set<Integer> set, List<Integer> list) {
        if (set.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                list.add(nums[i]);
                backtrack(nums, set, list);
                list.remove(list.size() - 1);
                set.remove(nums[i]);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            list.add(nums[i]);
            backtrack(nums, set, list);
            set.remove(nums[i]);
            list.remove(list.size() - 1);
        }
        return res;
    }
}