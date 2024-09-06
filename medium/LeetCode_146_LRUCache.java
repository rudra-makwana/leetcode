/**
 *
 * LeetCode - 146 - https://leetcode.com/problems/lru-cache/description/
 *
 */

class ListNode {
    int val;
    int key;
    ListNode next, prev;
    public ListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Map<Integer, ListNode> cache;
    int capacity;
    ListNode head, tail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void add(ListNode recent) {
        tail.prev.next = recent;
        recent.prev = tail.prev;
        recent.next = tail;
        tail.prev = recent;
    }

    private void remove(ListNode t) {
        t.prev.next = t.next;
        t.next.prev = t.prev;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        ListNode node = cache.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            cache.remove(key);
            remove(node);
        }
        ListNode newN = new ListNode(key, value);
        cache.put(key, newN);
        add(newN);
        if(cache.size() > capacity) {
            ListNode n = head.next;
            remove(n);
            cache.remove(n.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */