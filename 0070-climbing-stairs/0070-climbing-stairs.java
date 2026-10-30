class Solution {
    //This is the Memoization
    // int solve(int n,int[]dp)
    // {
    //     if(n==1 || n==0)
    //     {
    //         return 1;
    //     }
    //     if(dp[n]!=0)
    //     {
    //         return dp[n];
    //     }
    //     dp[n]=solve(n-1,dp)+solve(n-2,dp);
    //     return dp[n];
    // }
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
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        //return solve(n,dp);
        return dp[n];
    }
}