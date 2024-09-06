/**
 * LeetCode - 76 - https://leetcode.com/problems/minimum-window-substring/description/
 *
 * The problem can be rephrased to that we need to find a smallest possible substring of s that contains all characters
 * from string t including the duplicates.
 *
 * Target is to find a substring that contains ALL CHARACTERS FROM STRING t. This line means that we need to create a
 * dictionary to keep track of the character counts of string t.
 *
 * Increment right pointer until our window count map is same as t's character count.
 * If window counts map is same as t's count map, we start incrementing left pointer till both maps are same
 * to contract the window.
 *
 * Check if this right - left + 1 is smaller than previously found substring window size and update accordingly.
 *
 * Continue with incrementing right and apply the same process if our both maps are same again.
 *
 */

class Solution {
    public String minWindow(String s, String t) {
        int sSize = s.length(), tSize = t.length();
        if (tSize > sSize || tSize == 0) return ""; // t size > s size or t is an empty list meaning substring = ""

        Map<Character, Integer> countT = new HashMap<>(); // Character counts of string t
        for (int i = 0; i < tSize; i++) countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0)+1); // add counts

        Map<Character, Integer> window = new HashMap<>(); // dictionary to track character count of a curr window
        int have = 0, need = countT.size(); // have means how many conditions have matched so far and need means how many needs to be matched
        int[] ans = {-1, 0, 0}; // ans to track previously found smalles substring
        int l = 0, r = 0; // left and right pointer
        while (r < sSize) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1); // increment a counter for curr character on right pointer

            if (countT.containsKey(c) && window.get(c).intValue() == countT.get(c).intValue()) have++; // if the curr characters counter is same as t's counter of current char means one of the conditions has matched so increment have counter

            while (l <= r && have == need) { // check till our have and need are same to find a valid small substring in current window. Use left pointer to contract the window size.
                if (ans[0] == -1 || r-l+1 < ans[0]) { // to update the already stored small substring
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                char temp = s.charAt(l);
                window.put(temp, window.get(temp)-1); // decerement the counter of window as we are contracting the window size
                if (countT.containsKey(temp) && window.get(temp).intValue() < countT.get(temp).intValue()) have--; // if one of the need condtion has failed meaning reduce have by one and break out of the loop. Continue incrementing right again till we get have == need
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1); // if we did not found any possible substring that means ans[0] will be always -1
    }
}