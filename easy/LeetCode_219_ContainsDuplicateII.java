/**
 * LeetCode - 219 - https://leetcode.com/problems/contains-duplicate-ii
 *
 * Python:
 *
 * class Solution:
 *     def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
 *         visited = {}
 *         l = len(nums)
 *         for i in range(l):
 *             if (nums[i] in visited and i-visited[nums[i]] <= k): return True
 *             visited[nums[i]] = i
 *         return False
 *
 */

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> visitedElem = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (visitedElem.containsKey(nums[i]) && (i-visitedElem.get(nums[i])) <= k) return true;
            visitedElem.put(nums[i], i);
        }
        return false;
    }
}