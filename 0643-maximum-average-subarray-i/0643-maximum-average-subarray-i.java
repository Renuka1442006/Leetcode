class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxavg = Double.NEGATIVE_INFINITY;
        for(int i = 0; i + k <= nums.length; i++) 
        {
            int sum = 0;
            for(int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            double avg = (double) sum / k;
            maxavg = Math.max(maxavg, avg);
        }
        return maxavg;
    }
}