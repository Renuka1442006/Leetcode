class Solution {
    int subarraywithSum(int[] nums, int goal)
    {
        if(goal<0)
        {
            return 0;
        }
        int left=0;
        int right=0;
        int n=nums.length;
        int sum=0;
        int count=0;
        while(right<n)
        {
            sum+=nums[right];
            while(sum>goal)
            {
                sum-=nums[left];
                left++;
            }
            count=count+(right-left+1);
            right++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        // int count=0;
        // for(int i=0;i<nums.length;i++)
        // {
            
        //     for(int j=i;j<nums.length;j++)
        //     {
        //         int sum=0;
        //         for(int k=i;k<=j;k++)
        //         {
        //             sum+=nums[k];
                    
        //         }
        //         if(sum==goal)
        //          {
        //                 count++;
        //        }
        //     }
        // }
        // return count;
        return subarraywithSum(nums,goal)-subarraywithSum(nums,goal-1);
    }
}