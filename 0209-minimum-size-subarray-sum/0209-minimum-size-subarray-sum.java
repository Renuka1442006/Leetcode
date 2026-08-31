class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minlen=Integer.MAX_VALUE;
        int n=nums.length;
        int left=0;
        int sum=0;
       
        for(int right=0;right<n;right++)
        {
            sum+=nums[right];
            while(sum>=target)
            {
               int len=right-left+1; 
               if(minlen>len)
               {
                    minlen=len;
               }
                sum-=nums[left];
                left++;
            }
  
        }
        if(minlen==Integer.MAX_VALUE)
        {
            return 0;
        }
        return minlen;
    }
}