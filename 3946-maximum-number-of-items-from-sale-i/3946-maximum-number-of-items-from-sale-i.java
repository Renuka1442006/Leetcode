
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;
        int minPrice = Integer.MAX_VALUE;

        // Find minimum price
        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
        }

        // Calculate gain of every item
        int[] gain = new int[n];

        for (int i = 0; i < n; i++) {
            gain[i] = 1;

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    gain[i]++;
                }
            }
        }

        // 0/1 Knapsack DP
        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {

            int price = items[i][1];

            for (int b = budget; b >= price; b--) {
                dp[b] = Math.max(dp[b],
                        dp[b - price] + gain[i]);
            }
        }

        // Use remaining budget to buy additional copies
        int ans = 0;

        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans,
                    dp[b] + (budget - b) / minPrice);
        }

        return ans;
    }
}