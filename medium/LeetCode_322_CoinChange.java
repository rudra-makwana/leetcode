/**
 * LeetCode - 322 - https://leetcode.com/problems/coin-change/description/
 */


class Solution {
    private int coinChangeDP_BottomUp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0; // for amount 0, we need no coins
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        if (dp[amount] == amount + 1) return -1;
        return dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        return coinChangeDP_BottomUp(coins, amount);
    }
}


/**
 * Approach 1 -> Dynamic Programming: Bottom - Up method
 *
 * 1. Initialize an array of size (amount + 1). Array's indices mean the amount and the values on those indices means
 * minimum coins required for that amount. Let's call the array DP.
 * 2. Set the values of the array to maximum possible coins + 1. This will help us to find the minimum possible chages.
 * 3. Iterate over the DP from i = 1 to amount:
 *      a. Iteate over each coins here. for coin in coins:
 *          i. if (i - coin) < 0 then continue;
 *          ii. DP[i] = min(DP[i], DP[i - coin] + 1);
 * 4. if dp[amount] == amount + 1 => return -1 // did not change during entire process means,
 * we cannot get changes for amount.
 * 5. return dp[amount]
 *
 *
 * class Solution {
 *
 *     private int coinChangeDP_BottomUp(int[] coins, int amount) {
 *         int[] dp = new int[amount + 1];
 *         Arrays.fill(dp, amount+1);
 *         dp[0] = 0; // for amount 0, we need no coins
 *         for (int i = 1; i < amount + 1; i++) {
 *             for (int j = 0; j < coins.length; j++) {
 *                 if (i - coins[j] < 0) continue;
 *                 dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
 *             }
 *         }
 *         if (dp[amount] == amount + 1) return -1;
 *         return dp[amount];
 *     }
 *
 *     public int coinChange(int[] coins, int amount) {
 *         return coinChangeDP_BottomUp(coins, amount);
 *     }
 * }
 *
 *
 * Approach 2: BFS method using queue.
 *
 * 1. If the amount == 0 return 0;
 * 2. Initialize queue of tuples. Where first element will be amount and 2nd will be number of coins in the tuples.
 * 3. Initialize hashset to not add already added amount in the queue.
 * 4. Add (0, 0) tuple in the queue. 0 coins required for 0 amount
 * 5. iterate while queue is not empty.
 *      curr_amount, num_coins = queue.pop()
 *      a. For coin in coins:
 *          i. new_amount = curr_amount + coin
 *          i. new_amount == amount then return (num_coins + 1)
 *          ii. if new_amount < amount && visited not contains new_amount:
 *              queue.add((new_amount, num_coins + 1))
 * 6. return -1. // the solution is not possible
 *
 * private int coinChangeDP_BFS(int[] coins, int amount) {
 *         if (amount == 0) return 0;
 *         Queue<int[]> queue = new LinkedList<int[]>();
 *         Set<Integer> visited = new HashSet<>();
 *         queue.add(new int[] {0, 0}); // 0 coins required for 0 amount
 *         visited.add(0);
 *         while (!queue.isEmpty()) {
 *             int[] temp = queue.remove();
 *             for (int i = 0; i < coins.length; i++) {
 *                 int curr = temp[0] + coins[i];
 *                 if (curr == amount) return temp[1] + 1;
 *                 if (curr < amount && !visited.add(curr)) {
 *                     queue.add(new int[] {curr, temp[1] + 1});
 *                 }
 *             }
 *         }
 *         return -1;
 *     }
 *
 * Approach 3: Recursion with memoization
 * memo = []
 *
 *func getChanges(int[] coins, int amount):
 * 1. If amount == 0 return 0;
 * 2. if amount < 0 return -1;
 * 3. if memo[amount] != -1 return memo[amount] // We already know what is the num of coins required for amount
 * 4. int min = amount + 1 // Start with maximum possible values
 * 4. for coin in coins:
 *      a. int count = getChanges(coins, amount - coin)
 *      b. if count == -1: continue
 *      c. min = Math.min(min, count + 1);
 * 5. if min == amount + 1 return -1;
 * 6. memo[amount] = min
 * 7. return min;
 *
 * func main(int[] coins, int amount):
 * 1. memo = new int[amount + 1]
 * 2. Arrays.fill(memo, -1)
 * 3. getChanges(coins, amount)
 *
 */