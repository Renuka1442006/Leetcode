class Solution {
    public int subarraySum(int[] nums, int k) {
       /* int n=nums.length;
        int count=0;
       for(int i=0;i<n;i++)
       {
            int sum=0;
          for(int j=i;j<n;j++)
          {
            sum+=nums[j];
            if(sum==k)
            {
                count++;   
            }
          }
          
       }
       return count;
       */
       int n=nums.length;
       HashMap<Integer, Integer> map=new HashMap<>();
       int ans=0;
       int presum=0;
       map.put(0,1);
       for(int i=0;i<n;i++)
       {
            presum+=nums[i];
            int target=presum-k;
            if(map.containsKey(target))
            {
                ans+=map.get(target);
            }
            map.put(presum,map.getOrDefault(presum,0)+1);
       }
       return ans;
    }
}