class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // boolean res=false;
        // int n=nums.length;
        // for(int i=0;i<n;i++)
        // {
        //     int sum=nums[i];
        //     for(int j=i+1;j<n;j++)
        //     {
        //         sum+=nums[j];
        //         if(sum%k==0)
        //         {
        //             return true;
        //         }
        //     }
            

        // }
        // return false;
        int n=nums.length;
       HashMap<Integer,Integer> map=new HashMap<>();
       map.put(0,-1);
      int sum=0;
       for(int i=0;i<n;i++)
       {
           sum+=nums[i];
           int rem=sum%k;
            if(map.containsKey(rem))
            {
               if(i-map.get(rem)>=2)
               {
                return true;
               }
            }
            else{
                map.put(rem,i);
            }
       }
       return false;
    }
}