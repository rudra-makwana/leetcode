/**
 * LeetCode - 207 - https://leetcode.com/problems/course-schedule/description/
 *
 * My approach:
 * 1. Create a HashMap that keeps the immediate prerequisites of the course
 * 2. Iterate over each element set in map to check if the cycle exists or not.
 * 3. To check if cycel exists in the node, apply DFS approach to check if we have a cycle on any of the course
 * 4. If cycle exists that means it is impossible to take a course, hence return true for cycle and return false for the canFinish function
 */

class Solution {
    Map<Integer, List<Integer>> prereq;
    Set<Integer> valids;

    private boolean checkCycle(int sub, Set<Integer> subList) {
        if (!subList.add(sub)) return true;
        if (valids.contains(sub)) return false;
        valids.add(sub);
        List<Integer> pre = prereq.getOrDefault(sub, new ArrayList<Integer>());
        for (Integer p: pre) {
            if (checkCycle(p, subList)) return true;
            subList.remove(p);
        }
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        prereq = new HashMap<>();
        valids = new HashSet<>();
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> temp = prereq.getOrDefault(prerequisites[i][0], new ArrayList<Integer>());
            temp.add(prerequisites[i][1]);
            prereq.put(prerequisites[i][0], temp);
        }
        for (Map.Entry<Integer, List<Integer>> sub: prereq.entrySet()) {
            if (valids.contains(sub.getKey())) continue;
            if (checkCycle(sub.getKey(), new HashSet<Integer>())) return false;
        }
        return valids.size() <= numCourses;
    }
}