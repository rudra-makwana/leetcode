/**
 * LeetCode - 57 - https://leetcode.com/problems/insert-interval/
 */

/**
 * Approach 1 - Linear Search
 * TC O(n) and SC = O(2*n + 1) = O(n)
 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] res = new int[1][2];
            res[0] = newInterval;
            return res;
        }
        if (intervals.length == 0) {
            int[][] res = new int[1][2];
            res[0] = newInterval;
            return res;
        }
        List<int[]> res = new ArrayList<>();
        int start = newInterval[0], end = newInterval[1];
        boolean isAdded = false;
        for (int i = 0; i < intervals.length; i++) {
            if (start > intervals[i][1] || isAdded) {
                res.add(intervals[i]);
            } else if (end < intervals[i][0]) {
                int[] temp = {start, end};
                res.add(temp);
                res.add(intervals[i]);
                isAdded = true;
            } else if (start >= intervals[i][0] && end <= intervals[i][1]) {
                res.add(intervals[i]);
                isAdded = true;
            } else if (start <= intervals[i][1] && start >= intervals[i][0]) {
                start = intervals[i][0];
            } else if (end <= intervals[i][1] && end >= intervals[i][0]) {
                end = intervals[i][1];
            }
        }
        if (!isAdded) {
            int[] t = {start, end};
            res.add(t);
        }
        return res.toArray(new int[res.size()][]);
    }
}