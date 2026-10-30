class Solution {
    int solve(int n,int[]dp)
    {
        if(n==1 || n==0)
        {
            return 1;
        }
        if(dp[n]!=0)
        {
            return dp[n];
        }
        dp[n]=solve(n-1,dp)+solve(n-2,dp);
        return dp[n];
    }
    public int climbStairs(int n) {
        // //Recursive approach
        // if(n==1 || n==0)
        // {
        //     return 1;
        // }
        // return climbStairs(n-1)+climbStairs(n-2);

        //time complexity O(2N)
        //space complexity O(n)

        //DP Top-Dowm Memoization
        int[] dp=new int[n+1];
        return solve(n,dp);
    }
}