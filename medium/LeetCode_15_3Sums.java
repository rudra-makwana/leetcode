/**
 * LeetCode - 15 - https://leetcode.com/problems/3sum/description/
 */

/**
 * Solve these two problems first:
 * 1. LeetCode - 1 - Two Sums - https://leetcode.com/problems/two-sum/description/
 * 2. LeetCode - 167 - Two Sums II - https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * In the following approach:
 * 1. Sort the array.
 * 2. We first go through each element till length - 3;
 * 3. If selected elemenent > 0 that means impossible to get sum 0 in sorted array for all the next elements.
 * 4. If we have same element as previous, we will get duplicate so ignore the element.
 * 5. Now apply Two Sum II logic until we get a pair of left and right that gives left + right = -selected
 * 6. There may be multiple possible solutions of sum 0 with selected element so check them as well. That can only
 * happen if the left is not same as already added left in the result.
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum > 0) right--;
                else if (sum < 0) left++;
                else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left++; // This increment points at the new element that is not as nums[left]
                }
            }
        }
        return res;
    }
}

/**
 *
 * My initial appraoach:
 * ---------------------
 * My idea was to select an element in the given array and use its negative as target value for the Two Sum problem's
 * algorithm. So our input to the two sum problem would be -1 * nums[i] and need to find the pair in the remaining
 * array so it will start from i + 1;
 *
 * We will use HashSet to store our triplets to avoid the duplicates.
 *
 * Also similar value can appear in the array later points so we can keep the track if the same target value appears we
 * don't do TwoSum finding again as it's already done.
 *
 * class Solution {
 *
 *     public List<List<Integer>> threeSum(int[] nums) {
 *         Set<List<Integer>> res = new HashSet<>();
 *         Set<Integer> dups =  new HashSet<>();
 *
 *         for (int i = 0; i < nums.length - 2; i++) {
 *             if (dups.contains(nums[i])) continue;
 *             Map<Integer, Integer> index = new HashMap<>();
 *             for (int j = i + 1; j < nums.length; j++) {
 *                 int target = -nums[i] - nums[j];
 *                 if (index.containsKey(nums[j])) {
 *                     List<Integer> temp = Arrays.asList(nums[i], target, nums[j]);
 *                     Collections.sort(temp);
 *                     res.add(temp);
 *                 } else {
 *                     index.put(target, j);
 *                 }
 *             }
 *             dups.add(nums[i]);
 *         }
 *
 *         return new ArrayList(res);
 *     }
 * }
 *
 */