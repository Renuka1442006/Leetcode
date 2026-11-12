class Solution {
    public boolean isIncreasing(int[] nums)
    {
        int n=nums.length;
        for(int i=1;i<n;i++)
        {
            if(nums[i-1]>=nums[i])
            {
                return false;
            }
        }
        return true;
    }
    public boolean isDecreasing(int[] nums)
    {
         int n=nums.length;
        for(int i=1;i<n;i++)
        {
            if(nums[i-1]<=nums[i])
            {
                return false;
            }
        }
        return true;
    }
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                int[] newarr=new int[j-i+1];
                int idx=0;
                for(int k=i;k<=j;k++)
                {
                    newarr[idx]=nums[k];
                    idx++;
                }
                if(isIncreasing(newarr) || isDecreasing(newarr))
                {
                    ans=Math.max(ans,newarr.length);
                }
            }
        }
        return ans;
    }
}