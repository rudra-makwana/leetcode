/**
 * LeetCode - 539 - https://leetcode.com/problems/minimum-time-difference/description/
 *
 * Input string format HH:MM
 * Output: minimum difference among the given time points.
 *
 * Convert HH:MM to minutes of integer types.
 *
 * Create a boolean array of 1441 size as the possible minutes in a day is 0 to 1440.
 * The array's indices will be minutes and the values on that index means if the time is given in the input or not.
 *
 * If we see the same time again means our timediff will be zero. We will see our ith element true already on duplicate
 * insert.
 *
 *
 */

class Solution {
    private int convertToMins(String time) {
        String[] splits = time.split(":");
        int hours = Integer.parseInt(splits[0]);
        int mins = Integer.parseInt(splits[1]);
        int totals = (hours*60) + mins;
        return totals;
    }

    public int findMinDifference(List<String> timePoints) {
        boolean[] times = new boolean[1441];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (String time: timePoints) {
            int minutes = convertToMins(time);
            if (times[minutes]) return 0;
            times[minutes] = true;
            min = Math.min(min, minutes);
            max = Math.max(max, minutes);
        }

        // the diff between 23:59 and 00:13 is 14 not 1326. This can happen on the min and max
        int ans = 1440 + (min - max);
        int prev = min;
        for(int i = min+1; i <= max; i++) {
            if (!times[i]) continue;
            if (i == prev) return 0;
            ans = Math.min(ans, i-prev);
            prev = i;
        }
        return ans;
    }
}