class Solution {
    public int climbStairs(int n, int[] costs) {

        int prev1 = 0; // dp[i-1]
        int prev2 = 0; // dp[i-2]
        int prev3 = 0; // dp[i-3]

        for (int i = 1; i <= n; i++) {

            int curr = prev1 + costs[i - 1] + 1;

            if (i >= 2) {
                curr = Math.min(
                    curr,
                    prev2 + costs[i - 1] + 4
                );
            }

            if (i >= 3) {
                curr = Math.min(
                    curr,
                    prev3 + costs[i - 1] + 9
                );
            }

            // Shift previous states
            prev3 = prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}