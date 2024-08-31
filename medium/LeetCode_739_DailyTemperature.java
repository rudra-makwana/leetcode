/**
 * LeetCode - 739 - https://leetcode.com/problems/daily-temperatures/description/
 */

/**
 * Approach: array with optimized space.
 * Intuition:
 * We can start from the right to left. If we found a hottest temp on current day that means res[i] = 0 but change
 * hottest to current temp;
 *
 * Otherwise we continue checking the hotter day than the current hotter day. We can move one day at a time towards
 * right.
 * Think our current day has 30 temp and we are comparing it to 24 temp which took 3 days to get hotter. That means
 * for our temp 30 we cannot find a greater before 24's day + 3. That means we can jump directly by 3 position for
 * comparision. This will be way faster than the approach we used in stack.
 *
 * Stack approach moves from left to right and to find diff it goes curr to left. In worst case, it might require 2
 * times of iterations O(2*n) which is better than brute force but we can make it faster by using optimized array
 * method.
 *
 * Look at the code for better understanding.
 */

class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int len = temp.length;
        int[] res = new int[len];
        int hottest = 0;

        for(int i = len-1; i >= 0; i--) {
            int currentTemp = temp[i];
            if (currentTemp >= hottest) {
                hottest = currentTemp;
                continue;
            }
            int days = 1;
            while(temp[days + i] <= currentTemp) {
                days += res[days + i];
            }
            if (days < len) res[i] = days;
        }

        return res;
    }
}

/**
 * Better approach than brute force.
 * We maintain a stack that stores day of the hot temperature to be processed. The top of the element must be smaller
 * than the previously added element. If we find the day on top of the stak has a lower temperature than current that
 * implies we found a number of days for the day on top of the stack. We do it till our current is smaller than the top
 * or the stack itself is empty. Look at the following codes for more understanding.
 *
 * Stack based approach. We use a monolithic stack that stores the small temperatures on top
 *          Deque<Integer> warmDays = new ArrayDeque<>();
 *          for (int i = 0; i < len; i++) {
 *              int currTemp = temp[i];
 *              while(!warmDays.isEmpty() && currTemp > temp[warmDays.peek()]) {
 *                  int prev = warmDays.pop();
 *                  res[prev] = i - prev;
 *              }
 *              warmDays.push(i);
 *          }
 *
 */

/**
 * My first idea was to use a brute force: O(n^2)
 *   for (int i = 0; i < len-1; i++) {
 *       for (int j=i+1; j < len; j++) {
 *           if (temp[j] > temp[i]) {
 *               res[i] = j - i;
 *               break;
 *           }
 *       }
 *   }
 */