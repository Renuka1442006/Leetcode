class Solution {

    class MedianWindow {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        int leftSize = 0, rightSize = 0;
        long leftSum = 0, rightSum = 0;

        void add(int num) {
            if (left.isEmpty() || num <= left.lastKey()) {
                left.put(num, left.getOrDefault(num, 0) + 1);
                leftSize++;
                leftSum += num;
            } else {
                right.put(num, right.getOrDefault(num, 0) + 1);
                rightSize++;
                rightSum += num;
            }
            balance();
        }

        void remove(int num) {
            if (left.containsKey(num)) {
                removeValue(left, num);
                leftSize--;
                leftSum -= num;
            } else {
                removeValue(right, num);
                rightSize--;
                rightSum -= num;
            }
            balance();
        }

        void removeValue(TreeMap<Integer, Integer> map, int num) {
            int count = map.get(num);
            if (count == 1) {
                map.remove(num);
            } else {
                map.put(num, count - 1);
            }
        }

        void balance() {
            while (leftSize > rightSize + 1) {
                int num = left.lastKey();
                removeValue(left, num);
                leftSize--;
                leftSum -= num;

                right.put(num, right.getOrDefault(num, 0) + 1);
                rightSize++;
                rightSum += num;
            }

            while (leftSize < rightSize) {
                int num = right.firstKey();
                removeValue(right, num);
                rightSize--;
                rightSum -= num;

                left.put(num, left.getOrDefault(num, 0) + 1);
                leftSize++;
                leftSum += num;
            }
        }

        long getCost() {
            int median = left.lastKey();

            long leftCost = (long) median * leftSize - leftSum;
            long rightCost = rightSum - (long) median * rightSize;

            return leftCost + rightCost;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;
        int m = n - x + 1;

        long[] cost = new long[m];

        MedianWindow window = new MedianWindow();

        for (int i = 0; i < x; i++) {
            window.add(nums[i]);
        }

        cost[0] = window.getCost();

        for (int i = 1; i < m; i++) {
            window.remove(nums[i - 1]);
            window.add(nums[i + x - 1]);

            cost[i] = window.getCost();
        }

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }

        // Selecting zero subarrays requires zero operations
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // dp[i][j] = minimum cost to select j subarrays
        // from the first i elements

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= k; j++) {

                // Choice 1: Skip current element
                dp[i][j] = dp[i - 1][j];
                if (i >= x && dp[i - x][j - 1] != INF) {

                    long take = dp[i - x][j - 1] + cost[i - x];

                    dp[i][j] = Math.min(dp[i][j], take);
                }
            }
        }

        return dp[n][k];
    }
}
