/**
 * LeetCode - 47 - https://leetcode.com/problems/permutations-ii/description/
 *
 * Permutations - LeetCode 46
 * Create all possible permutations of given distinct numbers.
 *
 * Permutations II - LeetCode 47 (this):
 * Create all possible permutations of given numbers (includes duplicates). Duplicates permutations must be excluded.
 *
 * Use HashMap to create a count of numbers. Use all the numbers at index i which are not part of [i-1] and has counts
 * > 0
 *
 */

class Solution {
    List<List<Integer>> res;
    boolean[] added;
    Map<Integer, Integer> counts;

    private void permuteUnique(List<Integer> list, int size) {
        if (size == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(Map.Entry<Integer, Integer> count: counts.entrySet()) {
            if (count.getValue() == 0) continue;
            list.add(count.getKey());
            counts.put(count.getKey(), count.getValue()-1);
            permuteUnique(list, size);
            list.remove(list.size()-1);
            counts.put(count.getKey(), count.getValue()+1);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        counts = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int t = counts.getOrDefault(nums[i], 0);
            counts.put(nums[i], t+1);
        }
        permuteUnique(new ArrayList<>(), nums.length);
        return res;
    }
}