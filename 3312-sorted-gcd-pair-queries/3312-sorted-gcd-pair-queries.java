class Solution {
   
    public int[] gcdValues(int[] nums, long[] queries) {
        int max=0;
        
        for(int i=0;i<nums.length;i++)
        {
            max=Math.max(nums[i],max);
        }
        int[] freq = new int[max + 1];
        for (int x : nums) {
            freq[x]++;
        }
        // exactPairs[g] = number of pairs having gcd exactly g
        long[] exactPairs = new long[max + 1];

        // Count pairs for every possible gcd
        for (int g = max; g >= 1; g--) {

            long cnt = 0;

            // Count numbers divisible by g
            for (int multiple = g; multiple <= max; multiple += g) {
                cnt += freq[multiple];
            }

            // Total pairs divisible by g
            long pairs = cnt * (cnt - 1) / 2;

            // Remove pairs whose gcd is a multiple of g
            for (int multiple = g * 2; multiple <= max; multiple += g) {
                pairs -= exactPairs[multiple];
            }

            exactPairs[g] = pairs;
        }

        // Prefix counts
        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + exactPairs[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long q = queries[i] + 1;

            int left = 1;
            int right = max;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (prefix[mid] >= q)
                    right = mid;
                else
                    left = mid + 1;
            }

            ans[i] = left;
        }

        return ans;

    }
}