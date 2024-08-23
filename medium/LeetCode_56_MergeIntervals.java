/**
 * LeetCode - 56 - https://leetcode.com/problems/merge-intervals/description/
 *
 * Approach:
 * 1. Sort the array by starting time of the meetings.
 * 2. create an empty list of int[]
 * 3. add the first meeting from the sorted array in the list
 * 4. iterate over the sorted array from i = 1 till end
 *      a. if start of i meeting is less or equal to previously added meeting's start time then merge by replacing
 *      previous meeting's end time to max between the existing end and i meeting end time.
 *      b. else add the i meeting to the list
 *      c. i++
 * 5. return the list converting it to 2d array
 */

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int i = 1;
        List<int[]> res = new ArrayList<int[]>();
        res.add(intervals[0]);
        while (i < intervals.length) {
            int[] temp = res.get(res.size() - 1);
            if (temp[1] >= intervals[i][0]) {
                temp[1] = Math.max(intervals[i][1], temp[1]);
            } else {
                res.add(intervals[i]);
            }
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}