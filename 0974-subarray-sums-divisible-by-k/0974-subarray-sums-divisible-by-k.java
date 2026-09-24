class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int cnt=0;
        map.put(0,1);
        for(int num:nums)
        {
            sum+=num;
            int rem=sum%k;
            if(rem<0)
            {
                rem+=k;
            }
            if(map.containsKey(rem))
            {
                cnt += map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return cnt;
        // int ans=0;
        // int n=nums.length;
        // int cnt=0;
        // for(int i=0;i<n;i++)
        // {
        //     int sum=0;
        //     for(int j=i;j<n;j++)
        //     {
        //         sum+=nums[j];
        //         if(sum%k==0)
        //         {
        //             cnt++;
        //         }
        //     }
        // }
        // return cnt;
    }
}