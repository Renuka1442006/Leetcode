class Solution {
    public int subset(int[] nums,int i,int xor)
    {
        if(i==nums.length)
        {
            return xor;
        }
        int include=subset(nums,i+1,xor^nums[i]);
        int exclude=subset(nums,i+1,xor);
        return include+exclude;
    }
    public int subsetXORSum(int[] nums) {
       return subset(nums,0,0);
    }
}