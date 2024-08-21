/**
 * LeetCode - 409 - https://leetcode.com/problems/longest-palindrome/description/
 */

class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<Character>();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
                sum = sum + 2;
            } else {
                set.add(s.charAt(i));
            }
        }
        return set.isEmpty() ? sum : sum + 1;
    }
}

// TC = O(n) better approach above

//class Solution {
//    public int longestPalindrome(String s) {
//        Map<Character, Integer> count = new HashMap<Character, Integer>();
//        int sum = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int curr = count.getOrDefault(s.charAt(i), 0) + 1;
//            if (curr % 2 == 0) sum = sum + 2;
//            count.put(s.charAt(i), curr);
//        }
//        return sum == s.length() ? sum : sum + 1;
//    }
//}