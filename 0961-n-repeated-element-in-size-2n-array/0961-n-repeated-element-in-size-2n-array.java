class Solution {
    public int repeatedNTimes(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            int num=map.get(nums[i]);
            if(num==n/2)
            {
                ans = nums[i];
            }
        }
        return ans;
    }
}