/**
 * LeetCode - 13 - https://leetcode.com/problems/roman-to-integer/
 */

class Solution {
    private Map<Character, Integer> r = new HashMap<>();
    public int romanToInt(String s) {
        r.put('I', 1);
        r.put('V', 5);
        r.put('X', 10);
        r.put('L', 50);
        r.put('C', 100);
        r.put('D', 500);
        r.put('M', 1000);

        int prev = 0, number = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int t = r.get(s.charAt(i));
            if (t < prev)  number = number - t;
            else number = number + t;
            prev = t;
        }
        return number;
    }
}