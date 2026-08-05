class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {

        //create the all the possible subsarray can every time 
        //store the subarray elements in the hashset and check is it equal to the k then increase the count.
        
        // int n=nums.length;
        // int res=0;
        // for(int i=0;i<n;i++)
        // {
        //      HashSet<Integer> set=new HashSet<>();
        //     for(int j=i;j<n;j++)
        //     {
        //        set.add(nums[j]);
        //         if(set.size()==k)
        //         {
        //             res++;
        //         }
        //     }
        // }
        // return res;
       return atmost(nums,k)-atmost(nums,k-1);
      
    }
    public int atmost(int[] nums,int k)
    {
        int left = 0;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {

            // Add current element
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // Shrink window until it has at most k distinct elements
            while (map.size() > k) {

                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }

                left++;
            }

            // Count all valid subarrays ending at 'right'
            count += (right - left + 1);
        }

        return count;
    }

}