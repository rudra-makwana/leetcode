/**
 * LeetCode - 252 - https://leetcode.com/problems/meeting-rooms/description/
 */

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) return false;
        }
        return true;
    }
}