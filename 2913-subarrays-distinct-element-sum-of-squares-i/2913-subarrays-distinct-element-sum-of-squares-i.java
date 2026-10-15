class Solution {
    public int sumCounts(List<Integer> nums) {
        int n=nums.size();
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                HashSet<Integer> set=new HashSet<>();
                for(int k=i;k<=j;k++)
                {
                    set.add(nums.get(k));
                }
                int size=set.size();
                ans+=(size*size);
            }
        }
        return ans;
    }
}