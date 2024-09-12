/**
 * LeetCode - 692 - https://leetcode.com/problems/top-k-frequent-words/
 *
 * Idea:
 * 1. Create a data structure which uses Comparable interface
 * 2. The data structure should have word and its count
 * 3. Override compareTo method of Comparable interface so when we store the data in the priority queue this will
 * apply the our comparision method to keep the element in the queue.
 *
 * 4. Create a counter map of all words
 * 5. Create a priority queue using the word counter and data structure. Top element would be with highest freq and/or lexi order
 *
 * 6. pop first k elements in the result array and return the result array/list
 */

class Solution {
    class Word implements Comparable<Word>{ // new data structure implementing Comparable interface
        public String word;
        public int count;

        public Word(String word) {
            this.word = word;
            this.count = 1;
        }

        public int compareTo(Word other) { // this is the most important part of the function
            if (this.count == other.count) { // if same count meaning use lexicographical order
                return this.word.compareTo(other.word);
            }
            return other.count - this.count; // else use count for the order
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        // Creating a map with counts
        HashMap<String, Word> count = new HashMap<>();
        for (String word: words) {
            if (count.containsKey(word)) {
                count.get(word).count++;
            } else {
                count.put(word, new Word(word));
            }
        }
        // creating a queue with the objects
        PriorityQueue<Word> queue = new PriorityQueue<Word>();
        for(Map.Entry<String, Word> pair: count.entrySet()) {
            queue.offer(pair.getValue());
        }

        List<String> res = new ArrayList<>();
        // popping and adding till we find the top k elements or empty queue
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            res.add(queue.remove().word);
        }
        return res;
    }
}