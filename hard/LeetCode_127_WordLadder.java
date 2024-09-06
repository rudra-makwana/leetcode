/**
 * LeetCode - 127 - https://leetcode.com/problems/word-ladder/
 *
 * Idea (Editorial Solution) using single queue
 *
 */


class Solution {
    private Map<String, Set<String>> combinations;

    public Solution() {
        combinations = new HashMap<>();
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        int len = beginWord.length();
        wordSet.forEach(word -> {
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i+1, len);
                Set<String> comb = combinations.getOrDefault(newWord, new HashSet<String>());
                comb.add(word);
                combinations.put(newWord, comb);
            }
        });

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));

        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while(!queue.isEmpty()) {
            Pair<String, Integer> p = queue.remove();
            String word = p.getKey();
            int currSteps = p.getValue();
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i+1, len);
                for(String adjacent: combinations.getOrDefault(newWord, new HashSet<>())) {
                    if (adjacent.equals(endWord)) return currSteps + 1;

                    if (!visited.containsKey(adjacent)) {
                        visited.put(adjacent, true);
                        queue.offer(new Pair<>(adjacent, currSteps+1));
                    }
                }
            }
        }
        return 0;
    }
}