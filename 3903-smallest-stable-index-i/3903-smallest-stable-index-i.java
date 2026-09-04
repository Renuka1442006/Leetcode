class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
      
        int ans=-1;
        for(int i=0;i<n;i++)
        {
            int min=Integer.MAX_VALUE;
             int maxele=Integer.MIN_VALUE;
            for(int j=0;j<=i;j++)
            {
                 if(nums[j]>maxele)
                {
                    maxele=nums[j];
                }
            }
            for(int j=i;j<n;j++)
            {
                if(nums[j]<min)
                {
                    min=nums[j];
                }
            }
            if((maxele-min)<=k)
            {
                ans=i;
                break;
            }
        }
        return ans;
    }
}