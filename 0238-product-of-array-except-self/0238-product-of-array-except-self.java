class Solution {
    public int[] productExceptSelf(int[] nums) {
    //     int n=nums.length;
    //     int[] ans=new int[n];
    //    // int product=nums[i]
    //     for(int i=0;i<n;i++)
    //     {
    //         int prod=1;
    //         for(int j=0;j<n;j++)
    //         {
    //             if(i==j)
    //             {
    //                 continue;
    //             }
    //             prod=prod*nums[j];
    //         }
    //         ans[i]=prod;
    //     }
    //     return ans;
    int n=nums.length;
    int prod[]=new int[n];
    prod[0]=1;
    for(int i=1;i<n;i++)
    {
        prod[i]=prod[i-1]*nums[i-1];
    }
    int rightproduct=1;
    for(int i=n-1;i>=0;i--)
    {
        prod[i]=prod[i]*rightproduct;
        rightproduct*=nums[i];
    }
    return prod;
    }
}