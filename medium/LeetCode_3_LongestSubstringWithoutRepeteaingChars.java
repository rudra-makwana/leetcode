/**
 * LeetCode - 3 - https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * My approach =>
 * 1. Create a hashmap that stroes the characters' indices in a string; This will help us to reset our sliding windows
 * starting point.
 * 2. Declare two pointers for the sliding window. Initially they will be set to 0;
 * 3. Iterate over the string:
 *  a. Check if the element already exist in hashmap and the index is greater than current substring's starter point.
 *  If it does, that means the repetition has occurred.
 *      i. check if the find the maximum between current max and current substring size (end - start)
 *      ii. change the maximum if needed.
 *      iii. change start to repeated character's next element
 *  b. If the character is not being repeated set i as end of the substring.
 *  c. Insert the character and its index to the HashMap.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        Map<Character, Integer> index = new HashMap<>();
        int start = 0, end = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (index.containsKey(c) && index.get(c) >= start) {
                max = Math.max(max, end - start);
                start = index.get(c) + 1;
            }
            end = i;
            index.put(c, i);
        }
        return Math.max(end - start, max) + 1;
    }
}