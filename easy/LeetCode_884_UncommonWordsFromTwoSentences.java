/**
 *
 * LeetCode - 884 - https://leetcode.com/problems/uncommon-words-from-two-sentences/
 *
 * Idea: we need to find the word in both strings that appears only one times. Create a HashMap to keep count of each
 * words in both strings. After creating the counts hashmap, find each word with only one occurrence and add it to the
 * list and return this list as an array.
 */


class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] s1Words = s1.split(" ");
        String[] s2Words = s2.split(" ");
        int s1L = s1Words.length, s2L = s2Words.length;
        Map<String, Integer> counts = new HashMap<>();

        for (int i = 0; i < Math.max(s1L, s2L); i++) {
            if (i < s1L) {
                counts.put(s1Words[i], counts.getOrDefault(s1Words[i], 0)+1);
            }
            if (i < s2L) {
                counts.put(s2Words[i], counts.getOrDefault(s2Words[i], 0)+1);
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> pair: counts.entrySet()) {
            if (pair.getValue() == 1) res.add(pair.getKey());
        }
        return res.toArray(new String[res.size()]);
    }
}