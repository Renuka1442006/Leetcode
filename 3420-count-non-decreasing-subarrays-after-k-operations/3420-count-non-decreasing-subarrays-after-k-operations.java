
import java.util.*;

class Solution {

    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        // Step 1: Calculate prefix sums
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // Step 2: Find next greater element
        int[] next = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for (int i = n - 1; i >= 0; i--) {

            while (top >= 0 &&
                   nums[stack[top]] <= nums[i]) {
                top--;
            }

            next[i] = (top == -1) ? -1 : stack[top];

            stack[++top] = i;
        }

        // Step 3: Binary lifting preprocessing
        int LOG = 1;

        while ((1L << LOG) <= n) {
            LOG++;
        }

        int[][] up = new int[LOG][n];
        long[][] sum = new long[LOG][n];

        for (int[] row : up) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < n; i++) {

            up[0][i] = next[i];

            if (next[i] != -1) {
                sum[0][i] =
                    (long) nums[i] * (next[i] - i);
            }
        }

        for (int p = 1; p < LOG; p++) {

            for (int i = 0; i < n; i++) {

                int mid = up[p - 1][i];

                if (mid != -1) {

                    int end = up[p - 1][mid];

                    if (end != -1) {

                        up[p][i] = end;

                        sum[p][i] =
                            sum[p - 1][i] +
                            sum[p - 1][mid];
                    }
                }
            }
        }

        // Step 4: Binary search for every left index
        long answer = 0;

        for (int l = 0; l < n; l++) {

            int low = l;
            int high = n;

            while (low < high) {

                int mid = low + (high - low) / 2;

                long maxSum = getMaxSum(
                    l, mid, nums, up, sum, LOG
                );

                long operations =
                    maxSum - (prefix[mid + 1] - prefix[l]);

                if (operations <= k) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            // All ending positions from l to low-1
            // are valid.
            answer += low - l;
        }

        return answer;
    }

    // Calculates sum of prefix maximums in [l, r]
    private long getMaxSum(
        int l,
        int r,
        int[] nums,
        int[][] up,
        long[][] sum,
        int LOG
    ) {

        long result = 0;
        int current = l;

        for (int p = LOG - 1; p >= 0; p--) {

            int next = up[p][current];

            if (next != -1 && next <= r) {

                result += sum[p][current];

                current = next;
            }
        }

        // Remaining range has the same maximum
        result += (long) nums[current] *
                  (r - current + 1);

        return result;
    }
}
