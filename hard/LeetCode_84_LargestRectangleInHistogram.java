/**
 * LeetCode - 84 - https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Approach: (Solution based on LeetCode editorial help)
 * Intuition: In histgram, the max area of current index can be found using: heights[i] * maxWidth
 * So our aim is to find the possible width at each index i.
 * Now, width will exapand on both ends until we see the height smaller than the height[i].
 * We can try to expand on both directions to get a maxWidth of i. This will be time consuming. But instead what if we
 *
 * Checkout this YouTube video: [Largest Rectangle in Histogram - Greg Hogg](https://youtube.com/watch?v=ZGMw8Bvpwd4)
 * This video explains how can we use monotonic stack to solve this problem.
 */


class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Pair<Integer, Integer>> monoStack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int ind = i;
            while(!monoStack.isEmpty() && heights[i] < monoStack.peekLast().getKey()) {
                Pair<Integer, Integer> pair = monoStack.removeLast();
                int area = pair.getKey() * (i - pair.getValue());
                ind = pair.getValue();
                maxArea = Math.max(area, maxArea);
            }
            monoStack.addLast(new Pair(heights[i], ind));
        }
        while(!monoStack.isEmpty()) {
            Pair<Integer, Integer> pair = monoStack.removeLast();
            int area = pair.getKey() * (heights.length - pair.getValue());
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}