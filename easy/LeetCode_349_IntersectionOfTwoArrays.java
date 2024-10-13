/**
 * LeetCode - 349 - https://leetcode.com/problems/intersection-of-two-arrays/description
 */

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            nums1Map.put(nums1[i], nums1Map.getOrDefault(nums1[i], 0) + 1);
        }

        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (nums1Map.containsKey(nums2[i])) {
                res.add(nums2[i]);
                int freq = nums1Map.get(nums2[i]) - 1;
                if (freq == 0) nums1Map.remove(nums2[i]);
                else nums1Map.put(nums2[i], freq);
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}