
import java.util.*;

class Solution {

    public int minimumChanges(String s, int k) {

        int n = s.length();

        int[][] cost = new int[n][n];

        // Precompute semi-palindrome conversion costs
        for (int len = 2; len <= n; len++) {

            for (int i = 0; i + len <= n; i++) {

                int j = i + len - 1;

                cost[i][j] = Integer.MAX_VALUE;

                for (int d = 1; d < len; d++) {

                    if (len % d != 0) {
                        continue;
                    }

                    int changes = 0;

                    for (int start = 0; start < d; start++) {

                        int left = i + start;
                        int right = left;

                        while (right + d < i + len) {
                            right += d;
                        }

                        while (left < right) {

                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    cost[i][j] = Math.min(
                        cost[i][j], changes
                    );
                }
            }
        }

        // Partition DP
        int INF = 1000000;

        int[][] dp = new int[n + 1][k + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        for (int i = 2; i <= n; i++) {

            for (int j = 1; j <= k; j++) {

                for (int p = 0; p <= i - 2; p++) {

                    if (dp[p][j - 1] == INF) {
                        continue;
                    }

                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[p][j - 1] + cost[p][i - 1]
                    );
                }
            }
        }

        return dp[n][k];
    }
}
