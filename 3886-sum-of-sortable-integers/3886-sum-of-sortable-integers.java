
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;
            int prevLast = -1;

            for (int i = 0; i < n; i += k) {
                int drops = 0;
                int dropIdx = -1;

                for (int j = i; j < i + k - 1; j++) {
                    if (nums[j] > nums[j + 1]) {
                        drops++;
                        dropIdx = j;
                    }
                }

                if (nums[i + k - 1] > nums[i]) {
                    drops++;
                }

                if (drops > 1) {
                    valid = false;
                    break;
                }

                int first, last;

                if (dropIdx != -1) {
                    first = nums[dropIdx + 1];
                    last = nums[dropIdx];
                } else {
                    first = nums[i];
                    last = nums[i + k - 1];
                }

                if (i > 0 && prevLast > first) {
                    valid = false;
                    break;
                }

                prevLast = last;
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}
