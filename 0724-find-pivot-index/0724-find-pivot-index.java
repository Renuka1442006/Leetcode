class Solution {
    public int pivotIndex(int[] nums) {
        int ans=-1;
        int n=nums.length;
        int[] prefixsum=new int[n];
        prefixsum[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            prefixsum[i]=prefixsum[i-1]+nums[i];
        }
        if(prefixsum[0]-prefixsum[n-1]==0)
        {
            return 0;
        }
        for(int i=1;i<n;i++)
        {
           
                // if((prefixsum[n-1]-prefixsum[i])==0)
                // {
                //     return 0;
                // }
            
            if(prefixsum[i-1]==(prefixsum[n-1]-prefixsum[i]))
            {
                ans=i;
                break;
            }
        }
        return ans;
    }
}