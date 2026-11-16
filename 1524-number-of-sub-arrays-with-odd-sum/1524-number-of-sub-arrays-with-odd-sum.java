
class Solution {
    public int numOfSubarrays(int[] arr) {

        int mod = 1000000007;

        int even = 1;  // Initial prefix sum = 0
        int odd = 0;

        int prefix = 0;
        int ans = 0;

        for (int num : arr) {

            prefix += num;

            if (prefix % 2 == 0) {

                // Current prefix is even
                ans = (ans + odd) % mod;
                even++;

            } else {

                // Current prefix is odd
                ans = (ans + even) % mod;
                odd++;
            }
        }

        return ans;
    }
}
