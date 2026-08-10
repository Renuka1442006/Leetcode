class Solution {
    public int niceSubArray(int[] nums,int k)
    {
        if(k<0)
        {
            return 0;
        }
        int right=0;
        int left=0;
        int count=0;
        int oddcount=0;
        int size=nums.length;
        while(right<size)
        {
            if(nums[right]%2!=0)
            {
                oddcount++;
            }
            while(oddcount>k)
            {
                if(nums[left]%2!=0)
                {
                    oddcount--;
                }
                left++;
            }
            count=count+(right-left+1);
            right++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return niceSubArray(nums,k)-niceSubArray(nums,k-1);
    }
}