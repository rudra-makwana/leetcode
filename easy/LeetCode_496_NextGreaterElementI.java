/**
 * LeetCode - 496 - https://leetcode.com/problems/next-greater-element-i/description
 *
 * Python:
 *
 * class Solution:
 *     def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
 *
 *         nextGE = {}
 *         stack = []
 *         for num in nums2:
 *             while (len(stack) > 0 and stack[-1] < num):
 *                 nextGE[stack.pop()] = num
 *             stack.append(num)
 *
 *         while (stack):
 *             nextGE[stack.pop()] = -1
 *
 *         return [nextGE[i] for i in nums1]
 *
 */

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1Size = nums1.length, n2Size = nums2.length;

        Map<Integer, Integer> nextGE = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n2Size; i++) {
            if (stack.size() == 0 || stack.peekLast() > nums2[i]) {
                stack.addLast(nums2[i]);
            } else {
                while (stack.size() != 0 && stack.peekLast() < nums2[i]) {
                    nextGE.put(stack.removeLast(), nums2[i]);
                }
                stack.addLast(nums2[i]);
            }
        }
        while (stack.size() != 0) nextGE.put(stack.removeLast(), -1);

        int[] res = new int[n1Size];
        for (int i = 0; i < n1Size; i++) {
            res[i] = nextGE.get(nums1[i]);
        }
        return res;
    }
}