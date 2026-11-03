class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int max=0;

        int cnt=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
            }
        }
        for(int i=0;i<n;i++)
        {
            cnt+=max-nums[i];
        }
        return cnt;
    }
}