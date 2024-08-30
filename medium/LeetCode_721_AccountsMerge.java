/**
 * LeetCode - 721 - https://leetcode.com/problems/accounts-merge/description/
 *
 * My initial approach: Worst approach. Look into the Disjoint Set Union (DSU) algorithm. I must learn this by end of
 * day.
 *
 * 1. A hashmap to track name associated with the email
 * 2. Another hashmap which has an email as key and all the associated emails to this key
 * 3. Iterate over each emails by n * k to fill up the above hashmaps
 * 4. A set to maintain visited nodes to avoid processing them again
 * 5. Iterate ove the hashmap's one by one.
 *      a. if the map's key is already processed then continue to next iteration
 *      b. create an empty queue
 *      c. create an empty hashset
 *      d. Add curr email to queue
 *      e. while queue is not empty:
 *          i pop the email
 *          ii. if exists in the visited then continue the loop
 *          iii. if doesn't exist then add it set created outside of this loop
 *          iv. if added then add all the associated emails of selected email to the queue
 *          v. add the email to visited state
 *      f. Create a list using the hashset
 *      g. sort it in ascending order
 *      h. add name on the first index (i == 0)
 *      i. add the list to main list (list of list)
 * 6. return the main list
 */

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Queue<String>> emails = new HashMap<>();
        Map<String, String> names = new HashMap<>();

        for (List<String> acc: accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                Queue<String> q = emails.getOrDefault(
                        acc.get(i),
                        new LinkedList<String>()
                );
                Queue<String> temp = new LinkedList<String>(acc);
                temp.remove();
                q.addAll(temp);
                emails.put(acc.get(i), q);
                names.put(acc.get(i), name);
            }
        }
        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<String, Queue<String>> e: emails.entrySet()) {
            if(visited.contains(e.getKey())) continue;
            Queue<String> queue = new LinkedList<>();
            String email = e.getKey();
            String name = names.get(email);
            Set<String> temp = new HashSet<>();
            queue.add(email);
            while(!queue.isEmpty()) {
                String next = queue.remove();
                if (visited.contains(next)) continue;
                if(temp.add(next)) {
                    queue.addAll(emails.get(next));
                }
                visited.add(next);
            }
            List<String> t = new ArrayList<>(temp);
            t.sort(Comparator.naturalOrder());
            t.add(0, name);
            result.add(new ArrayList(t));
        }
        return result;
    }
}