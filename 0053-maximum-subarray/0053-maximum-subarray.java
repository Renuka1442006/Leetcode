class Solution {
    public int maxSubArray(int[] nums) {
        int curr=nums[0];
        int maxsum=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++)
        {
            curr=Math.max(curr+nums[i],nums[i]);
            maxsum=Math.max(maxsum,curr);
        }
        return maxsum;
    }
}