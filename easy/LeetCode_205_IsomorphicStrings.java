/**
 * LeetCode - 205 - https://leetcode.com/problems/isomorphic-strings/description
 *
 * Python:
 * class Solution:
 *     def isIsomorphic(self, s: str, t: str) -> bool:
 *         replacement = {}
 *         replaced = {}
 *
 *         for i in range(len(s)):
 *             sC = s[i]
 *             tC = t[i]
 *             if (sC in replacement and replacement[sC] != tC): return False
 *             elif (tC in replaced and replaced[tC] != sC): return False
 *             else:
 *                 replacement[sC] = tC
 *                 replaced[tC] = sC
 *
 *         return True
 *
 *
 */

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> replacement = new HashMap<>();
        Map<Character, Character> replaced = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sC = s.charAt(i);
            char tC = t.charAt(i);
            if (replacement.containsKey(sC)) {
                if (replacement.get(sC) != tC) return false;
            } else if (replaced.containsKey(tC)) {
                if (replaced.get(tC) != sC) return false;
            } else {
                replacement.put(sC, tC);
                replaced.put(tC, sC);
            }
        }
        return true;
    }
}