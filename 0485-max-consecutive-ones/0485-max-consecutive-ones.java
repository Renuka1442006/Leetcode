class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt=0;
        int maxcnt=0;
        for(int num:nums)
        {
            if(num==1)
            {
                cnt++;
                maxcnt=Math.max(cnt,maxcnt);
            }
            else
            {
                cnt=0;
            }
        }
        return maxcnt;
    }
}