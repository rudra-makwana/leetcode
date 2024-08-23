class TrieNode {
    boolean isEnd;
    Map<Character, TrieNode> children;

    public TrieNode() {
        children = new HashMap<>();
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (!current.children.containsKey(word.charAt(i))) {
                current.children.put(word.charAt(i), new TrieNode());
            }
            current = current.children.get(word.charAt(i));
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode t = root;
        for(int i = 0; i < word.length() && t != null; i++) {
            if (!t.children.containsKey(word.charAt(i))) return false;
            t = t.children.get(word.charAt(i));
        }
        return t.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode t = root;
        for(int i = 0; i < prefix.length(); i++) {
            if (!t.children.containsKey(prefix.charAt(i))) return false;
            t = t.children.get(prefix.charAt(i));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */