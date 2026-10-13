class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] squares = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(squares);

        long sum = 0;
        int n = nums.length;
        int positiveCount = (n + 1) / 2;

        for (int i = 0; i < n; i++) {
            if (i < positiveCount) {
                sum += squares[n - 1 - i];
            } else {
                sum -= squares[i - positiveCount];
            }
        }

        return sum;
    }
}
