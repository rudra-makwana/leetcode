/**
 * LeetCode - 981 - https://leetcode.com/problems/time-based-key-value-store/description/
 *
 * Problem statement:
 * Design a time-based key-value data structure that can store multiple values for the same key at different time stamps
 * and retrieve the key's value at a certain timestamp.
 *
 * - TimeMap() Initializes the object of the data structure.
 * - void set(String key, String value, int timestamp) Stores the key key with the value value at the given timestamp.
 * - String get(String key, int timestamp) Returns a value such that set was called previously, with
 *  timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the
 *  largest timestamp_prev. If there are no values, it returns "".
 *
 *  Conditions: All the timestamps timestamp of set are strictly increasing.
 *
 *  Approach:
 *  Use a normal hashmap that stores key and the list of <timestamp, value> pair
 *  New timestamp for the same key will always be larger than the previous one.
 *
 */

class TimeMap {
    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Pair> list = map.getOrDefault(key, new ArrayList<Pair>());
        list.add(new Pair(timestamp, value));
        map.put(key, list);
    }

    public String get(String key, int timestamp) {
        List<Pair> list = map.getOrDefault(key, new ArrayList<Pair>());
        for (int i = list.size() - 1; i >= 0; i--) {
            Pair<Integer, String> pair = list.get(i);
            if (pair.getKey() <= timestamp) return pair.getValue();
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */