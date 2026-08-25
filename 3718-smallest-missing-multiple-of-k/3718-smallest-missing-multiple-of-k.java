class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            set.add(nums[i]);
        }
        int i=1;
        
        int ans=0;
        while(true)
        {
            int res=i*k;
            if(!set.contains(res))
            {
                ans=res;
                break;
            }
            i++;
        }
        return ans;
    }
}