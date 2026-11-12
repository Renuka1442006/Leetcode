class Solution {
    // public boolean isIncreasing(int[] nums)
    // {
    //     int n=nums.length;
    //     for(int i=1;i<n;i++)
    //     {
    //         if(nums[i-1]>=nums[i])
    //         {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // public boolean isDecreasing(int[] nums)
    // {
    //      int n=nums.length;
    //     for(int i=1;i<n;i++)
    //     {
    //         if(nums[i-1]<=nums[i])
    //         {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    public int longestMonotonicSubarray(int[] nums) {
    //     int n=nums.length;
    //     int ans=0;
    //     for(int i=0;i<n;i++)
    //     {
    //         for(int j=i;j<n;j++)
    //         {
    //             int[] newarr=new int[j-i+1];
    //             int idx=0;
    //             for(int k=i;k<=j;k++)
    //             {
    //                 newarr[idx]=nums[k];
    //                 idx++;
    //             }
    //             if(isIncreasing(newarr) || isDecreasing(newarr))
    //             {
    //                 ans=Math.max(ans,newarr.length);
    //             }
    //         }
    //     }
    //     return ans;
    int inc=1;
    int dec=1;
    int maxlen=1;
    int n=nums.length;
    for(int i=1;i<n;i++)
    {
        if(nums[i]>nums[i-1])
        {
            inc++;
            dec=1;
        }
        else if(nums[i]<nums[i-1])
        {
            dec++;
            inc=1;
        }
        else
        {
            inc=1;
            dec=1;
        }
        maxlen=Math.max(maxlen,Math.max(dec,inc));
    }
    return maxlen;
    }
}