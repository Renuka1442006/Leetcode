
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2,
                                 int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];

        long totalDiff = 0;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            totalDiff += diff[i];
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        long k = (long) k1 + k2;

        if (totalDiff <= k) {
            return 0;
        }

        // Find the smallest affordable maximum difference.
        int low = 0, high = maxDiff;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long operations = 0;

            for (int d : diff) {
                if (d > mid) {
                    operations += d - mid;
                }
            }

            if (operations <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int target = low;
        long used = 0;
        long sum = 0;
        long count = 0;

        for (int d : diff) {
            if (d > target) {
                used += d - target;
                sum += (long) target * target;
                count++;
            } else {
                sum += (long) d * d;
            }
        }

        // Spend remaining operations reducing target to target - 1.
        long remaining = k - used;
        sum -= remaining * (2L * target - 1);

        return sum;
    }
}
