/**
 * LeetCode - 1431 - https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/
 *
 * Python:
 * class Solution:
 *     def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
 *         maxC = 0
 *         for candi in candies:
 *             maxC = max(candi, maxC)
 *
 *         res = []
 *         for candi in candies:
 *             if candi+extraCandies >= maxC:
 *                 res.append(True)
 *             else:
 *                 res.append(False)
 *         return res
 *
 */

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candi: candies) max = candi > max ? candi : max;

        List<Boolean> res = new ArrayList<Boolean>();
        for (int i = 0; i < candies.length; i++) {
            res.add(candies[i] + extraCandies >= max);
        }
        return res;
    }
}