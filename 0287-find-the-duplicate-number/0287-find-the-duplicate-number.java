class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int n=nums.length;
        int res=0;
        for(int i=0;i<n;i++)
        {
            if(set.contains(nums[i]))
            {
                res=nums[i];
                break;
            }
            set.add(nums[i]);
        }
        return res;
    }
}