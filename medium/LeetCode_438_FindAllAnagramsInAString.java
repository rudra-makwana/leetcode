/**
 * LeetCode - 438 - https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * My approach - sliding window technique.
 *
 * 1. Create a anagram array of p
 * 2. Create a window on string s with a size of p and maintain its anagram array
 * 3. Compare the anagram array of p and anagram array of sliding window of s. If same add the start of the window
 * to the list.
 * 4. return the list with start indices
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) return new ArrayList<>();
        int[] pAlpha = new int[26];
        for (int i = 0; i < p.length(); i++) pAlpha[p.charAt(i) - 97] += 1;
        List<Integer> res = new ArrayList<>();
        int n = s.length(), m = p.length();
        int[] temp = new int[26];
        int i = 0, j = 0;
        while(j < m) {
            temp[s.charAt(j)-97] += 1;
            j++;
        }
        while(j < n) {
            if (Arrays.equals(temp, pAlpha)) res.add(i);
            temp[s.charAt(i)-97] -= 1;
            temp[s.charAt(j)-97] += 1;
            i++;
            j++;
        }
        if (Arrays.equals(temp, pAlpha)) res.add(i);
        return res;
    }
}