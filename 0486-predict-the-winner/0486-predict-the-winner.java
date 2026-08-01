class Solution {
    int solve(int i, int j, int[] nums)
    {
        if(i>j)
        {
            return 0;
        }
        if(i==j)
        {
            return nums[i];
        }
        int first=nums[i]+Math.min(solve(i+2,j,nums),solve(i+1,j-1,nums));
        int second=nums[j]+Math.min(solve(i,j-2,nums),solve(i+1,j-1,nums));
        return Math.max(first,second);
    }
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        int total_score=0;
        for(int i=0;i<n;i++)
        {
            total_score+=nums[i];
        }
        int p1score=solve(0,n-1,nums);
        int p2score=total_score-p1score;

        return p1score>=p2score;
        
    }
}