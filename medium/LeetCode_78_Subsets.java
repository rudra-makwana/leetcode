/**
 * LeetCode - 78 - https://leetcode.com/problems/subsets/
 */


class Solution {
    private List<List<Integer>> res;
    private void backtrack(int[] nums, int curr, List<Integer> list) {
        if (curr == nums.length) {
            res.add(new ArrayList(list));
            return;
        }
        List<List<Integer>>temp = res;
        res.add(new ArrayList(list));
        for (int i = curr+1; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, i, list);
            list.remove(list.size()-1);
        }
        return;
    }
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        res.add(new ArrayList());
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            backtrack(nums, i, temp);
        }
        return res;
    }
}