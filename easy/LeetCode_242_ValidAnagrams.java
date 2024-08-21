/**
 * LeetCode - 242 - https://leetcode.com/problems/valid-anagram/description/
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        // Map<Character, Integer> charCount = new HashMap<Character, Integer>();

        // for (int i = 0; i < s.length(); i++) {
        //     int countS = charCount.getOrDefault(s.charAt(i), 0) + 1;
        //     charCount.put(s.charAt(i), countS);
        //     int countT = charCount.getOrDefault(t.charAt(i), 0) - 1;
        //     charCount.put(t.charAt(i), countT);
        // }

        // for (Character key : charCount.keySet()) {
        //     if (charCount.get(key) != 0) return false;
        // }

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int x=s.charAt(i)-'a';
            int y=t.charAt(i)-'a';
            freq[x]++;
            freq[y]--;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) return false;
        }

        return true;
    }
}