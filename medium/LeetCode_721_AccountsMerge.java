/**
 * LeetCode - 721 - https://leetcode.com/problems/accounts-merge/description/
 *
 *
 * Best problem to understand the Disjoint Set Data Structure.
 */

class DSU {
    int[] rep; // Points to parent group of the each groups
    int[] size; // Size of the each groups. It is used to efficiently union the two sets. Small set points to large.

    public DSU (int length) {
        rep = new int[length];
        size = new int[length];

        for (int i = 0; i < length; i++) {
            size[i] = 1; // Size starts from 1 always assuming each group will point to itself
            rep[i] = i; // Assuming all the groups are disjoints in the beginning so poninting to themselves.
        }
    }

    public int findRep(int item) {
        if (item == rep[item]) return item; // if item is same as the value on the item index that means it is parent
        rep[item] = findRep(rep[item]); // change the pointer to root parent while finding the root parent of an element
        return rep[item];
    }

    public void unionBySize(int item1, int item2) {
        int rep1 = findRep(item1);
        int rep2 = findRep(item2);
        if (rep1 == rep2) return; // if rep1 and rep2 are the same that means already unioned

        if (size[rep1] > size[rep2]) { // if rep1 group is bigger than rep2 then rep1 will become a parent of rep2
            size[rep1] += size[rep2];
            rep[rep2] = rep1;
        } else { // if rep2 group is bigger than rep1 then rep2 will become a parent of rep1
            size[rep2] += size[rep1];
            rep[rep1] = rep2;
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int accListSize = accounts.size();
        DSU dsu = new DSU(accListSize); // total groups before unioning (merging) the non-disjoint groups
        Map<String, Integer> emails = new HashMap<>(); // Emails with their groups id in dsu
        for (int i = 0; i < accListSize; i++) {
            int size = accounts.get(i).size();
            for (int j = 1; j < size; j++) {
                String email = accounts.get(i).get(j);
                if (emails.containsKey(email)) {
                    // email is already part of another group. That means we need to union this group ID with that
                    // group's ID.
                    dsu.unionBySize(emails.get(email), i);
                } else {
                    emails.put(email, i); // email is not part of any other group so far
                }
            }
        }
        Map<Integer, List<String>> groupedEmails = new HashMap<>(); // Group ID with all the emails in it
        for (String email: emails.keySet()) {
            int group = emails.get(email); // get the group id of the email
            int groupRep = dsu.findRep(group); // find the representative group ID of the group

            // if get new or existing list of emails using the representative group's id
            List<String> grp = groupedEmails.getOrDefault(groupRep, new ArrayList<String>());
            grp.add(email); // add the email
            groupedEmails.put(groupRep, grp); // add the list back to the map associated with groupRep as a key

            // After this loop. All the emails will be a part of the correct and single group. No more merging needed.
        }
        List<List<String>> result = new ArrayList<>();
        for (int group: groupedEmails.keySet()) {
            List<String> temp = groupedEmails.get(group); // get the list
            Collections.sort(temp); // sort it
            temp.add(0, accounts.get(group).get(0)); // add the user name on first index
            result.add(temp); // add to result list
        }
        return result;
    }
}

/**
 *
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
 *
 *
 * class Solution {
 *     public List<List<String>> accountsMerge(List<List<String>> accounts) {
 *         Map<String, Queue<String>> emails = new HashMap<>();
 *         Map<String, String> names = new HashMap<>();
 *
 *         for (List<String> acc: accounts) {
 *             String name = acc.get(0);
 *             for (int i = 1; i < acc.size(); i++) {
 *                 Queue<String> q = emails.getOrDefault(
 *                         acc.get(i),
 *                         new LinkedList<String>()
 *                 );
 *                 Queue<String> temp = new LinkedList<String>(acc);
 *                 temp.remove();
 *                 q.addAll(temp);
 *                 emails.put(acc.get(i), q);
 *                 names.put(acc.get(i), name);
 *             }
 *         }
 *         Set<String> visited = new HashSet<>();
 *         List<List<String>> result = new ArrayList<>();
 *
 *         for (Map.Entry<String, Queue<String>> e: emails.entrySet()) {
 *             if(visited.contains(e.getKey())) continue;
 *             Queue<String> queue = new LinkedList<>();
 *             String email = e.getKey();
 *             String name = names.get(email);
 *             Set<String> temp = new HashSet<>();
 *             queue.add(email);
 *             while(!queue.isEmpty()) {
 *                 String next = queue.remove();
 *                 if (visited.contains(next)) continue;
 *                 if(temp.add(next)) {
 *                     queue.addAll(emails.get(next));
 *                 }
 *                 visited.add(next);
 *             }
 *             List<String> t = new ArrayList<>(temp);
 *             t.sort(Comparator.naturalOrder());
 *             t.add(0, name);
 *             result.add(new ArrayList(t));
 *         }
 *         return result;
 *     }
 * }
 *
 *
 */