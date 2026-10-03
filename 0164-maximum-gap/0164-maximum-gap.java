class Solution {
    public int maximumGap(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int maxdiff=0;
        for(int i=1;i<n;i++)
        {
            int d=nums[i]-nums[i-1];
            maxdiff=Math.max(maxdiff,d);
        }
        return maxdiff;
    }
}