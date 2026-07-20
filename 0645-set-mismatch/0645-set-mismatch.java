class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        int dup=0;
        int mis=0;
        //Arrays.sort(nums);
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            if(set.contains(nums[i]))
            {
                dup=nums[i];
                break;
            }
            set.add(nums[i]);
        }
        
        int totalsum=n*(n+1)/2;
        int actualsum=0;
        for(int num:nums)
        {
            actualsum+=num;
        }
        mis=dup-(actualsum-totalsum);
        return new int[]{dup,mis};
    }
}