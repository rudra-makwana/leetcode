/**
 *
 * LeetCode - 215 - https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * First idea: Use a min heap of size k and if ith element is greater than the top of heap then remove the top and add
 * a new element. In the end we will have top element as an answer.
 *
 * This will take an logarithamic time. So what can we do better? We can apply simple counting sort logic.
 *
 */


class Solution {
    public int findKthLargest(int[] nums, int k) {
        // min heap - n*lon(k) time
        // PriorityQueue<Integer> queue = new PriorityQueue<>();
        // for (int i = 0; i < k; i++) {
        //     queue.offer(nums[i]);
        // }
        // for(int i = k; i < nums.length; i++) {
        //     if (nums[i] <= queue.peek()) continue;
        //     queue.remove();
        //     queue.offer(nums[i]);
        // }
        // return queue.peek();

        // Counting sort method - linear time O(2*nums.length + MIN(counts.length, k));
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }

        int[] counts = new int[max+1-min];
        for (int i = 0; i < nums.length; i++) counts[nums[i]-min]++;

        for (int i = counts.length-1; i >= 0;i--) {
            k -= counts[i];
            if (k <= 0) return i + min;
        }
        return -1;
    }
}