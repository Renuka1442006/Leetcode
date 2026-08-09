class Solution {
    int n;
    int[][] dp;
    int[] suffix;

    public int stoneGameII(int[] piles) {
        n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        // Suffix sum:
        // suffix[i] = total stones from i to n-1
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return solve(0, 1);
    }

    private int solve(int i, int M) {

        // All piles have been taken
        if (i >= n) {
            return 0;
        }

        // Already calculated
        if (dp[i][M] != 0) {
            return dp[i][M];
        }

        int ans = 0;

        // Try taking X piles
        for (int X = 1; X <= 2 * M && i + X <= n; X++) {

            int newM = Math.max(M, X);

            // Stones opponent can get afterward
            int opponent = solve(i + X, newM);

            // Total remaining stones - opponent's stones
            int currentPlayer = suffix[i] - opponent;

            ans = Math.max(ans, currentPlayer);
        }

        return dp[i][M] = ans;
    }
}