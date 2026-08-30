class Solution {
    public int minimumDeletions(int[] nums) {
        int minidx=0;
        int maxidx=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<nums[minidx])
            {
                minidx=i;
            }
            if(nums[i]>nums[maxidx])
            {
                maxidx=i;
            }
        }
        int first=Math.min(minidx,maxidx);
        int second=Math.max(minidx,maxidx);

        int fromfront=second+1;
        int fromback=n-first;
        int fromboth=(first+1)+(n-second);
        return Math.min(fromfront,Math.min(fromback,fromboth));
    }
}