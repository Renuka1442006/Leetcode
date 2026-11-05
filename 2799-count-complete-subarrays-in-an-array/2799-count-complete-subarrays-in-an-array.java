class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            set.add(nums[i]);
        }
        int distinct=set.size();
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            HashSet<Integer> s1=new HashSet<>();
            for(int j=i;j<n;j++)
            {
                s1.add(nums[j]);
                if(distinct==s1.size())
                {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}