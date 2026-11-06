class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        int m = queries.length;
        int[] ans = new int[m];
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        int[][] q = new int[m][2];

        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));
        int[] freq = new int[n + 1];

        int left = 0;
        int right = 0;
        int active = 0;

        // Step 5: Process each query
        for (int i = 0; i < m; i++) {

            int end = q[i][0];
            int start = end - x;
            int index = q[i][1];

            // Add logs whose timestamp <= end
            while (right < logs.length && logs[right][1] <= end) {

                int server = logs[right][0];

                if (freq[server] == 0) {
                    active++;
                }

                freq[server]++;
                right++;
            }

            // Remove logs whose timestamp < start
            while (left < right && logs[left][1] < start) {

                int server = logs[left][0];

                freq[server]--;

                if (freq[server] == 0) {
                    active--;
                }

                left++;
            }

            // Servers without requests
            ans[index] = n - active;
        }

        return ans;
    }
}