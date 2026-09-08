class Solution {
    public int findMin(int[] nums) {
      /*  
        Arrays.sort(nums);
        return nums[0];
      */
      int n=nums.length;
      int left=0;
      int right=n-1;
      int ans=Integer.MAX_VALUE;
      while(left<=right)
      {
            int mid=left+(right-left)/2;
            if(nums[mid]<=nums[right])
            {
                if(nums[mid]<ans)
                   ans=nums[mid];
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
      }
      return ans;
    }
}