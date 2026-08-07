class Solution {
    public int longestOnes(int[] nums, int k) {
        // int count=0;
        // int n=nums.length;
        // for(int i=0;i<n;i++)
        // {
        //     int zerocount=0;
        //     for(int j=i;j<n;j++)
        //     {
        //         if(nums[j]==0)
        //         {
        //             zerocount++;
        //         }
        //        
        //         if(zerocount==k)//this is not work when k=1 so zerocount<=1;
        //         {
        //             break;
        //         }
                //  if(zerocount==k)//
        //         {
        //             count=Math.max(count,j-i+1);
        //         }
                
        //     }

        // }
        // return count;
        int left=0;
        int maxlen=0;
        int zerocount=0;
        for(int right=0;right<nums.length;right++)
        {
            
            if(nums[right]==0)
            {
                zerocount++;
            }
            while (zerocount > k) {

                if (nums[left] == 0) {
                    zerocount--;
                }

                left++;
            }

            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;

    }
}