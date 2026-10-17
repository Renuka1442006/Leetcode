
class Solution {
    static final int MOD = 1_000_000_007;

    int[] sum, sumSq, lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new int[4 * n];
        sumSq = new int[4 * n];
        lazy = new int[4 * n];

        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = last[nums[i]];

            update(1, 0, n - 1, prev + 1, i);

            ans = (ans + sumSq[1]) % MOD;

            last[nums[i]] = i;
        }

        return (int) ans;
    }

    void update(int node, int start, int end,
                int left, int right) {
        if (left <= start && end <= right) {
            apply(node, start, end);
            return;
        }

        pushDown(node, start, end);

        int mid = start + (end - start) / 2;

        if (left <= mid) {
            update(node * 2, start, mid, left, right);
        }

        if (right > mid) {
            update(node * 2 + 1, mid + 1, end,
                   left, right);
        }

        sum[node] = (int) (
            ((long) sum[node * 2] + sum[node * 2 + 1]) % MOD
        );

        sumSq[node] = (int) (
            ((long) sumSq[node * 2] + sumSq[node * 2 + 1]) % MOD
        );
    }

    void apply(int node, int start, int end) {
        long len = end - start + 1L;
        long s = sum[node];

        sumSq[node] = (int) (
            (sumSq[node] + 2L * s + len) % MOD
        );

        sum[node] = (int) ((s + len) % MOD);
        lazy[node]++;
    }

    void pushDown(int node, int start, int end) {
        if (lazy[node] == 0 || start == end) {
            return;
        }

        int mid = start + (end - start) / 2;
        int pending = lazy[node];

        applyMultiple(node * 2, start, mid, pending);
        applyMultiple(node * 2 + 1, mid + 1, end, pending);

        lazy[node] = 0;
    }

    void applyMultiple(int node, int start, int end,
                       int delta) {
        long len = end - start + 1L;
        long d = delta;
        long s = sum[node];

        sumSq[node] = (int) (
            (sumSq[node] + 2L * d * s
             + len * d % MOD * d) % MOD
        );

        sum[node] = (int) ((s + len * d) % MOD);
        lazy[node] += delta;
    }
}
