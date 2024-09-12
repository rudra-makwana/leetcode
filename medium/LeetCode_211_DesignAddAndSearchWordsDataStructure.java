/**
 * LeetCode - 211 - https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
 *
 * Easy to add and quicker to look for data structure = Simply asking to develop a Trie datastructure.
 *
 * Create a node that stores the character, next possible characters, if that node is used to form a word or not.
 *
 * Creating a node is pretty simple as we can apply BFS traversal. If character is found then reuse the node otherwise
 * create a new node and use it.
 *
 * To search a word without '.': Check if all nodes exist for each characters in chronological order. At the last node,
 * check if it is marked as word.
 *
 * If search word contains '.' at i index. '.' refers to any characters. That means we need to use all children nodes
 * and see if the remaining part of the string matches or not. Meaning we need to check substring(i+1, n) should be fine
 * from selected children node to return true. Otherwise continue to next children node.
 *
 */

class Trie {
    char val;
    boolean word;
    Map<Character, Trie> children;

    public Trie(char val) {
        this.val = val;
        this.children = new HashMap<>();
        this.word = false;
    }
    public Trie(char val, boolean word) {
        this.val = val;
        this.word = word;
        this.children = new HashMap<>();
    }
}

class WordDictionary {
    Trie root;

    public WordDictionary() {
        root = new Trie(' ');
    }

    public void addWord(String word) {
        Trie curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.children.containsKey(c)) curr.children.put(c, new Trie(c));
            curr = curr.children.get(c);
        }
        curr.word = true;
    }

    private boolean search(String word, Trie curr) {
        for(int i = 0; i < word.length(); ++i){
            char c = word.charAt(i);
            if (!curr.children.containsKey(c)) {
                if (c == '.') {
                    for (char x: curr.children.keySet()) {
                        Trie t = curr.children.get(x);
                        if (search(word.substring(i+1), t)) return true;
                    }
                }
                return false;
            } else {
                curr = curr.children.get(c);
            }
        }
        return curr.word;
    }

    public boolean search(String word) {
        return search(word, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */